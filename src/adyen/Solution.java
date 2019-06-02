package adyen;

import java.util.Stack;

public class Solution {

    private Stack<Integer> content;
    private Stack<Solution> transactions;

    public Solution() {
        this(false);
    }

    private Solution(boolean internal) {
        content = new Stack<>();
        if (!internal) {
            transactions = new Stack<>();
            transactions.push(this);
        }
    }

    public void push(int value) {
        transactions.peek().content.push(value);
    }

    public int top() {
        Stack<Integer> cn = transactions.peek().content;
        return cn.empty() ? 0 : cn.peek();
    }

    public int pop() {
        Stack<Integer> cn = transactions.peek().content;
        return cn.empty() ? 0 : cn.pop();
    }

    public void begin() {
        Solution newTransaction = new Solution();
        newTransaction.content = new Stack<>();
        transactions.add(newTransaction);
    }

    public boolean rollback() {
        Solution lastTransaction = transactions.peek();
        if (lastTransaction != this) {
            transactions.pop();
            return true;
        }
        return false;
    }

    public boolean commit() {
        Solution lastTransaction = transactions.peek();
        if (lastTransaction != this) {
            lastTransaction = transactions.pop();
            this.content.addAll(lastTransaction.content);
            return true;
        }
        return false;
    }

    public static void main(String[] as) {
        Solution solution = new Solution();
        solution.push(4);
        solution.rollback(); // false;
        solution.begin();                    // start transaction 1
        solution.push(7);                    // stack: [4,7]
        solution.begin();                    // start transaction 2
        solution.push(2);                    // stack: [4,7,2]
        System.out.println(solution.rollback());// == true;  // rollback transaction 2
        System.out.println(solution.top());// == 7;          // stack: [4,7]
        solution.begin();                    // start transaction 3
        solution.push(10);                   // stack: [4,7,10]
        System.out.println(solution.commit());// == true;    // transaction 3 is committed
        System.out.println(solution.top()); //== 10;
        System.out.println(solution.commit());// == true;  // rollback transaction 1
        System.out.println(solution.top());// == 4;          // stack: [4]
        System.out.println(solution.commit());// == false;   // there is no open transaction
    }
}
