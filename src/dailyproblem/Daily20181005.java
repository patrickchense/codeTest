package dailyproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

 */

/*
source https://leetcode.com/problems/two-sum/description/  two sum, could use Map, then O(n)
其他变形：
2. TODO 多数相加=target, 然后所有的组合
    https://leetcode.com/problems/combination-sum-ii/description/

3. 多数相加=target，可以重复多次使用任意一个数，所有的组合
    https://leetcode.com/problems/combination-sum-iv/description/
4. 给k, n, k是几个数，n是target，1-9，k个数组合sum=n
    https://leetcode.com/problems/combination-sum-iii/description/
5. two sum，sorted array
    https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
6. no duplicates numbers, 所有的组合sum=target，可以重复使用数字，应该和前面的3是一样的
    https://leetcode.com/problems/combination-sum/description/
7. TODO target，是连续数字的和，求这些组合
    https://leetcode.com/problems/consecutive-numbers-sum/description/
8.  二叉树，target，存在两个nodesum=target
    https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/ 二叉树，target，存在两个nodesum=target
9.  Two Sum III - Data structure design leetcode 170
10. <h>两个数除法，取余，不用mod 和 divide， FB 碰到了<h>
    https://leetcode.com/problems/divide-two-integers/description/
11. TODO 二叉树，sum root到leaf组合的数字
    {@link https://leetcode.com/problems/sum-root-to-leaf-numbers/description/}

 */
public class Daily20181005 {

    public static void main(String[] args) {
        int array[] = new int[]{10, 15, 3, 7};
        int target = 17;
        boolean exists = findTwoSum(array, target);
        System.out.println(exists);
    }

    /*
        O(nlogn)
     */
    private static boolean findTwoSum(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while(i <= j) {
            if (nums[i] + nums[j] == target) {
                return true;
            }else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    /*
    brute force  O(n^2)
     */
/*    private static boolean findTwoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) break;
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                } else if (nums[i] + nums[j] > target) {
                    len = j;
                    break;
                }
            }
        }
        return false;
    }*/
}
