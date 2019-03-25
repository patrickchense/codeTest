package daily2019;

/*
You are given a 2-d matrix where each cell represents number of coins in that cell. Assuming we start at matrix[0][0],
and can only move right or down, find the maximum number of coins you can collect by the bottom right corner.

For example, in this matrix

0 3 1 1
2 0 0 4
1 5 3 1
The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.

@matrix
@dp?
@solved

这是比较简单的dp，找到表达式一下子解决了
 */
public class D20190203 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0,3,1,1},
                {2,0,0,4},
                {1,5,3,1}
        };
        System.out.println(coinsCount(matrix));
    }

    // 应该是典型dp
    public static int coinsCount(int[][] matrix) {
        int[][] counts = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) counts[i][j] = 0;
        // dp 表达式,  C[n][m] = max[n-1][m], [n][m-1]
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int up = 0;
                if (i > 0) {
                    up = counts[i-1][j];
                }
                int left = 0;
                if (j > 0) {
                    left = counts[i][j-1];
                }
                counts[i][j] = Math.max(left, up) + matrix[i][j];
            }
        }
        return counts[matrix.length-1][matrix[0].length-1];
    }
}
