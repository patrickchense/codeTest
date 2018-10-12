package GoldmanSachs;
/*
How many pairs of numbers are in the list which equal the sum?
They run a series of numbers with a sum at the end, you’re then asked to develop a solution which finds how many pairs of numbers are in the list which equal the sum.

questions?
    number duplicates?
    order?
    unique pair?

solutions:
first think:
    1. double for, brute force
    2. two pointers

don't understand the questions,
so I pick some leetcode questions similar to do

https://leetcode.com/problems/map-sum-pairs/

Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value.
If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5



https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

 */
public class PairSum {

    public static void main(String args[]) {

    }

    class MapSum {

        String[] keys;
        int[] vals;

        void insert(String key, Integer val) {

        }

        int sum(String prefix) {return 0;}
    }
}
