package adyen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * nail hammer down
 * <p>
 * 一组数字，然后升序， 给一个K
 * 每个数字可以被减少 0... K， 计算最大的相同的数字
 */
public class Test2 {

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1, 1, 3, 3, 3, 4, 5, 5, 5, 5}, 2));
//        System.out.println(solution(new int[]{1, 1, 3, 3, 3, 4, 5, 5, 5, 5, 8, 8, 8, 8, 8, 8}, 2));
//        System.out.println(solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 5, 5, 5, 8, 8, 8, 8, 8, 8}, 2));
//        System.out.println(solution(new int[]{1, 1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 8, 8, 8, 8, 8, 8}, 6));
//        System.out.println(solution(new int[]{1, 1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 8, 8, 8, 8, 8, 8}, 7));
        System.out.println(solution(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5}, 1));
    }

    // actually the result is how many nails are the same length in the end
    // dp ?
    // dp[i] = d[i-1] +
    public static int solution(int[] A, int K) {
        int n = A.length;
        int count = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> uniqNums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && A[i] == A[i + 1]) {
                count++;
            } else {
                counts.put(A[i], count + 1);
                count = 0;
                uniqNums.add(A[i]);
            }
        }
        if (count != 0) {
            counts.put(A[A.length - 1], count);
            uniqNums.add(A[A.length - 1]);
        }
        int len = uniqNums.size();
        int best = 0;
        for (int i = 0; i < len; i++) {
            int cur = counts.get(uniqNums.get(i));
            if (i < len - 1 && uniqNums.get(i + 1) - uniqNums.get(i) > K) {
                // next number is out of range
                best = Math.max(best, cur);
            } else if (i < len - 1) {
                int next = counts.get(uniqNums.get(i + 1));
                if (next >= K) {
                    best = Math.max(best, cur + K);
                } else {
                    cur = cur + next;
                    int curK = K - next;
                    // find the rest of K number if exist
                    for (int j = i + 2; j < len; j++) {
                        if (uniqNums.get(j) - uniqNums.get(i) > K) {
                            break;
                        } else {
                            int nextCur = counts.get(uniqNums.get(j));
                            if (nextCur >= curK) {
                                best = Math.max(best, curK + cur);
                                curK = 0;
                                break;
                            } else {
                                cur += nextCur;
                                curK -= nextCur;
                            }
                        }
                    }
                    if (curK != 0) {
                        best = Math.max(best, cur);
                    }
                }
            } else {
                best = Math.max(best, cur);
            }
        }
        return best;
    }
}
