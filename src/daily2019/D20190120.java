package daily2019;

/*
Given two strings A and B, return whether or not A can be shifted some number of times to get B.

For example, if A is abcde and B is cdeab, return true. If A is abc and B is acb, return false.

@Google
@string
@twopointers
@slidewindow
@solved
 */
public class D20190120 {

    public static void main(String[] args) {
        System.out.println(isShifted("abcde", "cdeab"));
        System.out.println(isShifted("abc", "acb"));
        System.out.println(isShifted("abadec", "adecab"));
    }

    // same order, same character
    // 难点在于重复字母怎么处理？
    // 两指针，一前一后，然后重复判断
    // O(n) O(1) space?,  my algorithm based on the first num appearance times
    public static boolean isShifted(String s1, String s2) {
        char c = s1.charAt(0);
        int[] pos = new int[s2.length()];
        int j=0;
        for (int i = 0; i < s2.length(); i++) {
            if (c == s2.charAt(i)) {
                pos[j++] = i;
            }
        }

        boolean isMatch = true;
        for (int k = 0; k < j; k++) {
            int start = pos[k];
            isMatch = true;
            for (int i = 0; i < s1.length(); i++) {
                if (s2.charAt(start++) != s1.charAt(i)) {
                    isMatch = false;
                    break;
                }
                if (start == s2.length()) start = 0;
            }
        }
        return isMatch;
    }
}
