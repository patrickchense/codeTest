package daily2019;

import java.util.ArrayList;
import java.util.List;

/*
Given a string and a set of delimiters, reverse the words in the string while maintaining the relative order of the delimiters.
For example, given "hello/world:here", return "here/world:hello"

Follow-up: Does your solution work for the following cases: "hello/world:here/", "hello//world:here"

@Facebook
@solved

 */
public class D20190126 {

    public static void main(String[] args) {
        System.out.println(reverseWords("hello/world:here"));
        System.out.println(reverseWords("hello/world:here/"));
        System.out.println(reverseWords("hello//world:here"));
    }

    // 直接写也不容易，要注意的好几个的地方
    /*
    1. 怎么处理多个delimiters连在一起
    2. 处理最后的字符串没有加入到sb中
    3.
     */
    public static String reverseWords(String str) {
        List<String> strs = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '/' || str.charAt(i) == ':') {
                if (j == i ) {
                    j = i + 1;
                    continue;
                }
                strs.add(str.substring(j, i));
                j = i + 1;
            }
        }
        if (j < str.length()) {
            strs.add(str.substring(j));
        }
        StringBuilder sb = new StringBuilder();
        j = strs.size();
        int last = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '/' || str.charAt(i) == ':') {
                if (i != 0 && i - 1 != last) {  // 关键用last判断是不是delimiters连续
                    j--;
                    sb.append(strs.get(j));

                }
                sb.append(str.charAt(i));
                last = i;
            }
        }
        if (j > 0) {  //处理可能剩下的一个
            sb.append(strs.get(0));
        }
        return sb.toString();
    }


    // 用额外空间就很好搞定了String split，不用怎么处理？
    public static String reverseDelimiters(String str) {
        char[] cs = str.toCharArray();
        int j = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '/' || cs[i] == ':') {
                reverse(cs, j, i-1);
                j = i + 1;
            }
        }
        reverse(cs, j, cs.length - 1);
        System.out.println(new String(cs));
        // olleh/dlrow:ereh
        // here:world/hello
        //
        reverse(cs, 0, cs.length - 1); //这里有问题，因为标号不同，不能替换了，必须想其他办法

        return new String(cs);
    }

    public static void reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}
