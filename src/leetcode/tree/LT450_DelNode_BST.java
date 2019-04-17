package leetcode.tree;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/delete-node-in-a-bst/

@binarytree
@bst
@medium

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7


@solved
@30min

解决了思想就是，找到node，记住pre
然后根据各种条件处理这个node
    // pre.left = node.left, if node.right == null, else if node.left == null,  pre.left = node.right,
    // restructure (node), pre.left = node.left, find a place for node.right
 */
public class LT450_DelNode_BST {

    public static void main(String[] args) {
        LT450_DelNode_BST t = new LT450_DelNode_BST();
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;

        TreeNode n = t.deleteNode(n1, 3);

        List<Integer>  list = new ArrayList<>();
        preOrder(n, list);
        ArrayUtil.printList(list);

    }

    public static void preOrder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        preOrder(root.left,result);
        preOrder(root.right,result);
    }
    // pre.left = node.left, if node.right == null, else if node.left == null,  pre.left = node.right,
    // restructure (node), pre.left = node.left, find a place for node.right
    TreeNode pre = null;
    boolean isLeft = false;
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = findNode(root, key);
        if (cur == null) return root;
        if (pre == null) {
            // root
            if (cur.left != null && cur.right != null) {
                root = cur.left;
                if (root.right != null)
                    place(root.right, cur.right);
                else
                    root.right = cur.right;
                return root;
            }
            else if (cur.left != null) {
                return cur.left;
            }
            else
                return cur.right;
        }
        // restructure
        if (cur.left == null && cur.right == null) {
            if (isLeft) {
                pre.left = null;
                return root;
            }
            else {
                pre.right = null;
                return root;
            }
        }
        else if (cur.left == null) {
            if (isLeft) {
                pre.left = cur.right;
                return root;
            }
            else {
                pre.right = cur.right;
                return root;
            }
        }
        else if (cur.right == null) {
            if (isLeft) {
                pre.left = cur.left;
                return root;
            }
            else {
                pre.right = cur.left;
                return root;
            }
        }
        else {
            if (isLeft) {
                pre.left = cur.left;
            }
            else {
                pre.right = cur.left;
            }
            place(cur.left, cur.right);
            return root;
        }
    }

    public TreeNode findNode(TreeNode root, int key) {
        if (root.val == key) {
            return root;
        }
        if (root.val > key) {
            if (root.left != null) {
                pre = root;
                isLeft = true;
                return findNode(root.left, key);
            }
            else return null;
        }
        else {
            if (root.right != null) {
                pre = root;
                isLeft = false;
                return findNode(root.right, key);
            }
            else return null;
        }
    }

    public void place(TreeNode small, TreeNode big) {
        if (small.right == null) {
            small.right = big;
            return;
        }
        place(small.right, big);
    }

}
