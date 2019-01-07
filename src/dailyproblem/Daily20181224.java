package dailyproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a mapping of digits to letters (as in a phone number), and a digit string, return all possible letters the number could represent. You can assume each valid number in the mapping is a single digit.

For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} then “23” should return [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].

@yelp

a phone number question
@dfs
@solved
 */
public class Daily20181224 {

    public static String[][] phoneNumberMatch = new String[][] {
            {"a", "b", "c"}, //2
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r"},
            {"s", "t", "u"},
            {"v", "w", "x"},
            {"y", "z"},
    };

    public static void main(String[] args){
        long cur = System.currentTimeMillis();
        System.out.println(Arrays.toString(phoneNumbers("23")));
        System.out.println(Arrays.toString(phoneNumbers("789")));
        System.out.println(Arrays.toString(phoneNumbers("23456789")));
        System.out.println("cost: " + (System.currentTimeMillis() - cur));
        cur = System.currentTimeMillis();
        System.out.println(Arrays.toString(letterCombinations("23").toArray()));
        System.out.println(Arrays.toString(letterCombinations("789").toArray()));
        System.out.println(Arrays.toString(letterCombinations("23456789").toArray()));
        System.out.println("cost: " + (System.currentTimeMillis() - cur));
    }

    public static String[] phoneNumbers(String ph) {
        if (ph.length() == 1) {
            return phoneNumberMatch[Integer.valueOf(ph) - 2];
        }
        String[] cur = phoneNumberMatch[(int) ph.charAt(0) -48 -2];
        String[] subs = phoneNumbers(ph.substring(1));
        String[] all = new String[cur.length * subs.length];
        int i = 0;
        for (String a : cur) {
            for (String b : subs) {
                all[i++] = a + b;
            }
        }
        return all;
    }

    // better solution, time cost not better, but I think the memory use will be better
    // https://github.com/awangdev/LintCode/blob/master/Java/Letter%20Combinations%20of%20a%20Phone%20Number.java
    public static List<String> letterCombinations(String digits) {
        final List<String> rst = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return rst;
        }

        //Prepare map
        List<String> list = new ArrayList<>();
        dfs(rst, list, digits.toCharArray(), 0);

        return rst;
    }

    public static void dfs(List<String> rst, List<String> list, char[] digit, int level) {
        if (list.size() == digit.length) {
            StringBuffer sb = new StringBuffer();
            for (String str : list) {
                sb.append(str);
            }
            rst.add(sb.toString());
            return;
        }

        String[] letters = phoneNumberMatch[(int) digit[level] -48 -2];
        for (String letter : letters) {
            list.add(letter);
            dfs(rst, list, digit, level + 1);
            list.remove(list.size() - 1);
        }
    }
}
