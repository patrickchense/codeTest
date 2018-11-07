package dailyproblem;

/*
The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other.
 For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.

Given two strings, compute the edit distance between them.
@google

https://www.geeksforgeeks.org/check-if-two-given-strings-are-at-edit-distance-one/
https://www.geeksforgeeks.org/edit-distance-dp-5/

 */
public class Daily20181104 {
    static int min(int x, int y, int z) {
        if (x <= y && x <= z) {
            return x;
        }
        if (y <= x && y <= z) {
            return y;
        }
        else {
            return z;
        }
    }

    static int editDist(String str1, String str2, int m, int n) {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) {
            return n;
        }

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) {
            return m;
        }

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return editDist(str1, str2, m - 1, n - 1);
        }

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min(editDist(str1, str2, m, n - 1),    // Insert
                editDist(str1, str2, m - 1, n),   // Remove
                editDist(str1, str2, m - 1, n - 1) // Replace
        );
    }

    public static void main(String args[]) {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println(editDist(str1, str2, str1.length(), str2.length()));
        System.out.println(editDist("kitten", "sitting", "kitten".length(), "sitting".length()));


    }
}
