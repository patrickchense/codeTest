package daily2019;

import util.ArrayUtil;
import util.ListNode;
import util.Node;

/*
Given a linked list, rearrange the node values such that they appear in alternating low -> high -> low -> high ... form.
 For example, given 1 -> 2 -> 3 -> 4 -> 5, you should return 1 -> 3 -> 2 -> 5 -> 4.


@medium
@Fitbit

@15min
@solved

linkedlist swap two eles

 */
public class D20190616 {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        head.next =n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

//        ArrayUtil.printNode(swap(head));

        Node n6 = new Node(6);
        n5.next = n6;
        ArrayUtil.printNode(swap(head));
    }

    public static Node swap(Node head) {
        if (head == null || head.next == null) return head;

        Node pre = head;
        Node tmp = head.next;
        while(tmp != null && tmp.next != null) {
            Node next = tmp.next;
            pre.next = next;
            tmp.next = next.next;
            next.next = tmp;
            pre = tmp;
            tmp = tmp.next;
        }

        return head;
    }

}
