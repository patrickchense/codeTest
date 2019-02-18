package util;

import java.util.List;

public class ArrayUtil {

    public static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void printList(List<? extends Object> l) {
        for (Object b : l) {
            System.out.print(b.toString() + " ");
        }
        System.out.println();
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
