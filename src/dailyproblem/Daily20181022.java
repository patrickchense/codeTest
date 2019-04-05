package dailyproblem;

import util.ArrayUtil;

import java.util.Deque;
import java.util.LinkedList;

/*
Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)
Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.

@Google
@array
@optimize ??
@slidewindow
@answered
@review

https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
用deque来解决

slidewindow的问题，可以用deque来解决(linkedList)

相关问题
https://www.geeksforgeeks.org/maximum-subarray-size-subarrays-size-sum-less-k/
https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/
https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/
https://www.geeksforgeeks.org/maximum-possible-sum-window-array-elements-window-array-unique/
https://www.geeksforgeeks.org/number-subarrays-whose-minimum-maximum/
https://www.geeksforgeeks.org/count-subarrays-whose-maximum-element-greater-k/
https://www.geeksforgeeks.org/maximum-sum-lengths-non-overlapping-subarrays-k-max-element/
 */
public class Daily20181022 {

    public static void main(String[] args) {
        subArrayKMax(new int[]{10, 5, 2, 7, 8, 7}, 3);
    }

    /*
O(2n) -> O(n)

用queue，初始化， 留下最大的在第一， 剩下的，可能跟着,  0， 1， 2
打印，第一个
    判断，第一个是不是超出 i < j -k,  remove, 循环，剩下的都是不超出的， 1， 2
    把最大的移到第一个，  3
打印
    3，不超出，留着
    8，移到第一个， 4,  arr[3]被删除
打印
    7，不超出， 4, 5
最后打印一次

 */
    public static void subArrayKMax(int[] arr, int k) {
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window) elements of array */
        int i;
        for(i = 0; i < k; ++i)
        {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while(!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();   // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for( ;i < arr.length; ++i)
        {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which are out of this window
            while((!Qi.isEmpty()) && Qi.peek() <= i-k)
                Qi.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();


            // Add current element at the rear of Qi
            Qi.addLast(i);

        }

        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);

    }
}
