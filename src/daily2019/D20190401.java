package daily2019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Given a stack of N elements, interleave the first half of the stack with the second half reversed using only one other queue. This should be done in-place.

Recall that you can only push or pop from a stack, and enqueue or dequeue from a queue.

For example, if the stack is [1, 2, 3, 4, 5], it should become [1, 5, 2, 4, 3]. If the stack is [1, 2, 3, 4], it should become [1, 4, 2, 3].

Hint: Try working backwards from the end state.

@Google
@Medium

@stack
@queue
@solved
@7min

 */
public class D20190401 {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s = interleave(s);
        s.stream().forEach(a -> System.out.print(a + ","));
        System.out.println();
        s.clear();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s = interleave(s);
        s.stream().forEach(a -> System.out.print(a + ","));
    }

    //O((n-1)!)
    public static Stack<Integer> interleave(Stack<Integer> s) {
        int size = s.size();
        int len = (size -1);
        Queue<Integer> queue = new LinkedList<Integer>();

        while(len > 0) {
            for (int i = 0; i < len; i++) {
                queue.add(s.pop()); // 5,4,3,2
            }
            while(!queue.isEmpty()) s.push(queue.poll()); // 1,5,4,3,2
            len--;
        }
        return s;
    }
}
