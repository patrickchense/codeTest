package leetcode.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
leetcode 249
https://www.programcreek.com/2014/05/leetcode-group-shifted-strings-java/
https://www.geeksforgeeks.org/group-shifted-string/
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
 We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz".

Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence, return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]

关键在于长度和diff，统一的diff，用map保存，然后遍历打印即可

 */
public class GroupShiftedStrings {


    public static String getDiffString(String str)
    {
        String shift = "";
        for (int i = 1; i < str.length(); i++)
        {
            int dif = str.charAt(i) - str.charAt(i-1);
            if (dif < 0)
                dif += 26;

            // Representing the difference as char
            shift += (dif + 'a');
        }

        // This string will be 1 less length than str
        return shift;
    }

    // Method for grouping shifted string
    public static void groupShiftedString(String str[], int n)
    {
        // map for storing indices of string which are
        // in same group
        Map<String, List<Integer>> groupMap =  new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            String diffStr = getDiffString(str[i]);
            if (groupMap.containsKey(diffStr)) {
                groupMap.get(diffStr).add(i);
            } else {
               List<Integer> indexes = new ArrayList<>();
               indexes.add(i);
               groupMap.put(diffStr, indexes);
            }
        }

        // iterating through map to print group
        for (Map.Entry<String, List<Integer>> entry : groupMap.entrySet())
        {
            for (int i = 0; i < entry.getValue().size(); i++)
                System.out.print(str[entry.getValue().get(i)] + " ");
            System.out.println();
        }
    }

    // Driver method to test above methods
    public static void main(String[] args)
    {
        String str[] = {"acd", "dfg", "wyz", "yab", "mop",
                "bdfh", "a", "x", "moqs"
        };

        groupShiftedString(str, str.length);
    }
}
