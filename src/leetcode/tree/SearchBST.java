package leetcode.tree;

import util.BSTNode;

/*
700 Search in a Binary Search Tree
https://leetcode.com/problems/search-in-a-binary-search-tree/description/

EASY
 */
public class SearchBST {

    public static void main(String args[]) {

    }

    public static BSTNode searchBST(BSTNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        else if (root.val > val) {
            return searchBST(root.left, val);
        }
        else {
            return searchBST(root.right, val);
        }
    }
}
