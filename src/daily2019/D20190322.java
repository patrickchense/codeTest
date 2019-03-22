package daily2019;

import util.Node;
import util.NodeUtil;

/*
Given a linked list, sort it in O(n log n) time and constant space.

For example, the linked list 4 -> 1 -> -3 -> 99 should become -3 -> 1 -> 4 -> 99.

@Google
@sort
@linkedlist
@answered
@review

 */
public class D20190322 {

    public static void main(String[] args) {
        Node head = new Node(4);
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(99);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        NodeUtil.printNodes(mergeSortLinkedList(head));
    }

    // try merge sort
    /**
    MergeSort(headRef)
1) If head is NULL or there is only one element in the Linked List
    then return.
2) Else divide the linked list into two halves.
      FrontBackSplit(head, &a, &b); // a and b are two halves
3) Sort the two halves a and b.
            MergeSort(a);
    MergeSort(b);
4) Merge the sorted a and b (using SortedMerge() discussed here)
    and update the head pointer using headRef.
     *headRef = SortedMerge(a, b);
     *
     * merge sort的关键在于1. getMid 2. merge
     */
    public static Node mergeSortLinkedList(Node head) {
        if (head == null || head.next == null) return head;
        Node mid = getMiddle(head);
        Node next = mid.next;
        mid.next = null;
        Node left = mergeSortLinkedList(head);
        Node right = mergeSortLinkedList(next);
        return sortedMerge(left, right);
    }

    private static Node sortedMerge(Node left, Node right) {
        Node result = null;
        if (left == null) return right;
        if (right == null) return left;
        if (left.data < right.data) {
            result = left;
            result.next = sortedMerge(left.next, right);
        }
        else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }
        return result;
    }

    //用双指针(一快一慢)的方式找到中间node
    private static Node getMiddle(Node head) {
        if (head == null) return head;
        Node fast = head.next;
        Node slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
}
