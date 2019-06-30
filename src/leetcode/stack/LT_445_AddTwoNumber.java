package leetcode.stack;

import util.ListNode;

import java.util.Stack;

/*
https://leetcode.com/problems/add-two-numbers-ii/

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7


@stack
@answered
@review

两个linkedlist表示的数字相加，不能转成string, int/long 处理， stack倒序，然后carry
 */
public class LT_445_AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode dummy = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int a = s1.isEmpty() ? 0 : s1.pop().val;
            int b = s2.isEmpty() ? 0 : s2.pop().val;
            ListNode p = new ListNode((a + b + carry) % 10);
            p.next = dummy.next;
            dummy.next = p;
            carry = (a + b + carry) / 10;
        }
        if (carry != 0) {
            ListNode p = new ListNode(1);
            p.next = dummy.next;
            dummy.next = p;
        }
        return dummy.next;

    }
}
