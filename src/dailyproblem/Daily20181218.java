package dailyproblem;

import java.util.Stack;

/*
Given an array of numbers, find the length of the longest increasing subsequence in the array. The subsequence does not necessarily have to be contiguous.

For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.

@Microsoft
@array
@subarray
@dp
@answered
@LIS
@review
@classic

非连续增长子序列, 典型dp

d(i) = d(i-1) + 1 if a(i) > a(i-1) else d(i) = 1;
https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/  说实话没看懂！！！！！

正确的算法
lenOfLongIncSubArr(arr, n)
    Declare max = 1, len = 1
    for i = 1 to n-1
    if arr[i] > arr[i-1]
        len++
    else
        if max < len
            max = len
        len = 1
    if max < len
        max = len
    return max

典型LIS问题
https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
https://www.geeksforgeeks.org/longest-increasing-subarray-with-one-change-allowed/
https://en.wikipedia.org/wiki/Longest_increasing_subsequence
https://www.geeksforgeeks.org/longest-increasing-subarray/  还是contiguous , 但是O(n), O(1)
 */
public class Daily20181218 {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(longestIncreasingSubsequenceLength(arr, arr.length));
    }

    // 这个不对，这个是contiguous的序列，需要不contiguous
    public static int distanceIncreasingSubArray(int[] arr) {
        int[] d = new int[arr.length];
        d[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                d[i] = d[i-1] + 1;
            } else {
                d[i] = 1;
            }
        }
        int len = d[0];
        for (int l : d) {
            len = Math.max(l, len);
        }
        return len;
    }

    // dp，用stack, 要记录前面一个小的，还是不对？？？？
    public static int distanceIncreasingSubArrayNotContiguous(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] d = new int[arr.length];
        d[0] = 1;
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > stack.peek()) {
                stack.push(arr[i]);
                d[i] = stack.size();
            }
            else {
                while(stack.peek() > arr[i]) stack.pop();
                stack.push(arr[i]);
                d[i] = stack.size();
            }
        }

        int len = d[0];
        for (int l : d) {
            len = Math.max(l, len);
        }
        return len;
    }

    public static int maxSumIS(int arr[], int n)
    {
        int i, j, max = 0;
        int msis[] = new int[n];

        /* Initialize msis values
           for all indexes */
        for (i = 0; i < n; i++)
            msis[i] = arr[i];

        /* Compute maximum sum values
           in bottom up manner */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] &&
                        msis[i] < msis[j] + arr[i])
                    msis[i] = msis[j] + arr[i];

        /* Pick maximum of all
           msis values */
        for (i = 0; i < n; i++)
            if (max < msis[i])
                max = msis[i];

        return max;
    }

    // O(n) O(1)
    public static int lenOfLongIncSubArr(int arr[],
                                         int n)
    {
        // 'max' to store the length of longest
        // increasing subarray
        // 'len' to store the lengths of longest
        // increasing subarray at diiferent
        // instants of time
        int max = 1, len = 1;

        // traverse the array from the 2nd element
        for (int i=1; i<n; i++)
        {
            // if current element if greater than
            // previous element, then this element
            // helps in building up the previous
            // increasing subarray encountered
            // so far
            if (arr[i] > arr[i-1])
                len++;
            else
            {
                // check if 'max' length is less
                // than the length of the current
                // increasing subarray. If true,
                // than update 'max'
                if (max < len)
                    max = len;

                // reset 'len' to 1 as from this
                // element again the length of the
                // new increasing subarray is being
                // calculated
                len = 1;
            }
        }

        // comparing the length of the last
        // increasing subarray with 'max'
        if (max < len)
            max = len;

        // required maximum length
        return max;
    }

    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    static int longestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one

        int[] tailTable = new int[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len - 1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
        }

        return len;
    }
}
