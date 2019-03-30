package daily2019;

import util.BTNode;

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
        BTNode node = new BTNode();
        node.val = 10;
        BTNode node1 = new BTNode();
        node1.val = 5;
        node.left = node1;
        BTNode node2 = new BTNode();
        node2.val = 30;
        node.right = node2;
        BTNode node21 = new BTNode();
        node21.val = 22;
        node2.left = node21;
        BTNode node22 = new BTNode();
        node22.val = 35;
        node2.right = node22;

        System.out.println(findNextInOrder(node, 22));

        BTNode node211 = new BTNode();
        node211.val = 19;
        node21.left = node211;

        BTNode node2111 = new BTNode();
        node2111.val = 15;
        node211.left = node2111;

        BTNode node2112 = new BTNode();
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

    public static int findNextInOrder(BTNode root, int target) {
        if(root == null) return -1;
        List<Integer> inOrderVals = new ArrayList<>();
        root.inOrder(root, inOrderVals);
        int index = inOrderVals.indexOf(target);
        if (index != -1) {
            return inOrderVals.get(index + 1);
        }
        return -1;
    }

    public static void findNextInOrderBetter(BTNode root, int target, int last, Boolean nextOne, Integer result) {

    }
}
