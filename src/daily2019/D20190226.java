package daily2019;

import util.Node;
import util.NodeUtil;

/*
Given the head of a singly linked list, swap every two nodes and return its head.

For example, given 1 -> 2 -> 3 -> 4, return 2 -> 1 -> 4 -> 3.

@Google

@linkedlist
@solved
@recursive

用到了linkedlist swap

 */
public class D20190226 {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        NodeUtil.printNodes(n1);
        Node head = swapNodes(null, n1);
        NodeUtil.printNodes(head);
    }

    public static Node swapNodes(Node prev, Node head) {
        if (head == null) return null;
        Node first = head;
        Node second = head.next;
        if (first != null && second != null) {
            Node t = second.next;
            second.next = first;
            first.next = t;
            if (prev != null) prev.next = second;
        }
        swapNodes(first, first.next);
        return second;
    }
}
