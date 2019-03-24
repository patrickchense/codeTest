package daily2019;

import java.util.Stack;

/*
Given an N by M matrix consisting only of 1's and 0's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

[[1, 0, 0, 0],
 [1, 0, 1, 1],
 [1, 0, 1, 1],
 [0, 1, 0, 0]]
Return 4.

@Google

@matrix
@dp
@review
@answered

https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
 */
public class D20190217 {

    public static void main(String[] args) {
        int R = 4;
        int C = 4;

        int A[][] = { {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };
        System.out.println("Area of maximum rectangle is " +
                maxRectangle(R,C,A));

        int arr[][] = {{1, 0, 0, 0}, {1, 0, 1, 1}, {1, 0, 1, 1}, {0, 1, 0, 0}};
        System.out.println("Area of maximum rectangle is " +
                maxRectangle(R,C,arr));
    }

    /*
    怎么定义rectangle? dp?
      R[0,0] = 1,  R[0,1] = 0 / R[0,0] + 1, R[0,3] = 0 + 0
      R[1,0] = 1 + 1 = 2; R[1,1] =

Step 1: Find maximum area for row[0]
Step 2:
    for each row in 1 to N - 1
        for each column in that row
            if A[row][column] == 1
              update A[row][column] with
                A[row][column] += A[row - 1][column]
    find area for that row
    and update maximum area so far
Illustration :

step 1:    0 1 1 0  maximum area  = 2
step 2:
    row 1  1 2 2 1  area = 4, maximum area becomes 4
    row 2  2 3 3 2  area = 8, maximum area becomes 8
    row 3  3 4 0 0  area = 6, maximum area remains 8
     */
    // O(R x X)
    // Finds the maximum area under the histogram represented
    // by histogram.  See below article for details.
    // https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
    static int maxHist(int R,int C,int row[])
    {
        // Create an empty stack. The stack holds indexes of
        // hist[] array/ The bars stored in stack are always
        // in increasing order of their heights.
        Stack<Integer> result = new Stack<Integer>();

        int top_val;     // Top of stack

        int max_area = 0; // Initialize max area in current
        // row (or histogram)

        int area = 0;    // Initialize area with current top

        // Run through all bars of given histogram (or row)
        int i = 0;
        while (i < C)
        {
            // If this bar is higher than the bar on top stack,
            // push it to stack
            if (result.empty() || row[result.peek()] <= row[i])
                result.push(i++);

            else
            {
                // If this bar is lower than top of stack, then
                // calculate area of rectangle with stack top as
                // the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before
                // top in stack is 'left index'
                top_val = row[result.peek()];
                result.pop();
                area = top_val * i;

                if (!result.empty())
                    area = top_val * (i - result.peek() - 1 );
                max_area = Math.max(area, max_area);
            }
        }

        // Now pop the remaining bars from stack and calculate
        // area with every popped bar as the smallest bar
        while (!result.empty())
        {
            top_val = row[result.peek()];
            result.pop();
            area = top_val * i;
            if (!result.empty())
                area = top_val * (i - result.peek() - 1 );

            max_area = Math.max(area, max_area);
        }
        return max_area;
    }

    // Returns area of the largest rectangle with all 1s in
    // A[][]
    static int maxRectangle(int R,int C,int A[][])
    {
        // Calculate area for first row and initialize it as
        // result
        int result = maxHist(R,C,A[0]);

        // iterate over row to find maximum rectangular area
        // considering each row as histogram
        for (int i = 1; i < R; i++)
        {

            for (int j = 0; j < C; j++)

                // if A[i][j] is 1 then add A[i -1][j]
                if (A[i][j] == 1) A[i][j] += A[i - 1][j];


            // Update result if area with current row (as last
            // row of rectangle) is more
            result = Math.max(result, maxHist(R,C,A[i]));
        }

        return result;
    }

}
