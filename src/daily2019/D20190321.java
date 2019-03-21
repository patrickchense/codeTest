package daily2019;

import util.ArrayUtil;

/**
 Given an N by N matrixrix, rotate it by 90 degrees clockwise.

 For example, given the following matrixrix:

 [[1, 2, 3],
 [4, 5, 6],
 [7, 8, 9]]
 you should return:

 [[7, 4, 1],
 [8, 5, 2],
 [9, 6, 3]]
 Follow-up: What if you couldn't use any extra space?

 @Facebook
 @matrixrix

 Clock rotate
 anti
 https://www.geeksforgeeks.org/inplace-rotate-square-matrixrix-by-90-degrees/
 https://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/

 clockwise
 https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/

 180 anti
 https://www.geeksforgeeks.org/rotate-matrix-180-degree/

 M*N matrix rotate K times to the right side
 https://www.geeksforgeeks.org/rotate-matrix-right-k-times/


 90 degree means first row -> last col,  second row -> last -1 col ... last row -> first col
 */
public class D20190321 {

    public static void main(String[] args){
        int matrix[][] = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        ArrayUtil.printMatrix(rotate90(matrix));
        matrix = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        ArrayUtil.printMatrix(rotate90(matrix));
        System.out.println("-------------------");
        Integer[][] mi = new Integer[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        ArrayUtil.printMatrix(rotate902(mi));

        System.out.println("-------------------");
        mi = new Integer[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        ArrayUtil.printMatrix(rotate903(mi));
        mi = new Integer[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        ArrayUtil.printMatrix(rotate903(mi));

        System.out.println("-------------------");
        mi = new Integer[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        ArrayUtil.printMatrix(rotate90Clockwise(4, mi));
    }


    // first row -> last col,  a[0][0] -> a[0][N-1] , a[0][1] -> a[1][N-1] , means  col number -> row number
    // O(n^2) time, O(n^2) space how to improve?
    public static Integer[][] rotate90(int[][] matrix) {
        int len = matrix.length;
        Integer[][] result = new Integer[len][len];
        for (int i = 0; i < len; i++) {
            for (int j=0; j < len; j++) {
                result[j][len -1 - i] = matrix[i][j];
            }
        }
        return result;
    }

    // 原地替换? what's the BigO?
    /**
     * how ? 还是需要循环2次
     * anti-clockwise
     * @param matrix
     * @return
     */
    public static Integer[][] rotate902(Integer[][] matrix) {
// Consider all squares one by one
        int N = matrix.length;
        for (int x = 0; x < N / 2; x++)
        {
            // Consider elements in group of 4 in  
            // current square 
            for (int y = x; y < N-x-1; y++)
            {
                // store current cell in temp variable 
                int temp = matrix[x][y];

                // move values from right to top 
                matrix[x][y] = matrix[y][N-1-x];

                // move values from bottom to right 
                matrix[y][N-1-x] = matrix[N-1-x][N-1-y];

                // move values from left to bottom 
                matrix[N-1-x][N-1-y] = matrix[N-1-y][x];

                // assign temp to left 
                matrix[N-1-y][x] = temp;
            }
        }
        return matrix;
    }

    static Integer[][] rotate90Clockwise(int N, Integer a[][]) {

        // Traverse each cycle
        for (int i = 0; i < N / 2; i++)
        {
            for (int j = i; j < N - i - 1; j++)
            {
                // Swap elements of each cycle
                // in clockwise direction
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
        return a;
    }


    /**
     steps:  anti-clockwise
     Let the given matrix be
     1  2  3  4
     5  6  7  8
     9  10 11 12
     13 14 15 16

     First we find transpose.
     1 5 9 13
     2 6 10 14
     3 7 11 15
     4 8 12 16

     Then we reverse elements of every column.
     4 8 12 16
     3 7 11 15
     2 6 10 14
     1 5  9 13
     */
    //O(1) space, O(R*C)
    public static Integer[][] rotate903(Integer[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0, k = matrix[0].length - 1;
                 j < k; j++, k--) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = temp;
            }
        }
        return matrix;
    }

    /*
There are four steps :
1- Find transpose of matrix.
2- Reverse columns of the transpose.
3- Find transpose of matrix.
4- Reverse columns of the transpose
Let the given matrix be
1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16

First we find transpose.
1 5 9 13
2 6 10 14
3 7 11 15
4 8 12 16

Then we reverse elements of every column.
4 8 12 16
3 7 11 15
2 6 10 14
1 5  9 13

then transpose again
4 3 2 1
8 7 6 5
12 11 10 9
16 15 14 13

Then we reverse elements of every column again
16 15 14 13
12 11 10 9
8 7 6 5
4 3 2 1

简单说上面的rotate903 进行2次
     */
    public static Integer[][] rotate180(Integer[][] matrix) {
        int N = matrix.length;

        return matrix;
    }
}
