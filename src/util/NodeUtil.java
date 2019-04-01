package util;

public class NodeUtil {

    public static void printNodes(Node head) {
        Node r = head;
        System.out.print(r.data);
        while (r.next != null) {
            System.out.print(",");
            System.out.print(r.next.data);
            r = r.next;
        }
        System.out.println();
    }

    public static void swap(Node n1, Node n2) {
        n1.next = n2.next;
        n2.next = n1;
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
