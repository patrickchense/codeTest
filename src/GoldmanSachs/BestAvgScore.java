package GoldmanSachs;

import java.util.HashMap;
import java.util.Map;

/*
Given data structure [[“A”, “87”], [“B”, “100”], [“C”, “50”], [“B”, “50”]], calculate the best average score.

think: use Map

 */
public class BestAvgScore {

    public static void main(String[] args) {
        String[][] scores = new String[][]{{"A", "87"}, {"B", "100"}, {"C", "50"}, {"B", "50"}};
        System.out.println("best avg:" + bestAvg(scores));
    }

    /*
    O(n) space, O(n) time
     */
    public static double bestAvg(String[][] nums) {
        Map<String, Integer>  sums = new HashMap<>();
        int[] counts = new int[26];
        for (String[] num : nums) {
            if (sums.containsKey(num[0])) {
                sums.put(num[0], sums.get(num[0]) + Integer.valueOf(num[1]));
            } else {
                sums.put(num[0], Integer.valueOf(num[1]));
            }
            counts[num[0].charAt(0) - 'A'] += 1;
        }
        double max = 0;
        for (Map.Entry<String, Integer> sum : sums.entrySet()) {
            max = Math.max(max, (double)sum.getValue() / counts[sum.getKey().charAt(0) - 'A']);
        }
        return max;
    }



}
