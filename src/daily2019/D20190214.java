package daily2019;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*

Given a node in a binary search tree, return the next bigger element, also known as the inorder successor.

For example, the inorder successor of 22 is 30.

   10
  /  \
 5    30
     /  \
   22    35
You can assume each node has a parent pointer.

   10
  /  \
 5    30
     /  \
   22    35
   /
  19
  /\
 15 21
@amazon


 */
public class D20190214 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.val = 10;
        TreeNode node1 = new TreeNode();
        node1.val = 5;
        node.left = node1;
        TreeNode node2 = new TreeNode();
        node2.val = 30;
        node.right = node2;
        TreeNode node21 = new TreeNode();
        node21.val = 22;
        node2.left = node21;
        TreeNode node22 = new TreeNode();
        node22.val = 35;
        node2.right = node22;

        System.out.println(findNextInOrder(node, 22));

        TreeNode node211 = new TreeNode();
        node211.val = 19;
        node21.left = node211;

        TreeNode node2111 = new TreeNode();
        node2111.val = 15;
        node211.left = node2111;

        TreeNode node2112 = new TreeNode();
        node2112.val = 21;
        node211.right = node2112;

        System.out.println(findNextInOrder(node, 10));
        System.out.println(findNextInOrder(node, 21));
    }

    public static int findNextInOrder(TreeNode root, int target) {
        if(root == null) return -1;
        List<Integer> inOrderVals = new ArrayList<>();
        root.inOrder(root, inOrderVals);
        int index = inOrderVals.indexOf(target);
        if (index != -1) {
            return inOrderVals.get(index + 1);
        }
        return -1;
    }
}
