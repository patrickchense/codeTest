package amazon;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestPath {

    public static void main(String args[]) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> arr1 = Arrays.asList(1, 0, 0);
        List<Integer> arr2 = Arrays.asList(1, 0, 0);
        List<Integer> arr3 = Arrays.asList(1, 9, 1);
        arr.add(arr1);
        arr.add(arr2);
        arr.add(arr3);
        System.out.println(removeObstacle(3,3, arr));
    }

    static int result = 0;

    static int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        // WRITE YOUR CODE HERE
        int desX=0, desY=0;
        boolean[][] visited = new boolean[numRows][numColumns];
        for (int i = 0; i < numRows; i++ ) {
            for (int j = 0; j < numColumns; j++) {
                if (lot.get(i).get(j) == 1) {
                    visited[i][j] = true;
                }
                if (lot.get(i).get(j) == 0) {
                    visited[i][j] = false;
                }
                if (lot.get(i).get(j) == 9) {
                    desX = i;
                    desY = j;
                    visited[i][j] = true;
                }
            }
        }

        search(lot, numRows, numColumns, visited,0, 0, desX, desY);
        return result;
    }

    private static void search( List<List<Integer>> lot, int rows, int cols, boolean[][] visited, int x, int y, int desX, int desY) {
        if (x <0 || y < 0 || x >= rows || y >= cols || !visited[x][y]) return;
        if (x == desX && y == desY) {
            return;
        }
        result++;
        visited[x][y] = false;
        search(lot, rows, cols, visited, x-1, y, desX, desY);
        search(lot, rows, cols, visited, x+1, y, desX, desY);
        search(lot, rows, cols, visited, x, y-1, desX, desY);
        search(lot, rows, cols, visited, x, y+1, desX, desY);
        visited[x][y] = true;

    }
}
