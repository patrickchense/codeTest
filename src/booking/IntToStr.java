package booking;

public class IntToStr {

    static int getlength(int x){
        int length = 0;
        while(x/10 != 0) {
            length++;
            x /= 10;
        }
        return length+1;
    }

    static String convert(int x){
        char[] x_char = new char[getlength(x)];
        for(int i = x_char.length-1; i>=0; i--){
            x_char[i] = (char)(x % 10 + 48); //ASCII VALUE;
            x = x / 10;
        }
        return new String(x_char);
    }

    public static void main(String[] args) {
        System.out.println(convert(1234));
    }

}
