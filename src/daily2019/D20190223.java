package daily2019;

import java.util.Stack;

/*
You're given a string consisting solely of (, ), and *. * can represent either a (, ), or an empty string. Determine whether the parentheses are balanced.

For example, (()* and (*) are balanced. )*( is not balanced.

@Google

@string
@pattern
@needoptimize
@solved
@review


一个pattern match的问题, 常用解法，dp, backtracking, stack,
https://leetcode.com/problems/score-of-parentheses/description/
Parentheses.java
OuputContestMatch.java
Daily20181229.java
解法在dp.md提到
https://leetcode.com/problems/longest-valid-parentheses/description/
 */
public class D20190223 {

    public static void main(String[] args) {
        String str = "(()*";
        System.out.println(parenthesesBalance(str));
        str = "(*)";
        System.out.println(parenthesesBalance(str));
        str = ")*(";
        System.out.println(parenthesesBalance(str));

        str = "(**))";
        System.out.println(parenthesesBalance(str));

        str = "(*)))";
        System.out.println(parenthesesBalance(str));
    }

    // 用了stack 就O(n) space了， 去掉stack？ 我其实只比较值钱那么一次的结果，记住prev就行
    public static boolean parenthesesBalance(String str) {
        Stack<Character> stack = new Stack<>();
        int left = 0;
        int right = 0;
        int star = 0;
        for(char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                left ++;
            }
            else if (c == ')') {
                if (stack.isEmpty()) return false;
                Character t = stack.peek();
                if (t == '(') {
                    stack.pop();
                    left--;
                }
                else {
                    stack.push(c);
                    right++;
                }
            }
            else if (c == '*') {
                stack.push(c);
                star++;
            }
        }
        if (stack.isEmpty()) return true;
        return Math.abs(left -right) <= star;

    }
}
