package daily2019;

import java.util.Stack;

/*
The expression is given as a list of numbers and operands. For example: [5, 3, '+'] should return 5 + 3 = 8.

For example, [15, 7, 1, 1, '+', '-', '/', 3, '*', 2, 1, 1, '+', '+', '-'] should return 5,
since it is equivalent to ((15 / (7 - (1 + 1))) * 3) - (2 + (1 + 1)) = 5.

You can assume the given expression is always valid.

@Google
@solved


 */
public class D20190316 {

    public static void main(String[] args) {
        char[] cs = new char[]{15, 7, 1, 1, '+', '-', '/', 3, '*', 2, 1, 1, '+', '+', '-'};
        System.out.println(calculateStack(cs));
        cs = new char[]{5, 3, '+'};
        System.out.println(calculateStack(cs));
    }

    // O(n) space O(n) time
    public static int calculateStack(char[] chars) {
        Stack<Integer> s = new Stack();
        for (char c : chars) {
            if (c == '-' || c == '+' || c == '*' || c=='/') {
                Integer c2 = (Integer) s.pop();
                Integer c1 = (Integer) s.pop();
                switch (c){
                    case '-': s.push(c1-c2);break;
                    case '*': s.push(c1 * c2);break;
                    case '/': s.push(c1 / c2);break;
                    case '+': s.push(c1 + c2);break;
                }
            }
            else {
                s.push((int)c);
            }
        }
        return (int) s.pop();
    }



}
