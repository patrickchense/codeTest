package dailyproblem;

/*
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
 */

import util.BTNode;

/*
二叉树遍历， preorder, inorder, postorder, and revert binary tree back.

related questions:
TODO print binary tree
https://leetcode.com/problems/print-binary-tree/description/

string to binary tree inorder/postorder
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

 */
public class Daily20181007 {

    public static void main(String[] args) {
        BTNode node = new BTNode();
        node.val = 10;
        BTNode left = new BTNode();
        left.val = 8;
        node.left = left;
        BTNode right = new BTNode();
        right.val = 11;
        node.right = right;
        BTNode leftleft = new BTNode();
        leftleft.val = 5;
        left.left = leftleft;

        String serialize = serializeTree(node);
        System.out.println(serialize);
    }

    public static String serializeTree(BTNode root) {
        StringBuilder sb = new StringBuilder("{");
        helpSerialize(root, sb);
        sb.append("}");
        return sb.toString();
    }

    static void helpSerialize(BTNode node, StringBuilder sb) {
        if (node == null) return;
        else {
            if (sb.length() > 1) sb.append(",");
            sb.append(node.val);
        }
        if (node.left == null && node.right == null) {
            return;
        }
        if (node.left != null) helpSerialize(node.left, sb);
        if (node.right != null) helpSerialize(node.right, sb);
    }

    public static BTNode deserializeTree(String nodeStr) {
        return null;
    }
}
