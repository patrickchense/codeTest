package leetcode.str;

/*
leetcode 678
Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.

@solved

 */
public class ValidParenthesisString {

    /*
    logic:
       1. check right
        left -- || star --
       2. check left (backwards)
        right -- || star --
     */
    public boolean checkValidString(String s) {
        int left = 0;
        int star = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') left++;
            else if (c[i] == '*') star++;
            else {
                if (left > 0) left--;
                else if (star > 0) star--;
                else return false;
            }
        }
        if (left == 0) return true;
        if ((left > 0 && star == 0) || (left > star)) return false;
        // now left > 0, need to check left

        int right = 0;
        star = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == ')') right++;
            else if (c[i] == '*') star++;
            else {
                if (right > 0) right--;
                else if (star > 0) star--;
                else return false;
            }
        }
        return true;
    }

    // Greedy ?? not understand
    public boolean checkValidStringGreedy(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
}
