package daily2019;

/*
Given a string and a set of delimiters, reverse the words in the string while maintaining the relative order of the delimiters.
For example, given "hello/world:here", return "here/world:hello"

Follow-up: Does your solution work for the following cases: "hello/world:here/", "hello//world:here"

@Facebook
 */
public class D20190126 {

    public static void main(String[] args) {
        System.out.println(reverseDelimiters("hello/world:here"));
        System.out.println(reverseDelimiters("hello/world:here/"));
        System.out.println(reverseDelimiters("hello//world:here"));
    }

    // 用额外空间就很好搞定了List，不用怎么处理？
    public static String reverseDelimiters(String str) {
        char[] arr = new char[str.length()];
        int i = 0;
        int j = str.length() -1;
        int k = 0;
        int begin =0;
        int end =j;
        while (i < j) {
            while (str.charAt(i) != '/' && str.charAt(i) != ':') i++;
            while (str.charAt(j) != '/' && str.charAt(j) != ':') j--;

        }
    }
}
