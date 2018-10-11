package GoldmanSachs;
/*
Calculate the N’th Fibonacci number.
 1,1,2,3,5,8,13,21,34,55,89,144,
dp question
recursion way

 */
public class Fibonacci {

    public static void main(String args[]) {
        long now = System.currentTimeMillis();
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(10));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(40));
        System.out.println("cost: " + (System.currentTimeMillis() - now));
        System.out.println("=======");
        now = System.currentTimeMillis();
        System.out.println(dpFibonacci(10, new int[11]));
        System.out.println(dpFibonacci(60, new int[61])); // limit exceed
        System.out.println("cost: " + (System.currentTimeMillis() - now));
        System.out.println("=======");
        now = System.currentTimeMillis();
        System.out.println(dpFibonacci2(10));
        System.out.println(dpFibonacci2(60)); // limit exceed
        System.out.println("cost: " + (System.currentTimeMillis() - now));
        System.out.println("=======");
        now = System.currentTimeMillis();
        System.out.println(fibonacci3(10));
        System.out.println(fibonacci3(60)); // limit exceed
        System.out.println("cost: " + (System.currentTimeMillis() - now));
    }

    /*
    recursion, duplicate calculation
     */
    public static int fibonacci(int n) {
        if (n <= 2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    /*
    int[] store the results recursion
    O(n)/O(n)
     */
    public static int dpFibonacci(int n, int[] results) {
        if (n <= 2) return 1;
        if (results[n] != 0) return results[n];
        int tmp = 0;
        if(results[n-1] > 0) tmp += results[n-1];
        else {
            results[n-1] = dpFibonacci(n-1, results);
            tmp += results[n-1];
        }
        if(results[n-2] > 0) tmp += results[n-2];
        else {
            results[n-2] = dpFibonacci(n-2, results);
            tmp += results[n-2];
        }
        return tmp;
    }

    /*
    iterate way
    O(n)/O(n)
     */
    public static int dpFibonacci2(int n) {
        int[] f = new int[n+2];
        int i;
        f[0] = 0;
        f[1] = 1;
        for (i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    /*
    find a way to do this O(n) and O(1) space
     */
    public static int fibonacci3(int n) {
        int a = 0, b = 1, c;
        if (n == 0) return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
