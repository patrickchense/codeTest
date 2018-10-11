package GoldmanSachs;
/*
as class name

think: use Character.digit(char c, int radix), need to check radix, need to check -/+
    need to check if int range

 */
public class ParseInt {

    public static void main(String args[]) {
        System.out.println(parseInt("22"));
        System.out.println(parseInt("-22"));
    }

    /*
    use 10 radix default
     */
    public static int parseInt(String n) {
        if (n == null || n.equals("")) return -1;
        int result = 0;
        int i = 0, len = n.length();
        boolean isNegative = false;
        if (len > 0) {
            char firstCharacter = n.charAt(0);
            if (firstCharacter < '0') {
                // not number maybe + -
                if (firstCharacter == '-') isNegative = true;
                i++;
            }
            while (i < len) {
                int digit = Character.digit(n.charAt(i++), 10);
                // check result with limit
                result *= 10;
                result += digit;

            }
        }
        return isNegative ? -result : result;
    }
}
