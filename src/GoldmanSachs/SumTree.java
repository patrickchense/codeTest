package GoldmanSachs;

import util.BTNode;

/*

 */
public class SumTree {
    BTNode root;

    /* A utility function to get the sum of values in tree with root
     as root */
    static int sum(BTNode node) {
        if (node == null)
            return 0;
        return sum(node.left) + node.val + sum(node.right);
    }

    /* returns 1 if sum property holds for the given
       node and both of its children */
    static int isSumTree(BTNode node) {
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
        BTNode head = new BTNode(26);
        head.left = new BTNode(10);
        head.right = new BTNode(3);
        head.left.left = new BTNode(4);
        head.left.right = new BTNode(6);
        head.right.right = new BTNode(3);

        if (isSumTree(head) != 0)
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");
    }
}
