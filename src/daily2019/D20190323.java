package daily2019;

/*
Given a start word, an end word, and a dictionary of valid words, find the shortest transformation sequence from start to end such that only one letter is changed at each step of the sequence,
 and each transformed word exists in the dictionary. If there is no possible transformation, return null. Each word in the dictionary have the same length as start and end and is lowercase.

For example, given start = "dog", end = "cat", and dictionary = {"dot", "dop", "dat", "cat"}, return ["dog", "dot", "dat", "cat"].

Given start = "dog", end = "cat", and dictionary = {"dot", "tod", "dat", "dar"}, return null as there is no possible transformation from dog to cat.

@Facebook
@medium
@solved
@logical
@20min

通过统计dic中每个字符串，分别含有两个字符串数字的统计来处理

 */
public class D20190323 {

    public static void main(String[] args) {
        System.out.println(isTransformed("dog", "cat", new String[] {"dot", "dop", "dat", "cat"}));
        System.out.println(isTransformed("dog", "cat", new String[] {"dot", "tod", "dat", "dar"}));
    }

    // 问题在于，找到不同的字符，找到每次不同一个字符的，应该在dic中找到所有，包含两个str的字符的字段，然后排序  30, 21, 12,03 就行

    // O(n * len) O(len)
    public static boolean isTransformed(String str1, String str2, String[] strings) {
        int[] exists = new int[str1.length()];
        int len = str1.length();
        for (String str : strings) {
            int e1 = 0;
            int e2 = 0;
            for (char c : str1.toCharArray()) {
                if (str.contains(String.valueOf(c))) e1++;
            }
            for (char c : str2.toCharArray()) {
                if (str.contains(String.valueOf(c))) e2++;
            }
            if (e1 + e2 != len) continue;
            if (e2 > 0 && exists[e2-1] == 0) exists[e2-1] = 1;
        }

        for (int i : exists) {
            if (i != 1) return false;
        }
        return true;
    }
}
