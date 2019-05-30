package daily2019;

/*
Implement the function fib(n), which returns the nth number in the Fibonacci sequence, using only O(1) space.

@Apple

@easy

@solved

@fibonacci
@math
 */
public class D20190524 {

    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    public static int fib(int n) {
        int a = 0, b = 1, c=0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
