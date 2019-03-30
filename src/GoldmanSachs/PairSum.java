package GoldmanSachs;

import util.BTNode;

import java.util.*;

/*
How many pairs of numbers are in the list which equal the sum?
They run a series of numbers with a sum at the end, you’re then asked to develop a solution which finds how many pairs of numbers are in the list which equal the sum.

questions?
    number duplicates?
    order?
    unique pair?

solutions:
first think:
    1. double for, brute force
    2. two pointers

don't understand the questions, It's more like an array of numbers and a target return the pair numbers in the array sum == target, pair == 2;

so I pick some leetcode questions similar to do

https://leetcode.com/problems/map-sum-pairs/

Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value.
If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5



https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/


related sum two
sum two input array is sorted
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

sum two input array is BST
https://leetcode.com/problems/two-sum-iv-input-is-a-bst

 */
public class PairSum {

    public static void main(String args[]) {

    }

    /*
        O(n) O(n),  find any two
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }

    /*
    O(nlogn) O(n) space
     */
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null)
            return null;
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums2);
        int a = 0, b = 0;
        int start = 0, end = nums2.length - 1;
        //find two nums
        while (start < end) {
            int sum = nums2[start] + nums2[end];
            if (sum < target)
                start++;
            else if (sum > target)
                end--;
            else {
                a = nums2[start];
                b = nums2[end];
                break;
            }
        }
        //find the index of two numbers
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) {
                res[0] = i;
                break;
            }
        }
        if (a != b) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == b) {
                    res[1] = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == b && i != res[0]) {
                    res[1] = i;
                    break;
                }
            }
        }

        return res;
    }


    /*
    input array sorted
     */
    public int[] twoSumSortedArray(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length -1;
        int[] res = new int[2];
        while (i<=j) {
            if (numbers[i]+numbers[j]==target) {
                res[0] = i+1;
                res[1] = j+1;
                return res;
            }
            else if (numbers[i]+numbers[j]>target) {
                j--;
            }
            else {
                i++;
            }
        }
        return null;
    }

    // sumtwoBSTexists find exists only
    public boolean sumtwoBSTexists(BTNode root, int k) {
        if (root == null) return false;

        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) return true;
            if (sum < k) {
                i++;
            }
            else {
                j--;
            }
        }

        return false;
    }

    private void inOrder(BTNode root, List<Integer> list) {
        if (root == null) return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
