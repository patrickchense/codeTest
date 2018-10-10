package GoldmanSachs;

import java.util.*;

/*
Go through a string and find the first non-duplicate letter

think: use Map?
https://leetcode.com/problems/first-unique-character-in-a-string/description/
solution:
    如果只有26个字母， int[] 占位
    Map, 优化版(firstUniqChar), jdk8api


related:
TODO remove duplicate letters
https://leetcode.com/problems/remove-duplicate-letters/description/
remove duplicate
https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
TODO delete duplicate emails
https://leetcode.com/problems/delete-duplicate-emails/description/
TODO find all duplicates in array
https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
TODO remove duplicates in sorted array
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
TODO find duplicates in File System
https://leetcode.com/problems/find-duplicate-file-in-system/description/
TODO contains duplicate III
https://leetcode.com/problems/contains-duplicate-iii/


 */
public class StringNonDuplicate {

    public static void main(String args[]) {
        String s = "ksdflksdfjkls;dfjf9";
        System.out.printf("first, non duplicate:%c\n", nonDuplicateLetter(s));
        s = "a0kcvldi30cvkdfl;";
        System.out.printf("first, non duplicate:%c\n", nonDuplicateLetter(s));
    }

    private static Character nonDuplicateLetter(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return s.charAt(i);
        }
        return null;
    }

    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(char ch:s.toCharArray())
            map.merge(ch, 1, Integer::sum);
        for(Map.Entry<Character, Integer> entry: map.entrySet())
            if(entry.getValue() == 1)
                return s.indexOf(entry.getKey());
        return -1;
    }


    public int firstUniqCharSet(String s) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c))
                set.remove(c);
            else
                set.add(c);
        }
        List<Character> list = new ArrayList<>(set);
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == list.get(0))
                return i;
        }
        return -1;
    }
}
