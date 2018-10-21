package leetcode.locked;

/*
leetcode 800
https://blog.csdn.net/zjucor/article/details/79599224

In the following, every capital letter represents some hexadecimal digit from 0 to f.

The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand.  For example, "#15c" is shorthand for the color "#1155cc".

Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.

Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it can be represented as some "#XYZ"

Example 1:
Input: color = "#09f166"
Output: "#11ee66"
Explanation:
The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
This is the highest among any shorthand color.

Note:

color is a string of length 7.
color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f
Any answer which has the same (highest) similarity as the best answer will be accepted.
All inputs and outputs should use lowercase letters, and the output is 7 characters.


 */
public class RGBColor {
    private int[] parseColor(String color) {
        int r = Integer.parseInt(color.substring(1, 3), 16);
        int g = Integer.parseInt(color.substring(3, 5), 16);
        int b = Integer.parseInt(color.substring(5, 7), 16);
        return new int[]{r, g, b};
    }

    private int getDistance(int[] color, int[] dup) {
        int s = 0;
        s += (color[0] - dup[0]) * (color[0] - dup[0]);
        s += (color[1] - dup[1]) * (color[1] - dup[1]);
        s += (color[2] - dup[2]) * (color[2] - dup[2]);
        return s;
    }

    /*
    brute force , O(n^3)

     */
    public String similarRGB(String color) {
        int[] rgb = parseColor(color);
        int[] res = new int[3];
        int minDis = Integer.MAX_VALUE;
        for (int r = 0; r < 16; ++r) {
            for (int g = 0; g < 16; ++g) {
                for (int b = 0; b < 16; ++b) {
                    int[] dup = new int[]{16 * r + r, 16 * g + g, 16 * b + b};
                    int d = getDistance(rgb, dup);
                    if (d < minDis) {
                        minDis = d;
                        res = dup;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i = 0; i < 3; ++i) {
            if (res[i] == 0) sb.append("00");
            else sb.append(Integer.toString(res[i], 16));
        }
        return sb.toString();
    }

    /*
    0x00(0) , 0x11(17), 0x22(34), 0x33(51), ........., 0xff(255) ]
所求均是17的倍数。

所以可以先计算出某两位16进制对应的10进制val，然后与17进行计算，取最接近的即可。
@math
Integer.toHexString()

     */
    public String similarRGB2(String color) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");

        for (int i = 1; i < color.length(); i += 2) {
            sb.append(findClosest(color.substring(i, i + 2)));
        }

        return sb.toString();
    }

    private String findClosest(String s) {
        int val = Integer.parseInt(s, 16);
        val = val / 17 + (val % 17 > 8 ? 1 : 0);
        return Integer.toHexString(17 * val);
    }

}
