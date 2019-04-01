package dailyproblem;

import util.Node;

/*
Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.

The list is very long, so making more than one pass is prohibitively expensive.

Do this in constant space and in one pass.
@google

@solved
@two pointers
@linkedlist

经典k问题
 */
public class Daily20181030 {

    /*
    two pointers, one pass done
     */
    public static Node removeKthEle(Node head, int K) {
        if (head == null) return null;
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < K; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            head = head.next;
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
