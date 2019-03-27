package daily2019;

/*
Given a string of words delimited by spaces, reverse the words in string. For example, given "hello world here", return "here world hello"

Follow-up: given a mutable string representation, can you perform this operation in-place?

@Google
@string
@reverse
@answered
@review

跟0126是一个题目
https://www.geeksforgeeks.org/reverse-words-given-string-java/

 */
public class D20190125 {

    public static void main(String[] args) {
        System.out.println(reverseWords("hello world here"));
    }


    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                sb.insert(0, words[i]);
            }
            else {
                sb.insert(0, " ");
                sb.insert(1, words[i]);
            }
        }
        return sb.toString();
    }

    //in place?? 怎么做？ https://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/
    /*
    其实很简单的逻辑，
    先reverse每个单词， hello world here -> olleh dlrow ereh
    在reverse整个字符串, olleh dlrow ereh -> here world hello

     */
    public static void reverseWords(char[] s) {
        int i=0;
        for(int j=0; j<s.length; j++){
            if(s[j]==' '){
                reverse(s, i, j-1);
                i=j+1;
            }
        }

        reverse(s, i, s.length-1);

        reverse(s, 0, s.length-1);
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
