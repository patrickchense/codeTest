package daily2019;

/*
Given a circular array, compute its maximum subarray sum in O(n) time. A subarray can be empty, and in this case the sum is 0.

For example, given [8, -1, 3, 4], return 15 as we choose the numbers 3, 4, and 8 where the 8 is obtained from wrapping around.

Given [-4, 5, 1, 0], return 6 as we choose the numbers 5 and 1.

@Facebook

@medium
@array
@subarray

@answered
@greedy

题意不是很清楚，我的理解是连续的最大sum的subarray，可以circular，返回sum
贪婪算法
https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/264620/Java-one-pass-greedy-method

https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/262726/java-simple-4ms-solution-which-beats-100
Just traverse the Array twice with Kadane algorithm to calculate minimum and maximum subarray respectively.
Then we compare totalSum - minimum and maximum to judge whether the maximum sum of subarray locate at the circular part of the array or not.
For example,
for [2 3 -3 -2 -4 1 4], the maximum circular sum locates at the circular part [1 4, 2 3].
for [1 2 3 4 5 -1] the maximum circular sum locates at the regular part [1 2 3 4 5].


这里的关键是理解，怎么判断最大sub是在circular而不是顺序， 通过 total - minSum 和 maxSum 比较

 */
public class D20190411 {

    public static void main(String[] args) {
        System.out.println(maxSumSubArrayCircular(new int[]{8, -1, 3, 4}));
        System.out.println(maxSumSubArrayCircular(new int[]{-4, 5, 1, 0}));
    }

    public static int maxSumSubArrayCircular(int[] arr) {
        int max=arr[0];
        int min=arr[0];
        int sum1=arr[0];
        int sum2=arr[0];
        int s=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            int a=arr[i];
            s+=a;
            sum1=Math.max(a,a+sum1);
            sum2=Math.min(a,a+sum2);
            max=Math.max(max,sum1);
            min=Math.min(min,sum2);
        }
        if(s==min) return max;
        return Math.max(max,s-min); // 为什么是 s-min 和 max 比较
    }

    public int maxSubarraySumCircular(int[] A) {
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int total = 0, sum = 0;
        for(int i = 0; i < A.length; i++){
            total += A[i];
            if( sum + A[i] > A[i] )
                sum += A[i];
            else
                sum = A[i];
            maxSum = Math.max(sum, maxSum);
        }
        sum = 0;
        for(int i = 0; i < A.length; i++){
            if( sum + A[i] < A[i] )
                sum += A[i];
            else
                sum = A[i];
            minSum = Math.min(sum, minSum);
        }
        return total == minSum ? maxSum : Math.max(maxSum, total - minSum);
    }
}
