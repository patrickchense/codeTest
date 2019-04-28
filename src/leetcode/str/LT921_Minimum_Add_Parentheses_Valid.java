package leetcode.str;

/*
https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

@string
@medium
@parentheses

Example 1:

Input: "())"
Output: 1
Example 2:

Input: "((("
Output: 3
Example 3:

Input: "()"
Output: 0
Example 4:

Input: "()))(("
Output: 4


@solved

 */
public class LT921_Minimum_Add_Parentheses_Valid {

    public static void main(String[] args) {

    }

    // O(n) O(1)
    public int minAddToMakeValid(String S) {
        int res = 0;
        int pre = 0;
        char[] cs = S.toCharArray();
        for (char c : cs) {
            if (c == '(') pre ++;
            else {
                if (pre > 0) pre --;
                else res++;
            }
        }
        return res + pre;
    }
}
