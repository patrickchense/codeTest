package leetcode.locked;

/*
leetcode 157
https://cheonhyangzhang.wordpress.com/2016/12/22/157-leetcode-java-read-n-characters-given-read4-easy/

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.

很简单的方法，关键是理解题意，在于从利用read4方法，然后char复制


 */
public class ReadN {

    public int read4(char[] buf) {return 0;}

    public int read(char[] buf, int n) {
        int offset = 0;
        char[] buf4 = new char[4];
        while (true) {
            int count = read4(buf4);
            if (count == 0) {
                break;
            }
            for (int i = 0; i < count && offset < n; i++) {
                buf[offset] = buf4[i];
                offset++;
            }
        }
        return offset;
    }
}
