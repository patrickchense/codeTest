package GoldmanSachs;

/*
https://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/
Find length of the largest region in Boolean Matrix
Consider a matrix with rows and columns, where each cell contains either a ‘0’ or a ‘1’ and any cell containing a 1 is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally .If one or more filled cells are also connected, they form a region. find the length of the largest region.

Examples:

Input : M[][5] = { 0 0 1 1 0
                   1 0 1 1 0
                   0 1 0 0 0
                   0 0 0 0 1 }
Output : 6
Ex: in the following example, there are 2 regions one with length 1 and the other as 6.
    so largest region : 6

 solution
 @DFS
 @recursion
 eight neighbors, so dfs every neighbor, and update max
 */
public class LargestRegionInBooleanMatrix {

    public static int largestRegion(int[][] numbers) {
        boolean[][] visited = new boolean[numbers.length][numbers[0].length];

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                if (numbers[i][j] == 1 && !visited[i][j]) {
                    int count = 1;
                    count = DFS(numbers, i, j, visited, count);
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    private static int DFS(int[][] numbers, int i, int j, boolean[][] visited, int count) {
        int row[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int col[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            if (isSafe(numbers, i + row[k], j + col[k], visited)) {
                count ++;
                count = DFS(numbers, i+row[k], j+col[k], visited, count);
            }
        }
        return count;
    }

    private static boolean isSafe(int[][] numbers, int i, int j, boolean[][] visited) {
        return i >= 0 && j >= 0 && i < 4 && j < 5 && (numbers[i][j] == 1 && !visited[i][j]);
    }

    public static void main(String[] args) {
        int test[][] = { {0, 0, 1, 1, 0},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1}};
        System.out.println(largestRegion(test));
    }
}
