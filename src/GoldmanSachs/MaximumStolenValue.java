package GoldmanSachs;

/*
https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/

Find maximum possible stolen value from houses
There are n houses build in a line, each of which contains some value in it. A thief is going to steal the maximal value of these houses, but he can’t steal in two adjacent houses because owner of the stolen houses will tell his two neighbour left and right side. What is the maximum stolen value.
Examples:

Input  : hval[] = {6, 7, 1, 3, 8, 2, 4}
Output : 19
Thief will steal 6, 1, 8 and 4 from house.

Input  : hval[] = {5, 3, 4, 11, 2}
Output : 16
Thief will steal 5 and 11

@dp

solution:
dp func: d[i] = max{d[i-2] + nums[i], d[i-1]}

O(n) O(n) space
optimize: use O(1) space
 */
public class MaximumStolenValue {
    static int maxLoot(int hval[], int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return hval[0];
        if (n == 2)
            return Math.max(hval[0], hval[1]);

        // dp[i] represent the maximum value stolen
        // so far after reaching house i.
        int[] dp = new int[n];

        // Initialize the dp[0] and dp[1]
        dp[0] = hval[0];
        dp[1] = Math.max(hval[0], hval[1]);

        // Fill remaining positions
        for (int i = 2; i < n; i++)
            dp[i] = Math.max(hval[i] + dp[i - 2], dp[i - 1]);

        return dp[n - 1];
    }

    // O(1) space
    static int maxLootOptimize(int hval[], int n)
    {
        if (n == 0)
            return 0;

        int value1 = hval[0];
        if (n == 1)
            return value1;

        int value2 = Math.max(hval[0], hval[1]);
        if (n == 2)
            return value2;

        // contains maximum stolen value at the end
        int max_val = 0;

        // Fill remaining positions
        for (int i=2; i<n; i++)
        {
            max_val = Math.max(hval[i]+value1, value2);
            value1 = value2;
            value2 = max_val;
        }

        return max_val;
    }

    // Driver program
    public static void main(String[] args) {
        int hval[] = {6, 7, 1, 3, 8, 2, 4};
        int n = hval.length;
        System.out.println("Maximum loot value : " + maxLoot(hval, n));
    }
}
