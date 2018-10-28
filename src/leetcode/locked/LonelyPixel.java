package leetcode.locked;

/*
leetcode 531
http://massivealgorithms.blogspot.com/2017/08/leetcode-531-lonely-pixel-i.html

Given a picture consisting of black and white pixels, find the number of black lonely pixels.
The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.
A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.
Example:
Input:
[['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]

Output: 3
Explanation: All the three 'B's are black lonely pixels.

Note:
The range of width and height of the input 2D array is [1,500].


 */
public class LonelyPixel {

    public static void main(String args[]) {

    }

    /*
W + 1 = X --> one item in the row/column
B + 1 = C --> one item in the row/column, and the first row is the black pixel
W + 2 = Y --> two items in the row/column
W - 1 = V --> this prevents wrap-around past W if there are more than 255 black pixels in a row/column
     */
    // O(mn) O(1)
    public static int countBlackPixel(char[][] picture) {
        int n = picture.length, m = picture[0].length;

        int firstRowCount = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (picture[i][j] == 'B') {
                    if (picture[0][j] < 'Y' && picture[0][j] != 'V') picture[0][j]++;
                    if (i == 0) firstRowCount++;
                    else if (picture[i][0] < 'Y' && picture[i][0] != 'V') picture[i][0]++;
                }

        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (picture[i][j] < 'W' && (picture[0][j] == 'C' || picture[0][j] == 'X')) {
                    if (i == 0) count += firstRowCount == 1 ? 1 : 0;
                    else if (picture[i][0] == 'C' || picture[i][0] == 'X') count++;
                }

        return count;
    }

    //solution 2:
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    col[j]++;
                    if (row[i] == 0) row[i] = j + 1;// give a offset so we can deal with the j=0 situation
                        // you can change to j+ any offset.
                    else row[i] = -1;
                }
            }
        }
        for (int r : row) {
            if (r > 0 && col[r - 1] == 1) res++; // remove the offset
        }

        return res;
    }

    // solution 3
    // O(m*n), O(m+n)
    public int findLonelyPixel3(char[][] picture) {
        int n = picture.length, m = picture[0].length;

        int[] rowCount = new int[n], colCount = new int[m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (picture[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }

        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) count++;

        return count;
    }

    // solution 4 dfs
    public int findLonelyPixel4(char[][] picture) {
        int numLone = 0;
        for (int row = 0; row < picture.length; row++) {
            for (int col = 0; col < picture[row].length; col++) {
                if (picture[row][col] == 'W') {
                    continue;
                }
                if (dfs(picture, row - 1, col, new int[]{-1, 0}) && dfs(picture, row + 1, col, new int[]{1, 0})
                        && dfs(picture, row, col - 1, new int[]{0, -1}) && dfs(picture, row, col + 1, new int[]{0, 1})) {
                    numLone++;
                }
            }
        }
        return numLone;
    }

    // use dfs to find if current pixel is lonely
    private boolean dfs(char[][] picture, int row, int col, int[] increase) {
        // base case
        if (row < 0 || row >= picture.length || col < 0 || col >= picture[0].length) {
            return true;
        } else if (picture[row][col] == 'B') {
            return false;
        }
        // recursion
        return dfs(picture, row + increase[0], col + increase[1], increase);
    }
}
