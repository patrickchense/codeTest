package GoldmanSachs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/*
Given a list of segments (Where a segment is a line with a start Point & an endpoint),
sort these segments to form a continuous Path.
 e.g. [(2,1),(1,4),(3,2)] should be returned as [(3,2),(2,1),(1,4)].
 Assume that there are no 2 segments with the same start point. Also assume that there are no 2 segments
 which cover the same segment in opposite directions e.g (1,2) & (2,1)

think: i,j;   i, i+1, i+1, i+n, i+n ... j
it's a question about sort

the key should be find the head and tail


related
TODO array nums, build continuous pair
https://leetcode.com/problems/contiguous-array/description/
TODO continuous subarray sum up to target
https://leetcode.com/problems/continuous-subarray-sum/description/



 */
public class ContinuousPath {

    public static void main(String[] args) {

        int[][] points = new int[][]{{2,1}, {1,4}, {3,2}};
//        Stream.of(continuousPath(points, 0, points.length - 1)).map(a -> String.join(";", Arrays.toString(a))).forEach(System.out::println);
        Stream.of(continuousPath(points)).map(a -> String.join(";", Arrays.toString(a))).forEach(System.out::println);
    }

    public static int[][] continuousPath(int[][] points) {
        Map<Integer, Integer> pointMap = new HashMap<>();
        int[] starts = new int[points.length];
        int i = 0;
        for (int[] point : points) {
            pointMap.put(point[0], pointMap.getOrDefault(point[0], 0) + 1);
            pointMap.put(point[1], pointMap.getOrDefault(point[1], 0) - 1);
            starts[i] = points[i][0];
            i++;
        }
        int head = 0;
        int headIndex = 0;
        int tail = 0;
        int tailIndex = 0;
        for (Map.Entry<Integer, Integer> point : pointMap.entrySet()) {
            if (point.getValue() == 1) {
                for (int k = 0; k < starts.length; k++) {
                    if (starts[k] == point.getKey()) {
                        head = starts[k];
                        headIndex = k;
                        break;
                    }
                }
                if (head == 0) {

                }
            }
            else if (point.getValue() == -1) {
                tail = point.getKey();
                for (int j = 0; j < points.length; j++) {
                    if (points[j][1] == tail) {
                        tailIndex = j;
                        break;
                    }
                }
            }
            if (head != 0 && tail != 0) break;
        }
        if (headIndex != 0) swap(points, headIndex, 0);
        if (tailIndex != points.length -1) swap(points, tailIndex, points.length - 1);
        for (int j = 1; j < starts.length - 1; j++) {
            if (points[j-1][1] != points[j][0]) {
                for (int g = j+1; g < points.length - 1; g++) {
                    if (points[g][0] == points[j-1][1]) {
                        swap(points, j, g);
                        break;
                    }
                }
            }

        }
        return points;
    }

    /*
    try quick sort, not working
     */
    public static int[][] continuousPath(int[][] points, int low, int high) {
        if (low < high) {
            int pi = partition(points, low, high);
            continuousPath(points, low, pi -1);
            continuousPath(points, pi + 1, high);
        }
        return points;
    }

    private static int partition(int[][] points, int low, int high) {
        int[] povit = points[high - 1];
        int i = low -1;
        for (int j = low; j < high; j++) {
            if (points[j][1] <= povit[0]) {
                i++;
                if (i != j) swap(points, i, j);
            }
        }
        if (i + 1 != high) swap(points, i+1, high);
        return i + 1;
    }

    private static void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}
