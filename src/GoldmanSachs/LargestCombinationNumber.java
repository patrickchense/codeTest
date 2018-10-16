package GoldmanSachs;

import java.util.*;

/*
https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/

Given an array of numbers, arrange them in a way that yields the largest value. For example,
if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value.
And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.

 */
public class LargestCombinationNumber {

    // define string sort
    static void printLargest(List<String> arr){

        // A comparison function which is used by
// sort() in printLargest()
        Collections.sort(arr, (X, Y) -> {

            // first append Y at the end of X
            String XY=X + Y;

            // then append X at the end of Y
            String YX=Y + X;

            // Now see which of the two formed numbers
            // is greater
            return XY.compareTo(YX) > 0 ? -1:1;
        });

        Iterator it = arr.iterator();

        while(it.hasNext())
            System.out.print(it.next());

    }

    // driver program
    public static void main (String[] args) {

        List<String> arr;
        arr = new ArrayList<>();

        //output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargest(arr);

        // output should be 777776
        /* arr.add("7");
        arr.add("776");
        arr.add("7");
        arr.add("7");
        */

        //output should be 998764543431
        /*arr.add("1");
        arr.add("34");
        arr.add("3");
        arr.add("98");
        arr.add("9");
        arr.add("76");
        arr.add("45");
        arr.add("4");
        */
    }
}
