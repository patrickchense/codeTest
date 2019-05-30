package daily2019;

/*
Given a string with repeated characters, rearrange the string so that no two adjacent characters are the same. If this is not possible, return None.

For example, given "aaabbc", you could return "ababac". Given "aaab", return None.

@easy

@IBM

@solved

逻辑问题，简单处理即可
 */
public class D20190522 {

    public static void main(String[] args) {
        System.out.println(noAdjacentCharacter("aaabbc"));
        System.out.println(noAdjacentCharacter("aaab"));
    }

    // O(n^n)
    public static String noAdjacentCharacter(String str) {
        char[] cs = str.toCharArray();
        char[] csn = new char[cs.length];
        csn[0] = cs[0];
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == csn[i-1]) {
                for (int j = i+1; j < cs.length; j++) {
                    if (cs[j] != cs[i]) {
                        char t = cs[i];
                        cs[i] = cs[j];
                        cs[j] = t;
                        break;
                    }
                }
                if (cs[i] == csn[i-1]) return "None";
            }
            csn[i] = cs[i];
        }

        return new String(csn);
    }
}
