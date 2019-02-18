package LINE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Problem Statement
You have several sticks of different lengths, and a stick case of a fixed length.
We want to find 2 sticks that just fit in the case.

Input
[L1] [L2] ... [LN]
[target]
The first line of input contains a list of integers separated by a whitespace. This list represents the lengths of the sticks.

The second line of input contains an integer target. This integer represents the length of the case.

Output
Output a pair of lengths whose sum is equal to target.

[La] [Lb]
Output should be ordered in ascending order. (e.g. "1 2" is acceptable. "2 1" is not)

If you find 2 or more pairs, output the pair which contains the stick of the shortest length. (e.g. If the target is 5, and you find both "1 4" and "2 3", output "1 4")

In case there is no such pairs, output a single -1

-1




Input Example
1 2 3 4 5
6
Output Example
1 5

 */
public class Pair {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] numberStrs = input.split(" ");
        String targetStr = br.readLine();
        int target = Integer.valueOf(targetStr);
        Set<Integer> vals = new HashSet<>(); // using set to keep the numbers
        List<Integer> results = new ArrayList<>(); // using list to keep the pair small number;
        for (String numberStr : numberStrs) {
            int n = Integer.valueOf(numberStr);
            int t = target - n;
            if (vals.contains(t)) {
                results.add(n > t ? t : n);
            }
            vals.add(n);
        }
        if (results.isEmpty()) {
            System.out.println("-1");
            return;
        }
        // find the smallest
        if (results.size() == 1) {
            System.out.println(results.get(0) + " " + (target - results.get(0)));
            return;
        }
        int min = results.get(0);
        for (int i = 1; i < results.size(); i++) {
            if (results.get(i) < min) min = results.get(i);
        }
        System.out.println(min + " " + (target - min));
    }
}
