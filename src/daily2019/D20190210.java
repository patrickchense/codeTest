package daily2019;

/*
Given a real number n, find the square root of n. For example, given n = 9, return 3.

@math

@answered

@review

Math相关的题目包括 * / 实现，sqre, pow, 还有Prime等


https://www.geeksforgeeks.org/square-root-of-an-integer/
https://www.geeksforgeeks.org/check-if-a-number-is-perfect-square-without-finding-square-root/
https://www.geeksforgeeks.org/fast-inverse-square-root/
https://www.geeksforgeeks.org/find-square-root-number-upto-given-precision-using-binary-search/
https://www.geeksforgeeks.org/digital-rootrepeated-digital-sum-given-integer/
https://www.geeksforgeeks.org/count-square-non-square-numbers-n/
https://www.geeksforgeeks.org/n-th-root-number/
https://www.geeksforgeeks.org/find-cubic-root-of-a-number/
https://www.geeksforgeeks.org/check-number-is-perfect-square-using-additionsubtraction/
https://www.geeksforgeeks.org/check-if-product-of-array-containing-prime-numbers-is-a-perfect-square/
https://www.geeksforgeeks.org/largest-divisor-of-a-number-not-divisible-by-a-perfect-square/

 */
public class D20190210 {

    public static void main(String[] args) {
        System.out.println(findSqrt(9));
        System.out.println(findSqrt(12));
        System.out.println(findSqrt(17));
        System.out.println(findSqrt(40));
    }

    /*
    Let  's' be the answer.  We know that 0 <=  s <= x.

Consider any random number r.

    If r*r = x

    If r*r > x, s < r.
    1) Start with ‘start’ = 0, end = ‘x’,
2) Do following while ‘start’ is smaller than or equal to ‘end’.
      a) Compute ‘mid’ as (start + end)/2
      b) compare mid*mid with x.
      c) If x is equal to mid*mid, return mid.
      d) If x is greater, do binary search between mid+1 and end. In this case, we also update ans (Note that we need floor).
      e) If x is smaller, do binary search between start and mid

      类似二分搜索的方式来查找
     */
    // O(logX)
    public static int findSqrt(int x) {
        // Base Cases
        if (x == 0 || x == 1)
            return x;

        // Do Binary Search for floor(sqrt(x))
        int start = 1, end = x, ans=0;
        while (start <= end)
        {
            int mid = (start + end) / 2;

            // If x is a perfect square
            if (mid*mid == x)
                return mid;

            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid*mid < x)
            {
                start = mid + 1;
                ans = mid;
            }
            else   // If mid*mid is greater than x
                end = mid-1;
        }
        return ans;
    }
}
