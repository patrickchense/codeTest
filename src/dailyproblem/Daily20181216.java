package dailyproblem;

import util.Node;
import util.NodeUtil;

/*
Given the head of a singly linked list, reverse it in-place.
@Google
@linkedlist
@review
@answered

linkedlist的相关题目，reverse，很重要
https://www.geeksforgeeks.org/reverse-a-linked-list/

Initialize three pointers prev as NULL, curr as head and next as NULL.
Iterate trough the linked list. In loop, do following.
// Before changing next of current,
// store next node
next = curr->next
// Now change next of current
// This is where actual reversing happens
curr->next = prev

// Move prev and curr one step forward
prev = curr
curr = next

 */
public class Daily20181216 {

    public static void main(String[] args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Node r = reverseLinkedListInPlace(n1);
        NodeUtil.printNodes(r);
    }


    /*
        a->b->c->d

        b->a->c->d

        b->c->a->d

        b->c->d->a

        c->b->d->a

        c->d->b->a

        d->c-b-a
     */
    public static Node reverseLinkedListInPlace(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}
