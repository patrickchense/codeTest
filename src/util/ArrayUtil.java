package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtil {

    public static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void printList(List<? extends Object> l) {
        for (Object b : l) {
            if (b instanceof Integer[]) {
               System.out.println(Arrays.toString((Integer[]) b));
            } else if (b instanceof List) {
                System.out.print("[");
                for (Object c : (List)b) {
                    System.out.print(c.toString() + ",");
                }
                System.out.println("]");
            } else {
                System.out.print(b.toString() + " ");
            }
        }
        System.out.println();
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void printMatrix(Object[][] matrix) {
        for (Object[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }
}
