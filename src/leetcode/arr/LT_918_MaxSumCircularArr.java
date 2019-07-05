package leetcode.arr;

/*
https://leetcode.com/problems/maximum-sum-circular-subarray/
Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)


@answered
@dp
@optimize
@review

其实还没搞懂逻辑
简单的是
1. 计算最大的sum
2. 计算 右边的和
3. 计算右边最大和的dp

然后计算公式就是， 每个位置的 sum = leftsum+maxright[i+2],

优化？

 */
public class LT_918_MaxSumCircularArr {

    public int maxSubarraySumCircular(int[] A) {
        int N = A.length;

        int ans = A[0], cur = A[0];
        for (int i = 1; i < N; ++i) {
            cur = A[i] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }

        // ans is the answer for 1-interval subarrays.
        // Now, let's consider all 2-interval subarrays.
        // For each i, we want to know
        // the maximum of sum(A[j:]) with j >= i+2

        // rightsums[i] = A[i] + A[i+1] + ... + A[N-1]
        int[] rightsums = new int[N];
        rightsums[N-1] = A[N-1];
        for (int i = N-2; i >= 0; --i)
            rightsums[i] = rightsums[i+1] + A[i];

        // maxright[i] = max_{j >= i} rightsums[j]
        int[] maxright = new int[N];
        maxright[N-1] = A[N-1];
        for (int i = N-2; i >= 0; --i)
            maxright[i] = Math.max(maxright[i+1], rightsums[i]);

        int leftsum = 0;
        for (int i = 0; i < N-2; ++i) {
            leftsum += A[i];
            ans = Math.max(ans, leftsum + maxright[i+2]);
        }

        return ans;
    }


    // optimize
    private int kadanes(int[] a){
        int n = a.length;
        int sum = a[0], answer = a[0];
        for(int i=1; i<a.length; i++){
            sum += a[i];
            if(sum < a[i]) sum = a[i];
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    public int maxSubarraySumCircular2(int[] A) {
        if(A.length == 0) return 0;
        int x = kadanes(A);
        int y = 0;
        for(int i=0; i<A.length;i++){
            y += A[i];
            A[i] *= -1;
        }
        int z = kadanes(A);
        return (y+z == 0) ? x : Math.max(x, y+z);
    }
}
