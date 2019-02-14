package GoldmanSachs;

import util.Node;

import java.util.LinkedList;

/*
https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
Write a function detectAndRemoveLoop() that checks whether a given Linked List contains loop and if loop is present
then removes the loop and returns true. And if the list doesn’t contain loop then returns false.
Below diagram shows a linked list with a loop. detectAndRemoveLoop() must change the below list to 1->2->3->4->5->NULL.


 */
public class DetectAndRemoveLoop {

    static Node head;

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static boolean detectAndRemoveLoop(Node head) {
        Node slow = head, fast = head;
        boolean isLoop = false;
        while (slow.next != null) {
            if (fast.next == slow) {
                isLoop = true;
                fast.next = null;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return isLoop;
    }

    // Function that detects loop in the list
    int detectAndRemoveLoop2(Node node) {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }

    // Function to remove loop
    void removeLoop(Node loop, Node head) {
        Node ptr1 = loop;
        Node ptr2 = loop;

        // Count the number of nodes in loop
        int k = 1, i;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }

        // Fix one pointer to head
        ptr1 = head;

        // And the other pointer to k nodes after head
        ptr2 = head;
        for (i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }

        /*  Move both pointers at the same pace,
         they will meet at loop starting node */
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Get pointer to the last node
        ptr2 = ptr2.next;
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }

        /* Set the next node of the loop ending node
         to fix the loop */
        ptr2.next = null;
    }

    // Function that detects loop in the list
    /*
    Distance traveled by fast pointer = 2 * (Distance traveled
                                         by slow pointer)

(m + n*x + k) = 2*(m + n*y + k)

Note that before meeting the point shown above, fast
was moving at twice speed.

x -->  Number of complete cyclic rounds made by
       fast pointer before they meet first time

y -->  Number of complete cyclic rounds made by
       slow pointer before they meet first time

    m + k = (x-2y)*n

Which means m+k is a multiple of n.

So if we start moving both pointers again at same speed such that one pointer (say slow) begins from head node of
linked list and other pointer (say fast) begins from meeting point. When slow pointer reaches beginning of loop
(has made m steps), fast pointer would have made also moved m steps as they are now moving same pace.
 Since m+k is a multiple of n and fast starts from k, they would meet at the beginning.
Can they meet before also? No because slow pointer enters the cycle first time after m steps.
     */
    void detectAndRemoveLoop3(Node node) {

        // If list is empty or has only one node
        // without loop
        if (node == null || node.next == null)
            return;

        Node slow = node, fast = node;

        // Move slow and fast 1 and 2 steps
        // ahead respectively.
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        /* If loop exists */
        if (slow == fast) {
            slow = node;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }

            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        }
    }

    public static void main(String[] args) {
        DetectAndRemoveLoop list = new DetectAndRemoveLoop();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        list.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }
}
