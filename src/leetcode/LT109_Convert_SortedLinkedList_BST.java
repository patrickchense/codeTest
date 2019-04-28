package leetcode;

import util.BTNode;
import util.ListNode;

/*
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

 @binarytree
 @linkedlist
 @medium



 */
public class LT109_Convert_SortedLinkedList_BST {

    public static void main(String[] args) {

    }

    public static BTNode sortedListToBST(ListNode head) {
        int[] list = new int[100];
        ListNode t = head;
        int i = 0;
        while(t != null) {
            list[i] = t.val;
            t = t.next;
        }

        return null;
    }
}
