package GoldmanSachs;

/*
Given a chessboard with a piece on it, need to calculate the number of possible # moves, and probability of the piece remaining on the board within "n" number of steps

original: leetcode 688
https://leetcode.com/problems/knight-probability-in-chessboard/description/

@dp

 */
public class ChessBoard {

    /**
     * k = d[1]*d[2]*...d[k]
     * d[i] =
     * r, c   r-2, c-1 , r-2, c+1, r +2 , c-1, r+2, c+1
     * r-1, c+2, r+1, c+2, r-1, c-2, r+1, c-2
     */
    int[][] moves = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, -1}, {2, 1}, {-2, -1}, {-2, 1}};

    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[K + 1][N][N];
        return helper(dp, N, K, r, c) / Math.pow(8.0, K);
    }

    private double helper(double[][][] dp, int N, int k, int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) return 0.0;
        if (k == 0) return 1.0;
        if (dp[k][r][c] != 0.0) return dp[k][r][c];
        for (int i = 0; i < 8; i++)
            dp[k][r][c] += helper(dp, N, k - 1, r + moves[i][0], c + moves[i][1]);
        return dp[k][r][c];
    }
}
