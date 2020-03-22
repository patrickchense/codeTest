package nio;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.NonWritableChannelException;
import java.nio.file.*;

/**
 * refer to https://www.baeldung.com/java-lock-files
 */
public class ChannelLockExp {

    public void lock(String path) throws IOException {
        try (FileChannel channel = FileChannel.open(Paths.get(path), StandardOpenOption.APPEND)) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        // write lock
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             FileChannel channel = fileOutputStream.getChannel();
             FileLock lock = channel.lock()) {
            // write to the channel
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write lock using Path
        Path path1 = Paths.get(path);
        try (FileInputStream fis = new FileInputStream(path1.toFile());
             FileLock lock = fis.getChannel().lock()) {
            // unreachable code
        } catch (NonWritableChannelException | FileNotFoundException e) {
            // handle exception
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read lock
        try (FileChannel channel = FileChannel.open(path1, StandardOpenOption.READ);
             FileLock lock = channel.lock(0, Long.MAX_VALUE, true)) {
            // read from the channel
        } catch (IOException e) {

        }

        // read lock using fileInputStream
        try (FileInputStream fileInputStream = new FileInputStream("/tmp/testfile.txt");
             FileChannel channel = fileInputStream.getChannel();
             FileLock lock = channel.lock(0, Long.MAX_VALUE, true)) {
            // read from the channel
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //RandomAccessFile
        try (RandomAccessFile file = new RandomAccessFile(path, "r");
             FileChannel channel = file.getChannel();
             FileLock lock = channel.lock(0, Long.MAX_VALUE, true)) {
            // read from the channel
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path2 = Files.createTempFile("foo","txt");
        try (FileOutputStream fis = new FileOutputStream(path2.toFile());
             FileLock lock = fis.getChannel().lock(0, Long.MAX_VALUE, true)) {
            // unreachable code
        } catch (NonWritableChannelException e) {
            // handle exception
        }
    }
}
