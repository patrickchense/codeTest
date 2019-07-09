package daily2019;

import java.util.Stack;

/*
Given a string consisting of parentheses, single digits, and positive and negative signs, convert the string into a mathematical expression to obtain the answer.

Don't use eval or a similar built-in parser.

For example, given '-1 + (2 + 3)', you should return 4.

@hard
@Facebook

 */
public class D20190704 {

    public static void main(String[] args) {

    }

    public static int calculateStr(String str) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        char[] cs = str.toCharArray();
        boolean negative = false;
        boolean beforeFlag = false;
        boolean restart = false;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '-' && beforeFlag) {
                negative = true;
            } else {
                if (cs[i] == '-' || cs[i] == '+' || cs[i] == '*' || cs[i] == '/') {
                    beforeFlag = true;
                    ops.add(cs[i]);
                } else if (cs[i] == '(' ) {
                    // nextOne push
                    restart = true;
                } else {
                    int b = 0;
                    if (negative) {
                        // convert negative
                    }
                    if (restart || nums.isEmpty()) {
                        // add nums , how to convert char to int ?
                        restart = false;
                    } else {
                        int a = nums.pop();
                        char op = ops.pop();
                        int tmp = calculate(a, b, op);
                        nums.add(tmp);
                    }
                }
            }
        }
        return nums.pop();
    }

    private static int calculate(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return -1;
    }
}
