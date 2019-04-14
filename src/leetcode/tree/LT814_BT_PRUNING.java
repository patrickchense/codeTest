package leetcode.tree;

import util.BTNode;

/*
https://leetcode.com/problems/binary-tree-pruning/
We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

Example 1:
Input: [1,null,0,0,1]
Output: [1,null,0,null,1]

Example 2:
Input: [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]

Example 3:
Input: [1,1,0,1,1,0,1,0]
Output: [1,1,0,1,1,null,1]

DFS就可以吧，后序遍历，然后判断子树是不是需要==null


@solved
@binarytree
@pruning
@10min

 */
public class LT814_BT_PRUNING {

    public static void main(String[] args) {
        BTNode n1 = new BTNode(1);
        BTNode n2 = new BTNode(0);
        BTNode n3 = new BTNode(0);
        BTNode n4 = new BTNode(1);
        n1.right = n2;
        n2.left = n3;
        n2.right = n4;
        pruning(n1);
        StringBuilder sb = new StringBuilder();
        n1.printPreorder(n1, sb);
        System.out.println(sb.toString());
    }

    public static boolean pruning(BTNode root) {
        if (root == null) return true;
        boolean isLeft = true;
        boolean isRight = true;
        if (root.left != null) {
            if (pruning(root.left)) {
                root.left = null;
            }
            else {
                isLeft = false;
            }
        }
        if (root.right != null) {
            if (pruning(root.right)) {
                root.right = null;
            } else {
                isRight = false;
            }
        }
        return root.val == 0 && isLeft && isRight;
    }
}
