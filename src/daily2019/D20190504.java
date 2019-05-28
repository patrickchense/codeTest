package daily2019;

import util.ArrayUtil;

import java.util.*;

/*
Given a string of digits, generate all possible valid IP address combinations.

IP addresses must follow the format A.B.C.D, where A, B, C, and D are numbers between 0 and 255. Zero-prefixed numbers, such as 01 and 065, are not allowed,
 except for 0 itself.

For example, given "2542540123", you should return ['254.25.40.123', '254.254.0.123'].

@Snapchat

@medium
@answered
@reviewed
https://www.geeksforgeeks.org/program-generate-possible-valid-ip-addresses-given-string/

纯暴力，没有其他方法？？
backtracking 解决
 */
public class D20190504 {

    public static void main(String[] args) {
        ArrayUtil.printList(allIp("2542540123"));
        ArrayUtil.printList(restoreIpAddresses("2542540123"));
    }

    // O(n^3 * 4)
    public static List<String> allIp(String str) {
        List<String> res = new ArrayList<>();
        int len = str.length();
        if (len > 12) return null;
        if (len < 4) return null;

        ArrayList<String> l =
                new ArrayList<>();

        String snew = str;

        for (int i = 1; i < len - 2;
             i++)
        {
            for (int j = i + 1;
                 j < len - 1; j++)
            {
                for (int k = j + 1;
                     k < len; k++)
                {
                    snew = snew.substring(0, k) +
                            "." + snew.substring(k);
                    snew = snew.substring(0, j) +
                            "." + snew.substring(j);
                    snew = snew.substring(0, i) +
                            "." + snew.substring(i);
                    System.out.println(snew);
                    if (isValid(snew))
                    {
                        l.add(snew);
                    }
                    snew = str;
                }
            }
        }
        System.out.println(l);
        Collections.sort(l, (o1, o2) -> {
            String a1[] = o1.split("[.]");
            String a2[] = o2.split("[.]");

            int result = -1;
            for (int i = 0; i < 4 &&
                    result != 0; i++)
            {
                result = a1[i].compareTo(a2[i]);
            }
            return result;
        });
        return l;
    }

    private static boolean isValid(String ip)
    {
        String a[] = ip.split("[.]");
        for (String s : a) {
            int i = Integer.parseInt(s);
            if (s.length() > 3 || i < 0 || i > 255)
            {
                return false;
            }
            if (s.length() > 1 && i == 0)
                return false;
            if (s.length() > 1 && i != 0 &&
                    s.charAt(0) == '0')
                return false;
        }

        return true;
    }

    // leet code 93 https://leetcode.com/problems/restore-ip-addresses/
    static List<String> all;

    public static List<String> restoreIpAddresses(String s) {
        all = new ArrayList<>();
        StringBuilder each = new StringBuilder();
        generator(each, s, 3, 0);
        return all;
    }

    public static void generator(StringBuilder each, String s, int numDots, int index) {
        // Invalid IP address
        if (s.substring(index, s.length()).length() > numDots*3+3) return;

        if (numDots == 0) {
            // Valid IP address found
            String buffer = s.substring(index,s.length());
            if (buffer.length() == 1 || buffer.length() > 1 && buffer.charAt(0) != '0' && Integer.parseInt(buffer) <= 255) {
                each.append(buffer);
                all.add(each.toString());
                each.delete(each.length()-buffer.length(),each.length()); // backtracking 的关键吧，是递归后删除
            }
            return;
        }

        String segment = "";
        for (int i=index; i<Math.min(index+3,s.length()); i++) {
            segment += s.charAt(i);
            if (segment.length() == 1 || segment.length() > 1 && segment.charAt(0) != '0' && Integer.parseInt(segment) <= 255) {
                String buffer = segment + ".";
                each.append(buffer);
                generator(each, s, --numDots, i+1);
                each.delete(each.length()-buffer.length(),each.length());// backtracking 的关键吧，是递归后删除
                numDots++;
            }
        }
    }
}
