package dailyproblem;

import util.BTNode;
import util.BTObjNode;

/*
Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.

Given the root to such a tree, write a function to evaluate it.

For example, given the following tree:

    *
   / \
  +    +
 / \  / \
3  2  4  5
You should return 45, as it is (3 + 2) * (4 + 5).

@Microsoft
@binarytree
@easy
@solved
@5min
 */
public class Daily20181123 {
    public static void main(String[] args) {
        BTObjNode n1 = new BTObjNode("*");
        BTObjNode n2 = new BTObjNode("+");
        BTObjNode n3 = new BTObjNode("+");
        BTObjNode n4 = new BTObjNode(3);
        BTObjNode n5 = new BTObjNode(2);
        BTObjNode n6 = new BTObjNode(4);
        BTObjNode n7 = new BTObjNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(calculateTree(n1));
    }

    public static int calculateTree(BTObjNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) {
            if (root.val instanceof String) {
                int left = calculateTree(root.left);
                int right = calculateTree(root.right);
                switch ((String) root.val) {
                    case "*":
                        return left * right;
                    case "-":
                        return left-right;
                    case "+":
                        return left+right;
                    case "/":
                        return left/right;
                }
            }
        }
        return (int)root.val;
    }
}
