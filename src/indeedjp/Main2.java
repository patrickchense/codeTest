package indeedjp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
You are given an array of length N consisting of integers, a={a1,…,aN}, and an integer L.

Consider the following subproblem:

You are given an integer S.
Find the largest value in the interval [S,S+L−1] in the sequence a, that is, find max(aS,…,aS+L−1).
Solve this subproblem for every S=1,…,N−L+1.

Constraints
1≤N≤105
1≤L≤N
−109≤ai≤109


 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int s = n - l + 1;
        List<Integer> arr = new ArrayList<>(n);
        int i = 0;
        while(i++ < n) arr.add(sc.nextInt());
        int max_pre_index = 0;
        boolean start = false;
        for (int j = 0; j < s; j++) {
            int end_index = j + l - 1;
            if (!start) {
                // first time
                for (int k = j; k <= end_index; k++) {
                    if (arr.get(k) > arr.get(max_pre_index)) max_pre_index = k;
                }
                start = true;
            } else {
                // note first time
                if (arr.get(end_index) > arr.get(max_pre_index)) {
                    max_pre_index = end_index;
                }
                else if (max_pre_index < j) {
                    max_pre_index = j;
                    for (int k = j; k <= end_index; k++) {
                        if (arr.get(k) > arr.get(max_pre_index)) max_pre_index = k;
                    }
                }
            }
            System.out.println(arr.get(max_pre_index));
        }
    }
}
