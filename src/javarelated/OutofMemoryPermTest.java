package javarelated;

import java.util.ArrayList;
import java.util.List;

public class OutofMemoryPermTest {
    static String  base = "string";
    /*

    objc[6361]: Class JavaLaunchHelper is implemented in both /Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/bin/java (0x10242d4c0) and /Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/libinstrument.dylib (0x1024b14e0). One of the two will be used. Which one is undefined.
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3332)
	at java.lang.AbstractStringBuilder.expandCapacity(AbstractStringBuilder.java:137)
	at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:121)
	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:421)
	at java.lang.StringBuilder.append(StringBuilder.java:136)
	at javarelated.OutofMemoryPermTest.main(OutofMemoryPermTest.java:11)


     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i=0;i< Integer.MAX_VALUE;i++){
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
    }


}
