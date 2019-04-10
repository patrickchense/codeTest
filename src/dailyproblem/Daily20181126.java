package dailyproblem;

import java.util.Stack;

/*
Implement a queue using two stacks.
 Recall that a queue is a FIFO (first-in, first-out) data structure with the following methods:
  enqueue, which inserts an element into the queue, and dequeue, which removes it.

@Apple
@queue
@stack
@solved

 */
public class Daily20181126 {

    public static void main(String[] args) {

    }

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int size = 0;

    // O(1)
    public void enqueue(Integer a) {
        s1.add(a);
        size++;
    }

    // O(n)
    public Integer dequeue() throws Exception {
        if (!s2.isEmpty()) {
            size--;
            return s2.pop();
        }
        if (s1.isEmpty()) throw new Exception("queue is empty");
        while(!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        size--;
        return s2.pop();
    }

}
