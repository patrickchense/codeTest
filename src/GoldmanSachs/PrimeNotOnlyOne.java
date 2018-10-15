package GoldmanSachs;
/*

Prime factorization of a list of numbers. (It’s has been mathematical proven by a mathematician that any number can be broken down into factors of prime number. For e.g. 12 - 2x2x3)
 (The software that he was supposed to come up with must be able to give the final answer of the number and not just one prime factor)

 */


public class PrimeNotOnlyOne {

    // print all the prime factor
    public static void primeFactors(int n) {
        // Print the number of 2s that divide n
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)
            System.out.print(n);
    }

    // print largest prime factor
    public static long largestPrimeFactor(long n) {
        // Initialize the maximum prime
        // factor variable with the
        // lowest one
        long maxPrime = -1;

        // Print the number of 2s
        // that divide n
        while (n % 2 == 0) {
            maxPrime = 2;

            // equivalent to n /= 2
            n >>= 1;
        }

        // n must be odd at this point,
        // thus skip the even numbers
        // and iterate only for odd
        // integers
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                maxPrime = i;
                n = n / i;
            }
        }

        // This condition is to handle
        // the case when n is a prime
        // number greater than 2
        if (n > 2)
            maxPrime = n;

        return maxPrime;
    }
}
