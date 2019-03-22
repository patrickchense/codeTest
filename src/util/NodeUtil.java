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
}
