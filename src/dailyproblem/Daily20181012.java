package dailyproblem;

import util.BTNode;

/*
A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1

@Google
@binarytree
@dfs
@solved

related:
https://leetcode.com/problems/maximum-binary-tree/description/

 */
public class Daily20181012 {

    public static void main(String args[]) {
        BTNode n1 = new BTNode(0);
        BTNode n2 = new BTNode(1);
        BTNode n3 = new BTNode(0);
        BTNode n4 = new BTNode(1);
        BTNode n5 = new BTNode(0);
        BTNode n6 = new BTNode(1);
        BTNode n7 = new BTNode(1);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        n4.left = n6;
        n4.right = n7;
        System.out.println(countUnivalTrees(n1));
    }

    public static int countUnivalTrees(BTNode root) {
        if (root == null) return 0;
        int count = 0;
        boolean isUnival = true;
        if (root.left != null) {
            count += countUnivalTrees(root.left);
            if (root.left.val != root.val) isUnival = false;
        }
        if (root.right != null) {
            count += countUnivalTrees(root.right);
            if (root.right.val != root.val) isUnival = false;
        }
        return (isUnival ? 1 : 0) + count;
    }
}
