package daily2019;

import java.util.HashMap;
import java.util.Map;

/*
Given a string and a set of characters, return the shortest substring containing all the characters in the set.

For example, given the string "figehaeci" and the set of characters {a, e, i}, you should return "aeci".

If there is no substring containing all the characters in the set, return null.

@Square
@string
@substring
@slidewindow
@dp?

@solved
 */
public class D20190115 {

    public static void main(String[] args) {
        System.out.println(subString("figehaeci", new char[]{'a', 'e', 'i'}));
        System.out.println(subString("fiagehaedci", new char[]{'a', 'e', 'i'}));
    }

    // 关键在于 怎么移动，同时计算大小和判断是否存在
    public static String subString(String str, char[] cs) {
        Map<Character, Integer> pos = new HashMap<>();
        for (char c : cs) {
            pos.put(c, -1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (pos.containsKey(str.charAt(i))) { // O(1)
                int prePos = pos.get(str.charAt(i));
                if (prePos == -1) {
                    pos.put(str.charAt(i), i);
                } else {
                    // already has one, 这里是关键，已经有字母的时候怎么替换
                    int max = -1;
                    for (int dis : pos.values()) {
                        if (dis == prePos) continue;
                        if (dis == -1) continue;
                        max = Math.max(dis, max);
                    }
                    if (max == -1 || Math.abs(max - i) < Math.abs(max - prePos)) { // 这里差点错了，关于距离的判断
                        pos.put(str.charAt(i), i); // replace because it's closer
                    }
                }
            }
        }
        int min = str.length();
        int max = -1;
        for (int dis : pos.values()) {
            if (dis == -1) return null;
            min = Math.min(min, dis);
            max = Math.max(max, dis);
        }
        return str.substring(min, max + 1);
    }
}
