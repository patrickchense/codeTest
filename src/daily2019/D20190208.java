package daily2019;

import util.Node;
import util.NodeUtil;

/*
Let's represent an integer in a linked list format by having each node represent a digit in the number. The nodes make up the number in reversed order.

For example, the following linked list:

1 -> 2 -> 3 -> 4 -> 5
is the number 54321.

Given two linked lists in this format, return their sum in the same linked list format.

For example, given

9 -> 9
5 -> 2
return 124 (99 + 25) as:

4 -> 2 -> 1

@Microsoft
@linkedlist
@solved

1. 一个数的reverseOrder的数，怎么获得最快？这里用了string，还可以int直接操作，我写了方法，比较麻烦没测试
2. 一个是char -> int, Character.getNumericValue 方法

 */
public class D20190208 {

    public static void main(String[] args) {
        Node n1 = new Node(9);
        Node n2 = new Node(9);
        n1.next = n2;
        Node n3 = new Node(5);
        Node n4 = new Node(2);
        n3.next = n4;
        Node res = calculateLinkedList(n1, n3);
        NodeUtil.printNodes(res);
    }

    public static Node calculateLinkedList(Node head1, Node head2) {
        int s1 = getLinkedListNum(head1);
        int s2 = getLinkedListNum(head2);
        return formateLinkedList(s1 + s2);
    }

    private static Node formateLinkedList(int n) {
        String s = String.valueOf(n);
        Node head = new Node(-1);
        Node t = head;
        for (int i = s.length() -1; i >= 0; i--) {
            Node node = new Node(Character.getNumericValue(s.charAt(i)));
            head.next = node;
            head = node;
        }
        return t.next;
    }

    private static int getLinkedListNum(Node head1) {
        StringBuilder sb = new StringBuilder();
        while(head1 != null) {
            sb.append(head1.data);
            head1 = head1.next;
        }
        return Integer.parseInt(sb.reverse().toString());
    }

    public static int reverseOrder(int a) {
        int res = 0;
        int i = 0;
        while (true) {
            if (a < Math.pow(10, i+1)) break;
            i++;
        }
        int j = 0;
        while (a > 0) {
            int t = (int) (a / Math.pow(10, i));
            res += t * Math.pow(10, j);
            a = (int) (a % Math.pow(10, i));
            i--;
            j++;
        }
        return res;
    }
}
