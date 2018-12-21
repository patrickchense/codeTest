package dailyproblem;

/*
Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers and returns x^y.

Do this faster than the naive method of repeated multiplication.

For example, pow(2, 10) should return 1024.

@google
@solved
 */
public class Daily20181204 {
    // only consider y >= 0
    // O(y) using multiplication
    // now O(logy)
    public static long pow(long x, int y) {
        if (y == 1) return x;
        if (y == 2) return x * x;
        if (y == 0) return 1;
        int t = 2;
        long tmp = x;
        x = x * x;
        while (t * t <= y) {
            x *= x;
            t *= t;
        }
        while (y > t) {
            y--;
            x *= tmp;
        }
        return x;
    }

    // using & and >>,  better solution
    public static long pow2(int x, int y) {
        long result = 1;
        int pow = x;
        while (y > 0) {
            if ((y & 1) == 1) {
                result *= pow;
            }
            pow *= pow;
            y >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 10));
        long now = System.currentTimeMillis();
        System.out.println(pow(2, 20));
        System.out.println("cost:" + (System.currentTimeMillis() - now));
        now = System.currentTimeMillis();
        System.out.println(pow2(2, 20));
        System.out.println("cost:" + (System.currentTimeMillis() - now));
    }
}
