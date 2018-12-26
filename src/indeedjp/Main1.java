package indeedjp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
There are N rooms in a row. The i-th room (1≤i≤N) from the left is called Room i.
You are given M closed intervals [ai,bi] (1≤i≤M).
At time 0, all rooms j such that ai≤j≤bi for some i (1≤i≤M) are occupied, and the other rooms are vacant.

You are given Q queries.
The i-th query (1≤i≤Q) represents an event happening at time i, as follows:

In the i-th query (1≤i≤Q), a closed interval [ci,di] (1≤i≤Q) is given.
This query asks: "Are all rooms j such that ci≤j≤ci" vacant?
If all those rooms are vacant, the query should be responded by OK, then all rooms j such that ci≤j≤ci get occupied.
Otherwise, the query should be responded by OK, then nothing happens.
Process these queries.
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> occuppied = new ArrayList<>();
        for (int i = 0; i < m*2; i++) {
            occuppied.add(sc.nextInt());
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            boolean isOccuppied = isOccuppied(occuppied, s, e);
            if (!isOccuppied) {
                System.out.println("OK");
                occuppied.add(s);
                occuppied.add(e);
            } else {
                System.out.println("NG");
            }
        }
    }

    public static boolean isOccuppied(List<Integer> occuppied, int start, int end) {
        for (int i = 0; i < occuppied.size()-1;) {
            int occuppied_s = occuppied.get(i);
            int occuppied_e = occuppied.get(i+1);
            if ((start >= occuppied_s && start <= occuppied_e) || (end >= occuppied_s && end <= occuppied_e)
                    || (start < occuppied_s && end > occuppied_e)) {
                return true;
            }
            i += 2;
        }
        return false;
    }
}
