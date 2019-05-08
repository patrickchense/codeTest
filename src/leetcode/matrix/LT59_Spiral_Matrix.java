package leetcode.matrix;

/*
https://leetcode.com/problems/spiral-matrix-ii/

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]


@matrix
@answered

@medium

存逻辑题，没想通，简单定义上下左右，在调整，就行
 */
public class LT59_Spiral_Matrix {


    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];

        int left=0, right=n-1;
        int top=0, bottom=n-1;
        int v=1, limit=n*n;
        while(v<=limit){
            for(int i=left;i<=right;i++) res[top][i]=v++;
            top++;
            for(int i=top;i<=bottom;i++) res[i][right]=v++;
            right--;
            for(int i=right;i>=left;i--) res[bottom][i]=v++;
            bottom--;
            for(int i=bottom;i>=top;i--) res[i][left]=v++;
            left++;
        }
        return res;
    }
}
