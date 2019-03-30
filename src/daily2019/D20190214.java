package daily2019;

import util.BSTNode;

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
        BSTNode node = new BSTNode();
        node.val = 10;
        BSTNode node1 = new BSTNode();
        node1.val = 5;
        node.left = node1;
        BSTNode node2 = new BSTNode();
        node2.val = 30;
        node.right = node2;
        BSTNode node21 = new BSTNode();
        node21.val = 22;
        node2.left = node21;
        BSTNode node22 = new BSTNode();
        node22.val = 35;
        node2.right = node22;

        System.out.println(findNextInOrder(node, 22));

        BSTNode node211 = new BSTNode();
        node211.val = 19;
        node21.left = node211;

        BSTNode node2111 = new BSTNode();
        node2111.val = 15;
        node211.left = node2111;

        BSTNode node2112 = new BSTNode();
        node2112.val = 21;
        node211.right = node2112;

        System.out.println(findNextInOrder(node, 10));
        int result = -1;
        findNextInOrderBetter(node, 10, -1,false, result);
        System.out.println(result);
        System.out.println(findNextInOrder(node, 21));
        result = -1;
        findNextInOrderBetter(node, 21, -1,false, result);
        System.out.println(result);


    }

    public static int findNextInOrder(BSTNode root, int target) {
        if(root == null) return -1;
        List<Integer> inOrderVals = new ArrayList<>();
        root.inOrder(root, inOrderVals);
        int index = inOrderVals.indexOf(target);
        if (index != -1) {
            return inOrderVals.get(index + 1);
        }
        return -1;
    }

    public static void findNextInOrderBetter(BSTNode root, int target, int last, Boolean nextOne, Integer result) {

    }
}
