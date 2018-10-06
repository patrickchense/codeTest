import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Stream;

public class test {

    public static void main(String args[])
    {
        int x;
        x = -3 >> 1;
        System.out.println(x);
        x = x >>> 2;
        System.out.println(x);
        x = x << 1;
        System.out.println(x);

        String s1 = "abc";
        String s2 = "abc";
        if(s1 == s2)
            System.out.println(1);
        else
            System.out.println(2);
        if(s1.equals(s2))
            System.out.println(3);
        else
            System.out.println(4);
        System.out.println("==========");
        int i,j=0;
        for(i=10;i<0;i--) { j++; }
        System.out.println(j);
        switch(j) {
            case (0) :
                j=j+1;
            case(1):
                j=j+2;
                break;
            case (2) :
                j=j+3;
                break;
            case (10) :
                j=j+10;
                break;
            default :
                break;
        }
        System.out.println(j);


        String str1 = "My String";
        String str2 = new String ("My String");
        System.out.println(str1.matches(str2));

        System.out.println(Stream.of("green", "yellow", "blue")
                .max((s4,s5) -> s1.compareTo(s2))
                .filter(s -> s.endsWith("n"))
                .orElse("yellow"));
        File file = new File("Data.txt");

        try {
            FileWriter output = new FileWriter(file);
            output.write(new char[] {'0', '1', '2', '3', '4'});
            for (int iii = 0; iii < 5; iii++)
                output.write(String.valueOf(iii));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Integer b() {
        return 1;
    }

}
class MyCollection<T> {
    private Set<T> set;
    public Set<T> getCollection() {
        return this.set;
    }
}