package util;

public class NumberUtil {

    public static boolean isPrime(int n) {
        for (int i = n-1; i > 1; i--) {
            if (n %i == 0) return false;
        }
        return true;
    }
}
