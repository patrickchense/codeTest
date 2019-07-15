package daily2019;

/*
Create a basic sentence checker that takes in a stream of characters and determines whether they form valid sentences. If a sentence is valid, the program should print it out.

We can consider a sentence valid if it conforms to the following rules:

The sentence must start with a capital letter, followed by a lowercase letter or a space.
All other characters must be lowercase letters, separators (,,;,:) or terminal marks (.,?,!,‽).
There must be a single space between each word.
The sentence must end with a terminal mark immediately following a word.

@medium
@Nest

@solved
@10min
@logic

 */
public class D20190623 {

    public static void main(String[] args) {
        System.out.println(validSentences("%kdf kdf!"));
        System.out.println(validSentences("Dkdf kdf!"));
        System.out.println(validSentences("Dkdf kdf !"));
        System.out.println(validSentences("Dkdf kdf d"));
        System.out.println(validSentences("Dkdf kdffd"));
        System.out.println(validSentences("Dkdf kd  ffd"));
        System.out.println(validSentences("Dkdf ^5  ffd"));
        System.out.println(validSentences("Dkdf kf; ffd."));
    }

    public static String validSentences(String str) {
        char[] cs = str.toCharArray();
        if (!(cs[0] >= 'A' &&cs[0] <= 'Z')) {
            return null;
        }
        if (cs.length > 1 && !(cs[1] >= 'a' && cs[1] <= 'z') && cs[1] != ' ') {
            return null;
        }

        for (int i = 2; i < cs.length-2; i++) {
            if (cs[i] == ' ' && cs[i-1] == ' ') return null;
            if ( !(cs[i] >= 'a' &&cs[i] <= 'z') && cs[i] != ' ' && notSeparators(cs[i]) && notTerminalMarks(cs[i])) {
                return null;
            }
        }

        if (!(cs[cs.length - 2] >= 'a' && cs[cs.length - 2] <= 'z') || notTerminalMarks(cs[cs.length - 1])) {
            return null;
        }
        return str;
    }

    private static boolean notTerminalMarks(char c) {
        return c != '.' && c != '?' && c != '!';
    }

    private static boolean notSeparators(char c) {
        return c != ',' && c != ';' && c != ':';
    }
}
