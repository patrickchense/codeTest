package dailyproblem;

/*
Given an array of numbers, find the length of the longest increasing subsequence in the array. The subsequence does not necessarily have to be contiguous.

For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.

@Microsoft
@array
@subarray
@dp
非连续增长子序列, 典型dp

d(i) = d(i-1) + 1 if a(i) > a(i-1) else d(i) = 1;
 */
public class Daily20181218 {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(longestIncreasingSubArray(arr));
    }

    // 这个不对，这个是contiguous的序列，需要不contiguous
    public static int longestIncreasingSubArray(int[] arr) {
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

    // 修改dp公式,
}
