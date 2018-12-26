package indeedjp;

import java.util.Scanner;

/*
You are given N records.
The content of the i-th record is represented by a string Si.
These records are managed in pages, as follows:

The first page: contains the first, ..., K-th records.
The second page: contains the (K+1)-th, ..., 2K-th records.
The third page: contains the (2K+1)-th, ..., 3K-th records.
:
The ceil(N⁄K)-th page: contains the ((ceil(N⁄K)−1)K+1)-th, ..., N-th records.
Here, ceil(X) represents the smallest integer not less than X.
Print the contents of the records contained in the M-th page, in the order given.

1≤N≤100
1≤K≤N
1≤M≤ceil(N⁄K)
1≤|Si|≤100 (1≤i≤N), where |S| is the length of S.
Si is a string consisting of lowercase English letters.

 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        int start = (m-1) * k + 1;
        int end = m * k;
        for (int i = 1; i <= n; i++) {
            String s = sc.next();
            if (i >= start && i <= end) {
                System.out.println(s);
            }
        }
    }
}
