package dailyproblem;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/*
The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.

@Google

@n!
@array

有组合的所有子集，顺序不重要，看着怎么也要recursive吧

@solved

https://www.geeksforgeeks.org/power-set/
https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/

2 * n 个结果，然后, 0 - 15,  1 << n == 15


 */
public class Daily20181110 {


    public static void main(String[] args) {
        ArrayUtil.printList(powerSet(new int[]{1,2,3}));
        System.out.println("-----------");
        printSubsets(new char[]{1,2,3,4});
    }

    // O(2 ^ n * n)  ?? any optimization?
    public static List<List<Integer>> powerSet(int[] arr) {
        List<List<Integer>> powerSets = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        powerSets.add(empty);
        //遍历每次，每个之前的集合加当前元素作为一个新的结果
        for (int i = 0; i < arr.length; i++) {
            List<List<Integer>> ts = new ArrayList<>();
            for (List<Integer> res : powerSets) {
                List<Integer> t = new ArrayList<>(res);
                t.add(arr[i]);
                ts.add(t);
            }
            powerSets.addAll(ts);
        }
        return powerSets;
    }

    static void printSubsets(char set[])
    {
        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)  // 这里不对，所以进不去
                    System.out.print(set[j] + " ");

            System.out.println("}");
        }
    }
}
