package daily2019;

/*
Find the minimum number of coins required to make n cents.

You can use standard American denominations, that is, 1¢, 5¢, 10¢, and 25¢.

For example, given n = 16, return 3 since we can make it with a 10¢, a 5¢, and a 1¢.

@Google

@solved

这里很简单的原因在于 10, 5, 25都是倍数，不存在 7 == 3+ 3 + 1, 或者  5 + 1 + 1 都是3个问题
 */
public class D20190219 {

    public static void main(String[] args) {
        System.out.println(minimumCoins(16));
        System.out.println(minimumCoins(26));
    }

    /*
    这里的问题在于？ %25 == 0  %10 ==0  %5 == 0， %1
     */
    public static int minimumCoins(int n) {
        int c = 0;
        int coins[] = new int[]{25, 10, 5, 1};
        for (int i = 0; i < 4; i++) {
            c += n / coins[i];
            n = n % coins[i];
        }
        return c;
    }
}
