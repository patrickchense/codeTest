package daily2019;

import util.ArrayUtil;

/*
Given a 2-D matrix representing an image, a location of a pixel in the screen and a color C,
replace the color of the given pixel and all adjacent same colored pixels with C.

For example, given the following matrix, and location pixel of (2, 2), and 'G' for green:

B B W
W W W
W W W
B B B
Becomes

B B G
G G G
G G G
B B B

@matrix
@solved
 */

public class D20190304 {
    public static void main(String[] args) {
        Character[][] colors = new Character[][]{{'B', 'B', 'W'},{'W', 'W', 'W'},{'W', 'W', 'W'},{'B', 'B', 'B'}};
        replaceColor('G', 2, 2, colors);
        ArrayUtil.printMatrix(colors);
    }

    // 好像只能O(n*m)
    public static void replaceColor(char color, int x, int y, Character[][] colors) {
        char c = colors[x][y];
        for (int i = 0; i < colors.length; i++) {
            for(int j = 0; j < colors[i].length; j++) {
                if (colors[i][j] == c) colors[i][j] = color;
            }
        }
    }
}
