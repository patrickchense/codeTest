package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

/**
 * AsynchronousServerSocketChannel example
 * 1. using channel.accept
 * 2. using channel.read
 */
public class AsyncChannelExp {

    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel
                .open()
                .bind(new InetSocketAddress(8888));

        serverChannel.accept(serverChannel, new CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel>() {
            @Override
            public void completed(AsynchronousSocketChannel result, AsynchronousServerSocketChannel attachment) {
                serverChannel.accept(serverChannel, this);
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                /**连接客户端成功后注册 read 事件**/
                result.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        /**IO 可读事件出现的时候，读取客户端发送过来的内容**/
                        attachment.flip();
                        System.out.println(Charset.forName("utf-8").decode(attachment));
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {

                    }
                    /**省略无关紧要的方法**/
                });
            }

            @Override
            public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {

            }
            /**省略无关紧要的方法**/
        });

    }
}
