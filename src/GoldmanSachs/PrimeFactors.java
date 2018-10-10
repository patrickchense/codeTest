package GoldmanSachs;

import java.util.*;

/*
Based on the provided number, find all of its prime factors (when the factors are multiplied, they should result in the original number)
for example: 35 = 5 * 7

questions:
    number MAX_VALUE?
think: brute force,   for % == 0, judge if divided and dividend is prime

related:
count primes:
https://leetcode.com/problems/count-primes/description/
hard kth smallest prime pair  REVIEW
https://leetcode.com/problems/k-th-smallest-prime-fraction/description/
TODO prime number of set bit in Binary
https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/

 */
public class PrimeFactors {

    public static void main(String args[]) {
        int n = 35;
        System.out.println("%d's prime factor:");
        primeFactor(n).forEach(System.out::println);
    }

    // use set to exclude duplicates
    private static Set<Set<Integer>> primeFactor(int n) {
        Set<Set<Integer>> res = new HashSet<>();
        for (int i = n/2; i > 1; i--) {
            if (n % i == 0 && isPrime(n%i) && isPrime(n/i)) res.add(new HashSet<>(Arrays.asList(i, n/i)));
        }
        return res;
    }
    /*
    Optimize: many duplicate calculate, use int[] to store the prime value
     */
    private static boolean isPrime(int n) {
        for (int i = n/2; i > 1; i--) {
            if (n % i ==0) return false;
        }
        return true;
    }
}
