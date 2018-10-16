package GoldmanSachs;

import java.util.ListIterator;
import java.util.Stack;

/*
https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
Given a stack, sort it using recursion. Use of any loop constructs like while,
for..etc is not allowed. We can only use the following ADT functions on Stack S:
is_empty(S)  : Tests whether stack is empty or not.
push(S)         : Adds new element to the stack.
pop(S)         : Removes top element from the stack.
top(S)         : Returns value of the top element. Note that this
               function does not remove element from the stack.

@recursion
solution:
We can use below algorithm to sort stack elements:

sortStack(stack S)
    if stack is not empty:
        temp = pop(S);
        sortStack(S);
        sortedInsert(S, temp);
Below algorithm is to insert element is sorted order:

sortedInsert(Stack S, element)
    if stack is empty OR element > top element
        push(S, elem)
    else
        temp = pop(S)
        sortedInsert(S, element)
        push(S, temp)
 */
public class SortStack {
    static void sortedInsert(Stack<Integer> s, int x) {
        // Base case: Either stack is empty or newly inserted
        // item is greater than top (more than all existing)
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }

        // If top is greater, remove the top item and recur
        int temp = s.pop();
        sortedInsert(s, x);

        // Put back the top item removed earlier
        s.push(temp);
    }

    // Method to sort stack
    static void sortStack(Stack<Integer> s) {
        // If stack is not empty
        if (!s.isEmpty()) {
            // Remove the top item
            int x = s.pop();

            // Sort remaining stack
            sortStack(s);

            // Push the top item back in sorted stack
            sortedInsert(s, x);
        }
    }

    // Utility Method to print contents of stack
    static void printStack(Stack<Integer> s) {
        ListIterator<Integer> lt = s.listIterator();

        // forwarding
        while (lt.hasNext())
            lt.next();

        // printing from top to bottom
        while (lt.hasPrevious())
            System.out.print(lt.previous() + " ");
    }

    // Driver method
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println("Stack elements before sorting: ");
        printStack(s);

        sortStack(s);

        System.out.println(" \n\nStack elements after sorting:");
        printStack(s);

    }
}
