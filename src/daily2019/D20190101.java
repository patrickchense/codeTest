package daily2019;

import util.BTNode;

/*
Determine whether a tree is a valid binary search tree.

A binary search tree is a tree with two children, left and right, and satisfies the constraint that the key
in the left child must be less than or equal to the root and the key in the right child must be greater than or equal to the root.

@Linkedin
@bst

same to 0105

 */
public class D20190101 {

    public static void main(String[] args) {

    }

    // 这么写不对。。。
    // 没有处理left 最大 < root < right 最小的问题
    public static boolean isBST(BTNode root) {
        if (root == null) return true;

        boolean isBST = false;
        if (root.left != null) {
            isBST = root.left.val < root.val && isBST(root.left);
        }
        if (!isBST) return false;
        if (root.right != null) {
            return root.right.val > root.val && isBST(root.right);
        }
        return true;
    }


}
