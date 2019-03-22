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

https://www.geeksforgeeks.org/merge-two-sorted-lists-place/ sort two sorted linkedlist


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

    // two linked list sorted merge
    // Merges two lists with headers as h1 and h2.
// It assumes that h1's data is smaller than
// or equal to h2's data.
    static Node mergeUtil(Node h1, Node h2)
    {
        // if only one node in first list
        // simply point its head to second list
        if (h1.next == null)
        {
            h1.next = h2;
            return h1;
        }

        // Initialize current and next pointers of
        // both lists
        Node curr1 = h1, next1 = h1.next;
        Node curr2 = h2, next2 = h2.next;

        while (next1 != null && next2 != null)
        {
            // if curr2 lies in between curr1 and next1
            // then do curr1->curr2->next1
            if ((curr2.data) > (curr1.data) &&
                    (curr2.data) < (next1.data))
            {
                next2 = curr2.next;
                curr1.next = curr2;
                curr2.next = next1;

                // now let curr1 and curr2 to point
                // to their immediate next pointers
                curr1 = curr2;
                curr2 = next2;
            }
            else
            {
                // if more nodes in first list
                if (next1.next != null)
                {
                    next1 = next1.next;
                    curr1 = curr1.next;
                }

                // else point the last node of first list
                // to the remaining nodes of second list
                else
                {
                    next1.next = curr2;
                    return h1;
                }
            }
        }
        return h1;
    }

    // Merges two given lists in-place. This function
// mainly compares head nodes and calls mergeUtil()
    static Node merge(Node h1, Node h2)
    {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;

        // start with the linked list
        // whose head data is the least
        if (h1.data < h2.data)
            return mergeUtil(h1, h2);
        else
            return mergeUtil(h2, h1);
    }
}
