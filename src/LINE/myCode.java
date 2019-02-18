package LINE;
/*
Problem statement
Implement a FIFO queue with limited size.

It should support the following commands:

SIZE
OFFER x
TAKE
x can be any string.

Input
N C
command 1
command 2...
Where N is the number of commands (1 <= N <= 10000) and C the capacity of the queue (0 <= C <= 10000).

Output
For SIZE command, the number of items currently in the queue followed by a newline.
For TAKE command, the item taken followed by a newline if the queue was not empty. Nothing otherwise.
For OFFER command, "true" if the item was accepted by the queue, or "false" otherwise, followed by a newline.
Input example
5 2
OFFER hello
OFFER world
OFFER !
TAKE
SIZE
Output example
For the above input,

true
true
false
hello
1
 */
/* package whatever; // don't place package name! */
import java.io.*;
class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] configs = input.split(" ");
        int commandSize = Integer.valueOf(configs[0]);
        int capacity = Integer.valueOf(configs[1]);
        MyQueue queue = new MyQueue(capacity);
        for (int i = 0; i < commandSize; i++) {
            String inputs = br.readLine();
            String[] commandAndParams = inputs.split(" ");
            if (commandAndParams == null) {
                throw new RuntimeException("only support [COMMAND] [PARAM] format");
            }
            if ("OFFER".equals(commandAndParams[0])) {
                System.out.println(queue.OFFER(commandAndParams[1]));
            } else if ("TAKE".equals(commandAndParams[0])) {
                String res = queue.TAKE();
                if (res != null) {
                    System.out.println(res);
                }
            } else if ("SIZE".equals(commandAndParams[0])) {
                System.out.println(queue.SIZE());
            } else {
                throw new RuntimeException("command not support!");
            }
        }
    }
}
class MyQueue {
    class Node {
        String value;
        Node next;
    }
    private Node first;
    private Node last;
    private int size = 0;
    private int capacity;

    public MyQueue(int capacity) {
        this.capacity = capacity;
    }
    int SIZE() {
        return size;
    }

    boolean OFFER(String x) {
        if (size < capacity) {
            Node n = new Node();
            n.value = x;
            if (first == null) {
                first = n;
            }
            else if (last == null) {
                last = n;
                first.next = last;
            } else {
                last.next = n;
                last = n;
            }
            size++;
            return true;
        }
        return false;
    }

    String TAKE() {
        if (size == 0) {
            return null;
        }
        else {
            Node n = first.next;
            String res = first.value;
            first = n;
            return res;
        }
    }
}
