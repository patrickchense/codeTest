package daily2019;

import java.util.ArrayDeque;
import java.util.Queue;

/*
Given a list of integers and a number K, return which contiguous elements of the list sum to K.

For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4].

@Lyft
@dp

@solved

 */
public class D20190114 {
    public static void main(String[] args) {
        printQueue(continousSumK(new int[]{1, 2, 3, 4, 5}, 9));
    }

    public static void printQueue(Queue q) {
        System.out.println("[");
        while(q.peek() != null) {
            System.out.println(q.poll() + ",");
        }
        System.out.println("]");
    }
    /* d[i] = d[i-1] + s[i]
        if d[i] == k return

     */
    public static Queue<Integer> continousSumK(int[] ints, int k) {
        Queue<Integer> vals = new ArrayDeque<>();
        int sum = 0;
        for (int i : ints) {
            if (sum + i == k) {
                vals.add(i);
                break;
            }
            else if (sum + i < k) {
                vals.add(i);
                sum += i;
            } else {
                sum += i;
                vals.add(i);
                while(sum > k) {
                    int t = vals.poll();
                    sum -= t;
                }
                if (sum == k) {
                    break;
                }
            }
        }
        return vals;
    }
}
