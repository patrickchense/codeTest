package leetcode.tree;

import leetcode.TreeNode;

/*
@BinaryTree
https://leetcode.com/problems/maximum-binary-tree/description/
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    /
     2  0
       \
        1
Note:
The size of the given array will be in the range [1,1000].


solution: recursion

 */
public class MaximumBinaryTree {

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        System.out.println(constructMaximumBinaryTree(nums));
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    public static TreeNode buildTree(int[] nums, int i, int j) {
        if (i == j) return null;
        int max_i = findMax(nums, i, j);
        TreeNode node = new TreeNode(nums[max_i]);
        node.left = buildTree(nums, i, max_i);
        node.right = buildTree(nums, max_i + 1, j);
        return node;
    }

    public static int findMax(int[] nums, int i, int j) {
        int max_i = i;
        for (int k = i + 1; k < j; k++) {
            if (nums[k] > nums[max_i]) max_i = k;
        }
        return max_i;
    }
}
