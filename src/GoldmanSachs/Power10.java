package GoldmanSachs;
/*
Is this number a power of 10?
 They run a sequence of numbers; asked to write a solution that tests whether that number is a power of 10

 1. use divide

 变型
 given x, y , check if y is a power of x
 https://www.geeksforgeeks.org/check-if-a-number-is-power-of-another-number/
 solution use multiply,  while(pow < y) pow = pow * x,  return y == pow
 Optimization,  not multiply, use square


 */
public class Power10 {

    public static void main(String args[]) {
        int n = 10000;
        System.out.println(isPower10(n));
        n = 11000;
        System.out.println(isPower10(n));
        n = 1000000;
        System.out.println(isPower10(n));
        n = 1005000;
        System.out.println(isPower10(n));
        n = 1;
        System.out.println(isPower10(n));
    }

    // O(lg10)
    private static boolean isPower10(int n) {
        if (n < 10) return false;
        while(n % 10 == 0) n /= 10;
        return n==1;
    }

    private static boolean isPower10Opti(int n) {
        if (n < 10) return false;
        int dividend = 10;
        while (n % 10 == 0 && n > dividend) {
            // don't divide, use square divide
            n /= dividend;
            dividend *= dividend;
        }
        if (n == dividend) return true;
        // construct array of dividend / dividend to dividend, binary search if n , if found true, else false
        // TODO
        return false;
    }
}


