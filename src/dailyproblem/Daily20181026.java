package dailyproblem;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/*

Given a dictionary of words and a string made up of those words (no spaces),
 return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond']

@Microsoft
@string
@substring
@sovled

感觉可以优化，没有最优

 */
public class Daily20181026 {

    public static void main(String[] args) {
        ArrayUtil.printList(findStrInDic(new String[]{"quick", "brown", "the", "fox"}, "thequickbrownfox"));
        ArrayUtil.printList(findStrInDic(new String[]{"bed", "bath", "bedbath", "beyond", "and"}, "bedbathandbeyond"));
    }

    // O(n*k) ?
    public static List<String> findStrInDic(String[] dic, String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        boolean isFinished = false;
        while(!isFinished) {
            int t = i;
            for (String d : dic) {
                int j = i + d.length();
                if (j <= str.length() && str.substring(i, j).equals(d)) {
                    res.add(d);
                    i = j;
                    if (j == str.length()) {
                        isFinished = true;
                        break;
                    }
                }
            }
            if (t == i) break; // 代表没有一个dicmatch，直接退出
        }
        return res.isEmpty() || !isFinished ? null : res;
    }
}
