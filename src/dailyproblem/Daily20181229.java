package dailyproblem;

/*
Given a string of parentheses, write a function to compute the minimum number of parentheses to be removed to make the string valid (i.e. each open parenthesis is eventually closed).

For example, given the string "()())()", you should return 1. Given the string ")(", you should return 2, since we must remove all of them.

@Google
@string
@match
@solved
 */
public class Daily20181229 {


    public static void main(String[] args) {
        System.out.println(RemoveParenthesesNumber("()())()"));
        System.out.println(RemoveParenthesesNumber(")("));
        System.out.println(RemoveParenthesesNumber(")()((())))"));
    }

    public static int RemoveParenthesesNumber(String s) {
        int num = 0;
        int bal = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') bal++;
            else {
                if (bal == 0) {
                    // not enough
                    num++;
                    continue;
                } else {
                    bal--;
                }
            }
        }
        return num + bal;
    }
}
