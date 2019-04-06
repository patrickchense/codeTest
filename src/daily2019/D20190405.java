package daily2019;

/*
Given n numbers, find the greatest common denominator between them.

For example, given the numbers [42, 56, 14], return 14.

@Amazon
@math
@array
@review
@solved
最大公约数

@review
跟很多Prime的问题有关
https://www.geeksforgeeks.org/absolute-difference-between-the-product-of-non-prime-numbers-and-prime-numbers-of-an-array/
https://www.geeksforgeeks.org/absolute-difference-between-the-sum-of-non-prime-numbers-and-prime-numbers-of-an-array/
https://www.geeksforgeeks.org/print-all-distinct-integers-that-can-be-formed-by-k-numbers-from-a-given-array-of-n-numbers/
https://www.geeksforgeeks.org/finding-lcm-two-array-numbers-without-using-gcd/
https://www.geeksforgeeks.org/xor-of-all-prime-numbers-in-an-array/
https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
 */
public class D20190405 {

    public static void main(String[] args) {
        System.out.println(maxDenomiator(new int[]{42, 56, 14}));
        System.out.println(maxDenomiator(new int[]{42, 56, 16}));
    }

    /*
    找到最小，然后最小的约数去试
    不知道是不是最好的方式，现在 O(min * n),
     */
    public static int maxDenomiator(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(arr[i], min);
        }
        int t = min;
        while(t > 1) {
            if (min % t == 0) {
                boolean isAll = true;
                for (int i : arr) {
                    if ( i % t != 0) {
                        isAll = false;
                        break;
                    }
                }
                if (isAll) return t;
            }
            t--;
        }
        return 1;
    }
    // https://www.geeksforgeeks.org/gcd-two-array-numbers/
    /*
    The GCD of three or more numbers equals the product of the prime factors common to all the numbers, but it can also be calculated by
    repeatedly taking the GCDs of pairs of numbers.

    result = arr[0]
For i = 1 to n-1
   result = GCD(result, arr[i])
     */
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // Function to find gcd of array of
    // numbers
    static int findGCD(int arr[], int n)
    {
        int result = arr[0];
        for (int i = 1; i < n; i++)
            result = gcd(arr[i], result);

        return result;
    }
}
