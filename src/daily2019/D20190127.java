package daily2019;

import util.TreeNode;

/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
 A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

@Google

        Tree 2
          10
        /    \
      4       6
       \
        30


        Tree 1
              26
            /   \
          10     3
        /    \     \
      4       6      3
       \
        30

https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/  好像只要一次递归？我的方式有问题

subtree 问题，找到root，然后分别比较left 和 right

@solved
@binarytree
@review

相关的subtree问题
https://www.geeksforgeeks.org/subtree-given-sum-binary-tree/
https://www.geeksforgeeks.org/check-if-the-given-binary-tree-have-a-subtree-with-equal-no-of-1s-and-0s/
https://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/

 */
public class D20190127 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(30);
        n2.right = n4;
        n1.left = n2;
        n1.right = n3;

        TreeNode t1 = new TreeNode(26);
        TreeNode t2 = new TreeNode(10);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(30);

        t3.right = t5;
        t2.left = t3;
        t2.right = t4;
        t1.left = t2;

        TreeNode t6 = new TreeNode(3);
        TreeNode t7 = new TreeNode(3);

        t6.right = t7;
        t1.right = t6;

        System.out.println(isSubTree(t1, n1));
    }

    public static boolean isSubTree(TreeNode parent, TreeNode sub) {
        TreeNode start = findStart(parent, sub.val);

        if (start == null) return false;

        return compareBT(start, sub);
    }

    private static boolean compareBT(TreeNode start, TreeNode sub) {
        if (start == null && sub == null) return true;
        if (start == null || sub == null) return false;
        if (start.val != sub.val) return false;
        return compareBT(start.left, sub.left) && compareBT(start.right, sub.right);
    }

    private static TreeNode findStart(TreeNode parent, int val) {
        if (parent != null && parent.val == val) {
            return parent;
        }
        if (parent == null) return null;
        TreeNode res = findStart(parent.left, val);
        if (res != null) return res;
        return findStart(parent.right, val);
    }
}
