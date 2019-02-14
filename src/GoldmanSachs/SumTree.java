package GoldmanSachs;

import util.TreeNode;

/*

 */
public class SumTree {
    TreeNode root;

    /* A utility function to get the sum of values in tree with root
     as root */
    static int sum(TreeNode node) {
        if (node == null)
            return 0;
        return sum(node.left) + node.val + sum(node.right);
    }

    /* returns 1 if sum property holds for the given
       node and both of its children */
    static int isSumTree(TreeNode node) {
        int ls, rs;

        /* If node is NULL or it's a leaf node then
           return true */
        if ((node == null) || (node.left == null && node.right == null))
            return 1;

        /* Get sum of nodes in left and right subtrees */
        ls = sum(node.left);
        rs = sum(node.right);

        /* if the node and both of its children satisfy the
           property return 1 else 0*/
        if ((node.val == ls + rs) && (isSumTree(node.left) != 0)
                && (isSumTree(node.right)) != 0)
            return 1;

        return 0;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        TreeNode head = new TreeNode(26);
        head.left = new TreeNode(10);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(6);
        head.right.right = new TreeNode(3);

        if (isSumTree(head) != 0)
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");
    }
}
