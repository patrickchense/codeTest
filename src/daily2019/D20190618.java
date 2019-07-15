package daily2019;

import util.BTNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
In Ancient Greece, it was common to write text with the first line going left to right, the second line going right to left, and continuing to go back and forth. This style was called "boustrophedon".

Given a binary tree, write an algorithm to print the nodes in boustrophedon order.

For example, given the following tree:

       1
    /     \
  2         3
 / \       / \
4   5     6   7
You should return [1, 3, 2, 4, 5, 6, 7].

@easy
@Morgan Stanley

// loop by level & print by order

@solved
@binarytree
@levelloop

review the code of binary tree level loop

 */
public class D20190618 {

    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        BTNode l1 = new BTNode(2);
        BTNode r1 = new BTNode(3);
        root.left = l1;
        root.right = r1;
        BTNode l1l1 = new BTNode(4);
        BTNode l1r1 = new BTNode(5);
        l1.left = l1l1;
        l1.right = l1r1;
        BTNode r1l1 = new BTNode(6);
        BTNode r1r1 = new BTNode(7);
        r1.left = r1l1;
        r1.right = r1r1;

        System.out.println(boustrophedon(root));

    }

    public static String boustrophedon(BTNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<BTNode> queue = new LinkedList<BTNode>();
        queue.offer(root);
        int l = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            StringBuilder tmp = new StringBuilder();
            for(int i = 0;i < size ;i++){
                BTNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                tmp.append(node.val);
            }
            if (l % 2 == 0) {
                sb.append(tmp);
            } else {
                sb.append(tmp.reverse());
            }
            l++;
        }
        return sb.toString();
    }

}
