package daily2019;

import util.TreeNode;

import java.util.*;

/*
Given the root of a binary search tree, and a target K, return two nodes in the tree whose sum equals K.

For example, given the following tree and K of 20

    10
   /   \
 5      15
       /  \
     11    15
Return the nodes 5 and 15.

@Google
@binarytree
@solved

@review

https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/  这里有个改进的不是O(1) 而是O(logn)space
https://www.geeksforgeeks.org/find-if-there-is-a-triplet-in-bst-that-adds-to-0/
https://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/
https://www.geeksforgeeks.org/find-pairs-with-given-sum-such-that-pair-elements-lie-in-different-bsts/

这里还涉及一些BST和array的转换
https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/
https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
 */
public class D20190206 {


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(11);
        TreeNode n2 = new TreeNode(15);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(10);
        n3.left = n1;
        n3.right = n2;
        n5.left = n4;
        n5.right = n3;

        findTwoNodeSumToTarget(20, n5);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(findByTwoInOrderTraverse(20, n5)));


    }


    private static Map<Integer, TreeNode> nodes = new HashMap<>();
    private static TreeNode[] result = new TreeNode[2];
    //binary tree 找2个点sum=target，最简单map保存，然后处理， O(n) space, O(n) time
    public static void findTwoNodeSumToTarget(int target, TreeNode head) {
        if (head == null) return;
        if (nodes.containsKey(target - head.val)) {
            result[0] = head;
            result[1] = nodes.get(target - head.val);
            return;
        }
        else {
            nodes.put(head.val, head);
        }
        if (head.left != null) {
            findTwoNodeSumToTarget(target, head.left);
        }
        if (head.right != null) {
            findTwoNodeSumToTarget(target, head.right);
        }
    }

    // 能不能不用map, O(1) space? 怎么利用binarytree的特点？

    /*
    A space optimized solution is discussed in previous post. The idea was to first in-place convert BST to Doubly Linked List (DLL), then find pair in sorted DLL in O(n) time. This solution takes O(n) time and O(Logn) extra space, but it modifies the given BST.

The solution discussed below takes O(n) time, O(Logn) space and doesn’t modify BST. The idea is same as finding the pair in sorted array (See method 1 of this for details).
We traverse BST in Normal Inorder and Reverse Inorder simultaneously. In reverse inorder, we start from the rightmost node which is the maximum value node.
In normal inorder, we start from the left most node which is minimum value node. We add sum of current nodes in both traversals and compare this sum with given target sum.
If the sum is same as target sum, we return true. If the sum is more than target sum, we move to next node in reverse inorder traversal, otherwise we move to next node in normal inorder traversal.
If any of the traversals is finished without finding a pair, we return false. Following is C++ implementation of this approach.
     */

    public static int[] findByTwoInOrderTraverse(int target, TreeNode head) {
        List<Integer> vals = new ArrayList<>();
        head.inOrder(head, vals);
        int start = 0;
        int end = vals.size() -1;
        while (start < end) {
            int sum = vals.get(start) + vals.get(end);
            if (sum == target) {
                return new int[]{vals.get(start), vals.get(end)};
            }
            if (sum > target) end--;
            if (sum < target) start++;
        }
        return null;
    }

}
