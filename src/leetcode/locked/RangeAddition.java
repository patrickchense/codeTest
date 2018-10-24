package leetcode.locked;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
leetcode 370
https://www.programcreek.com/2014/07/leetcode-range-addition-java/

Assume you have an array of length n initialized with all 0's and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex]
 (startIndex and endIndex inclusive) with inc.
Return the modified array after all k operations were executed.

solution:
1. using map
 */
public class RangeAddition {

    // O(n^2)  O(n)
    public static int[] rangeAddition(int[] nums, int[][] triplet) {
        Map<Integer, Integer> vals = new HashMap<>();
        for (int[] tri : triplet) {
            for (int i = tri[0]; i <= tri[1]; i++) {
                int tmp = vals.getOrDefault(i, 0) + tri[2];
                vals.put(i, tmp);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (vals.containsKey(i)) {
                nums[i] += vals.get(i);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        Arrays.fill(nums, 0);
        int[][] triplet = new int[][]{{1, 3, 1}, {2, 6, -3}};
        rangeAddition(nums, triplet);
        System.out.println(Arrays.toString(nums));
        nums = getModifiedArray(10, triplet);
        System.out.println(Arrays.toString(nums));
    }

    //O(n)
    /*
    very smart,  res[i] ... res[j] using [i] just  res[i+1] == res[i]  i+n < j
    using res[j+1] to nagetive to reducing the amount  res[j+1] = -res[j]
     */
    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        if(updates==null||updates.length==0)
            return result;
        // 0, -1, -3, 0, -1, 0, 0, 0, 3
        for(int i=0; i<updates.length; i++){
            result[updates[i][0]] += updates[i][2];
            if(updates[i][1]<length-1){
                result[updates[i][1]+1] -=updates[i][2];
            }
            System.out.println(Arrays.toString(result));
        }
        System.out.println("--------------");
        int v=0;
        for(int i=0; i<length; i++){
            v += result[i];
            result[i]=v;
            System.out.println(Arrays.toString(result));
        }
        //0, -1, -4,
        return result;
    }

    /*
    leetcode 598
    https://leetcode.com/problems/range-addition-ii/
    Given an m * n matrix M initialized with all 0's and several update operations.

Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b,
which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.

You need to count and return the number of maximum integers in the matrix after performing all the operations.

Example 1:
Input:
m = 3, n = 3
operations = [[2,2],[3,3]]
Output: 4
Explanation:
Initially, M =
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]

After performing [2,2], M =
[[1, 1, 0],
 [1, 1, 0],
 [0, 0, 0]]

After performing [3,3], M =
[[2, 2, 1],
 [2, 2, 1],
 [1, 1, 1]]

So the maximum integer in M is 2, and there are four of it in M. So return 4.
Note:
The range of m and n is [1,40000].
The range of a is [1,m], and the range of b is [1,n].
The range of operations size won't exceed 10,000.
     */

    public int maxCount(int m, int n, int[][] ops) {
        int row = m;
        int col = n;
        for (int[] op : ops) {
            // op[0]是横坐标
            row = Math.min(row, op[0]);
            // op[1]是纵坐标
            col = Math.min(col, op[1]);
        }
        // row * col是左上角的元素个数
        return row * col;
    }


}
