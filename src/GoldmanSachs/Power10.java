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

alternate
    use Math.log, (Math.log(x) / Math.log(y)) == (Math.log(y) / Math.log(x))

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
        System.out.println("============");
        n = 10000;
        System.out.println(isPower10Opti(n));
        n = 11000;
        System.out.println(isPower10Opti(n));
        n = 1000000;
        System.out.println(isPower10Opti(n));
        n = 1005000;
        System.out.println(isPower10Opti(n));
        n = 1;
        System.out.println(isPower10Opti(n));
        System.out.println("============");
        n = 10000;
        System.out.println(isPower10Math(n));
        n = 11000;
        System.out.println(isPower10Math(n));
        n = 1000000;
        System.out.println(isPower10Math(n));
        n = 1005000;
        System.out.println(isPower10Math(n));
        n = 1;
        System.out.println(isPower10Math(n));
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
        int factor = 1;
        while (n > dividend) {
            // don't divide, use square divide
            dividend *= Math.pow(10, factor);
            factor *= 2;
        }
        if (n == dividend) return true;
        // construct array of dividend / dividend to dividend, binary search if n , if found true, else false
        int i = factor / 2; int j = factor;
        dividend /= Math.pow(10, factor);
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            int tmp = (int) (dividend * Math.pow(10, mid));
            if (n == tmp) return true;
            else if (n > tmp) i = mid + 1;
            else j = mid - 1;
        }
        return false;
    }

    private static boolean isPower10Math(int n) {
        return ((int)(Math.log(n) / Math.log(10))) == ((int)(Math.log(10) / Math.log(n)));
    }
}


