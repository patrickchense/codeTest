package daily2019;

/*
Spreadsheets often use this alphabetical encoding for its columns: "A", "B", "C", ..., "AA", "AB", ..., "ZZ", "AAA", "AAB", ....

Given a column number, return its alphabetical column id. For example, given 1, return "A". Given 27, return "AA".

@Dropbox

@easy

@solved

@5min
 */
public class D20190503 {
    public static void main(String[] args) {
        System.out.println(columId(27));
        System.out.println(columId(10));
        System.out.println(columId(150));
    }


    public static String columId(int a){
        StringBuilder sb = new StringBuilder();
        while (a > 0) {
            int t = a % 26;
            char c = (char) ('A' + t -1);
            sb.append(c);
            a /= 26;
        }
        return sb.reverse().toString();
    }
}
