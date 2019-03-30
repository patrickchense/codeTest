package daily2019;

import util.BTNode;

/*
Given a binary tree where all nodes are either 0 or 1, prune the tree so that subtrees containing all 0s are removed.

For example, given the following tree:

   0
  / \
 1   0
    / \
   1   0
  / \
 0   0
should be pruned to:

   0
  / \
 1   0
    /
   1
We do not remove the tree at the root or its left child because it still has a 1 as a descendant.

@BufferBox

@binarytree
@tree
@recursive
@solved
 */
public class D20190227 {
    public static void main(String[] args) {
        BTNode n1 = new BTNode(0);
        BTNode n2 = new BTNode(0);
        BTNode n3 = new BTNode(0);
        BTNode n4 = new BTNode(1);
        BTNode n5 = new BTNode(1);
        BTNode n6 = new BTNode(0);
        BTNode n7 = new BTNode(0); //root
        n4.left = n1;
        n4.right = n2;
        n7.left = n5;
        n3.left = n4;
        n3.right = n6;
        n7.right = n3;
        StringBuilder sb = new StringBuilder();
        n7.printInOrder(n7, sb);
        System.out.println(sb.toString());
        pruneBinaryTree(n7);
        sb = new StringBuilder();
        n7.printInOrder(n7, sb);
        System.out.println(sb.toString());
    }

    /*
    find sum of the subtree, if sum == 0 , subtree == null
     */
    public static int pruneBinaryTree(BTNode root) {
        if (root == null) return 0;
        int leftSum = 0;
        int rightSum = 0;
        if (root.left != null) {
            leftSum = pruneBinaryTree(root.left);
            if (leftSum == 0) root.left = null;
        }
        if (root.right != null) {
            rightSum = pruneBinaryTree(root.right);
            if (rightSum == 0) root.right = null;
        }
        return leftSum + rightSum + root.val;
    }
}
