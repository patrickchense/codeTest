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
        System.out.println(dpFibonacci(50, new int[51])); // limit exceed
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
    int[] store the results
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
    TODO, find a way to do this O(n) and O(1) space
     */
    public int fibonacci3(int n) {
        return -1;
    }
}
