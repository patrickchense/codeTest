package dailyproblem;

import java.util.Stack;

/*
Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false.

@facebook
@solved
@string
@match

经典符号问题
 */
public class Daily20181031 {

    public static void main(String[] args) {
        System.out.println(isMatchBrackets("([])[]({})"));
        System.out.println(isMatchBrackets("([)]"));
        System.out.println(isMatchBrackets("((()"));
    }

    public static boolean isMatchBrackets(String s) {
        Stack<Character> brs = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') brs.push(c);
            else {
                char before = brs.peek();
                if (c == ']' && before == '[') brs.pop();
                else if (c == '}' && before == '{') brs.pop();
                else if (c == ')' && before == '(') brs.pop();
                else return false;
            }
        }
        return brs.empty();
    }
}

