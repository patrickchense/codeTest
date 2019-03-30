package GoldmanSachs;

import util.BTNode;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/amazon-interview-experience-set-328-for-sde-1/
Given a binary tree, sum all the root to leaf nodes and return the sum.

Ex:
          1
        /   \
      2      3
    /   \       \
   4     6       7

here ans: 124 + 126 + 137 = 387

solution
@recursion
@DFS

 */
public class BinaryTreeSum {
    public static int sumBinaryTree(BTNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.val;

        int sum = 0;
        List<String> substring = new ArrayList<>();
        if (node.left != null) {
            help(node.left, "", substring);
        }
        if (node.right != null) {
            help(node.right, "", substring);
        }
        for (String i : substring) {
            sum += Integer.valueOf(node.val + i);
        }
        return sum;
    }

    private static void help(BTNode node, String s, List<String> ss) {
        if (node == null) {
            ss.add(s);
            return;
        }
        if (node.left == null && node.right == null) {
            ss.add(s + node.val);
            return;
        }
        s += node.val;
        if (node.left != null) help(node.left, s, ss);
        if (node.right != null) help(node.right, s, ss);

    }

    public static void main(String[] args) {
        BTNode node = new BTNode(1);
        node.left = new BTNode(2);
        node.right = new BTNode(3);
        node.left.left = new BTNode(4);
        node.left.right = new BTNode(6);
        node.right.left = new BTNode(7);

        System.out.println(sumBinaryTree(node));
    }
}
