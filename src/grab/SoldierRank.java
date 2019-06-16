package grab;

import java.util.HashMap;
import java.util.Map;

public class SoldierRank {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,4,3,  0,2,2,3,0,0}));
        System.out.println(solution(new int[]{0,4,2}));
        System.out.println(solution(new int[]{4,4,3,3,1,0}));
    }

    public static int solution(int[] ranks) {
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int rank : ranks) {
            rankMap.put(rank, rankMap.getOrDefault(rank, 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> rank : rankMap.entrySet()) {
            if (rankMap.containsKey(rank.getKey() + 1)) {
                result += rank.getValue();
            }
        }
        return result;
    }
}
