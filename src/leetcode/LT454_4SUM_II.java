package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/4sum-ii/
@medium
@answered

Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1
 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0



 */
public class LT454_4SUM_II {

    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}));
    }


    /*
        两个数组是  N ^ 2 + N ^ 2, 然后计算和==0 ，存在就是有
        算法对的，。。。。超时了？咋办
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int[] sum1 = new int[A.length * A.length];
        int[] sum2 = new int[B.length * B.length];
        int k = 0;
        for (int i =0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sum1[k++] = A[i] + B[j];
            }
        }
        k = 0;
        for (int i =0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                sum2[k++] = C[i] + D[j];
            }
        }
        Arrays.sort(sum1);
        Arrays.sort(sum2);
        int res = 0;
        for (int i = 0, j=sum2.length-1; j>= 0 && i < sum1.length;) {
            if (sum1[i] + sum2[j] == 0) {
                res++;
                if (sum1[i] == 0) res++;
                while(i+1 < sum1.length && sum1[i++] == sum1[i]) {
                    res++;
                }
                while(j-1 >= 0 && sum2[j--] == sum2[j]) {
                    res++;
                }

            }
            else if (sum1[i] + sum2[j] > 0) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }

    // 用hashmap, 才是最好的，存2个数组的值，减掉另两个
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int res = 0, n = A.length;
        Map<Integer, Integer> sums = new HashMap<>();

        for (int a = 0; a < n; a++) for (int b = 0; b < n; b++) {
            sums.put(A[a] + B[b], sums.getOrDefault(A[a] + B[b], 0) + 1);
        }

        for (int c = 0; c < n; c++) for (int d = 0; d < n; d++) {
            res += sums.getOrDefault(-C[c] - D[d], 0);
        }

        return res;
    }
}
