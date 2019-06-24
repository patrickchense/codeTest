package leetcode.matrix;

/*
https://leetcode.com/problems/number-of-islands/
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3

@matrix
@DFS
@answered
@review

经典DFS， 理解DFS的过程, 如何递归

 */
public class LT200_NumberOfIslands {

    public static void dfs (int r, int c, int maxR, int maxC, char[][] grid) {
        if (r<0 || r>=maxR || c<0 || c>=maxC) return;
        if (grid[r][c]=='0') return;  // 这里很关键，不必要visited[][] 来标记了，直接改0
        grid[r][c]='0'; //instead of using memory to store a visited array, simply alter the visited elements to be '0'
        // DFS 的过程，四个方向
        dfs(r-1, c, maxR, maxC, grid);
        dfs(r+1, c, maxR, maxC, grid);
        dfs(r, c-1, maxR, maxC, grid);
        dfs(r, c+1, maxR, maxC, grid);
    }

    public static int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        if (rows==0) {return 0;}
        int col = grid[0].length;

        for (int c1=0; c1<col; c1++) {
            for (int r1=0; r1<rows; r1++) {
                if (grid[r1][c1]=='1') {
                    dfs(r1, c1, rows, col, grid);
                    islands++;
                }
            }
        }

        return islands;

    }
}
