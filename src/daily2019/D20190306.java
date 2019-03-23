package daily2019;

/*
Find an efficient algorithm to find the smallest distance (measured in number of words) between any two given words in a string.

For example, given words "hello", and "world" and a text content of "dog cat hello cat dog dog hello cat world",
return 1 because there's only one word "cat" in between the two words.

@solved
 */
public class D20190306 {
    public static void main(String[] args) {
        System.out.println(smallestDistanceWords("hello", "world", "dog cat hello cat dog dog hello cat world"));
        System.out.println(smallestDistanceWords("hello", "world", "dog cat hello cat dog dog hello cat world hello"));
        System.out.println(smallestDistanceWords("hello", "world", "dog cat world cat dog dog hello cat world d f hello"));
    }

    // 碰到str1, 记录，下次碰到str1, 则更新index，因为后面的不会更近
    // 碰到str2, 计算，然后保存，下次碰到str2, 记录index,
    // 碰到str1, 计算，比较如果小，替换，
    public static int smallestDistanceWords(String str1, String str2, String str) {
        int distance = Integer.MAX_VALUE;
        int str1_i = -1;
        int str2_i = -1;
        boolean str1_before = false;
        boolean str2_before = false;
        String strs[] = str.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(str1)) {
                if (str2_before) {
                    distance = Math.min(distance, i - str2_i);
                    str2_before = false;
                    str2_i = -1;
                }
                str1_i = i;
                str1_before = true;
            }
            else if (strs[i].equals(str2)) {
                if (str1_before) {
                    distance = Math.min(distance, i - str1_i);
                    str1_before = false;
                    str1_i = -1;
                }
                str2_i = i;
                str2_before = true;
            }
        }
        return distance -1;
    }
}
