package dailyproblem;

import util.BTNode;

/*
Given the root to a binary search tree, find the second largest node in the tree.

@dropbox
@binarytree
@solved
@review

https://www.geeksforgeeks.org/second-largest-element-in-binary-search-tree-bst/

    10
      /   \
    5      20
             \
              30

看看更好的解法 kth
https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/
 */
public class Daily20181109 {

    public static void main(String[] args) {
        BTNode n = new BTNode(10);
        BTNode n1 = new BTNode(5);
        BTNode n2 = new BTNode(20);
        BTNode n3 = new BTNode(30);
        n.left = n1;
        n.right = n2;
        n2.right = n3;
        System.out.println(secondLargest(n, max(n)).val);

    }

    //自己的解法，找到max，找到max-val 最小， 2次dfs
    public static int max(BTNode root) {
        if (root == null) return 0;
        int max = root.val;
        if (root.left != null) max = Math.max(max, max(root.left));
        if (root.right != null) max = Math.max(max, max(root.right));
        return max;
    }

    public static BTNode secondLargest(BTNode root, int max) {
        if (root == null) return null;
        BTNode min = root;
        int minval = (max - root.val);
        if (minval == max) minval = Integer.MAX_VALUE;
        if (root.left != null) {
            BTNode leftMin = secondLargest(root.left, max);
            if (leftMin.val != max && minval > max - leftMin.val) {
                minval = max - leftMin.val;
                min = leftMin;
            }

        }
        if (root.right != null) {
            BTNode rightMin = secondLargest(root.right, max);
            if (rightMin.val != max && minval > max - rightMin.val) {
                minval = max - rightMin.val;
                min = rightMin;
            }
        }
        return min;
    }
}
