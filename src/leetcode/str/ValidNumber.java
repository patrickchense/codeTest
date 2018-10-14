package leetcode.str;

/*
leetcode 65
Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
Of course, the context of these characters also matters in the input.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.


solution on line:
https://segmentfault.com/a/1190000010018231

 */
public class ValidNumber {

    /*
        split number ->
            contain  e, split two parts,  first part is integer/double , second is integer
            double
            int
     */
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.contains("e")){
            String firstPart = s.substring(0, s.indexOf("e"));
            String secondPart = s.indexOf("e")+1 >= s.length() ? "" : s.substring(s.indexOf("e")+1);
            return (isInteger(firstPart) || isDouble(firstPart)) && isInteger(secondPart);
        }else if(s.contains(".")){
            return isDouble(s);
        }else{
            return isInteger(s);
        }

    }

    public boolean isDouble(String s){
        if(s.startsWith("-") || s.startsWith("+")){
            s = s.substring(1);
        }
        if(s.length() <= 1){
            return false;
        }
        return s.matches("^([0-9]*)?+\\.([0-9]*)$");
    }

    public boolean isInteger(String s){
        return s.matches("^(-|\\+)?([0-9]{1,})$");
    }

    /*
        one regex to represent all
     */
    public boolean isNumber2(String s){
        return s.matches("^ *[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))(e[+-]?[0-9]+)? *$");
    }

    /**
     * 利用规则总结，来字符判断，效率更高
     * We start with trimming.
     * If we see [0-9] we reset the number flags.
     * We can only see . if we didn't see e or ..
     * We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
     * We can only see + and - in the beginning and after an e
     * any other character break the validation.
     * At the end it is only valid if there was at least 1 number and if we did see an e then a number after it as well.
     * So basically the number should match this regular expression:
     * [-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
     *
     *翻译：
     *如果我们看到数字，就将numberFlag设为true
     *如果看到小数点，则判断是否已有小数点或是e，因为e后只能有整数
     *e只能遇到一次，如果第一次遇到e但是没有遇到数字，则返回错误。遇到第一个e后，将numberAfterE flag标注为否以便判断后序是否有数字
     *正负号的位置只能位于最开始和e紧邻着右边那个位置
     */
    public boolean isNumber3(String s){
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for(int i=0; i<s.length(); i++) {
            //当前值为数字
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
                //遇到小数点
            } else if(s.charAt(i) == '.') {
                //已经遇到小数点或是e，则出错
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
                //遇到e
            } else if(s.charAt(i) == 'e') {
                //已经遇到e或是尚未遇到数字
                if(eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
                //遇到正负号，只能在首位或是e后面
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
                //遇到其它符号一定是错的
            } else {
                return false;
            }
        }
        //是否遇到小数点或是e均不重要
        return numberSeen && numberAfterE;
    }
}
