package daily2019;

import util.Node;
import util.NodeUtil;

/*
Given a linked list and a positive integer k, rotate the list to the right by k places.

For example, given the linked list 7 -> 7 -> 3 -> 5 and k = 2, it should become 3 -> 5 -> 7 -> 7.

Given the linked list 1 -> 2 -> 3 -> 4 -> 5 and k = 3, it should become 3 -> 4 -> 5 -> 1 -> 2.

@Airbnb
@linkedlist
@rotate
@classic
@solved
linkedlist 经典题目 扭转

 */
public class D20190330 {

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(7);
        Node n3 = new Node(3);
        Node n4 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Node n = rotate(n1, 2);
        NodeUtil.printNodes(n);

        Node t1 = new Node(1);
        Node t2 = new Node(2);
        Node t3 = new Node(3);
        Node t4 = new Node(4);
        Node t5 = new Node(5);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;
        Node t = rotate(t1, 3);
        NodeUtil.printNodes(t);
    }

    public static Node rotate(Node root, int k) {
        int len = 1;
        Node head = root;
        while(root.next != null) {
            len++;
            root = root.next;
        }
        // root == tail
        int left = len -k;
        // move to left and left.next = head, head = tail.next
        Node t = head;
        for (int i = 0; i <left-1; i++) { // 这里移动几次，错了一下，应该移动的是left -1 次
            t = t.next;
        }
        Node nh = t.next;
        t.next = null;
        root.next = head;
        return nh;
    }
}
