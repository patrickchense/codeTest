package dailyproblem;

/*
Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.

For example, given the following matrix:

[[1,  2,  3,  4,  5],
 [6,  7,  8,  9,  10],
 [11, 12, 13, 14, 15],
 [16, 17, 18, 19, 20]]
You should print out the following:

1
2
3
4
5
10
15
20
19
18
17
16
11
6
7
8
9
14
13
12

@amazon
@solved
@matrix
@classic

matrix的经典之一，clock遍历
https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/

 */
public class Daily20181208 {

    /*
    two ways to loop
        1.  horizontal or vertical
        2.  left to right or right to left
        3.  up to down or down to up
        4 set limit

        clockwise is ,  horizontal(left -> right ),  vertical(up -> down), horizontal(right -> left),  vertical(down->up)

        logical mind is very important
     */
    public static void main(String[] args) {
        int a[][] = { {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        printMatrixClocwise(a);
    }

    public static void printMatrixClocwise(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i, k = 0, l = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */

        while (k < m && l < n)
        {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i)
            {
                System.out.print(matrix[k][i]+" ");
            }
            k++;

            // Print the last column from the remaining columns
            for (i = k; i < m; ++i)
            {
                System.out.print(matrix[i][n-1]+" ");
            }
            n--;

            // Print the last row from the remaining rows */
            if ( k < m)
            {
                for (i = n-1; i >= l; --i)
                {
                    System.out.print(matrix[m-1][i]+" ");
                }
                m--;
            }

            // Print the first column from the remaining columns */
            if (l < n)
            {
                for (i = m-1; i >= k; --i)
                {
                    System.out.print(matrix[i][l]+" ");
                }
                l++;
            }
        }
    }
}
