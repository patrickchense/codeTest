package dailyproblem;

/*
Given an array of integers, write a function to determine whether the array could become non-decreasing by modifying at most 1 element.

For example, given the array [10, 5, 7], you should return true, since we can modify the 10 into a 1 to make the array non-decreasing.

Given the array [10, 5, 1], you should return false, since we can't modify any one element to get a non-decreasing array.

@solved
 */
public class Daily20181222 {

    public static void main(String[] args){
        System.out.println(isDecreasingAble(new int[]{10, 5, 7}));
        System.out.println(isDecreasingAble(new int[]{10, 5, 1}));
        System.out.println(isDecreasingAble(new int[]{10, 10, 1, 3}));
        System.out.println(isDecreasingAble(new int[]{5, 5, 9, 3}));
        System.out.println(isDecreasingAble(new int[]{5, 1, 5, 8}));
    }

    // ni, ni+1 ...  > nx  ,   i, i+1 < x  return false
    public static boolean isDecreasingAble(int[] arr) {
        if (arr.length < 3) return true;
        int min = arr[0] > arr[1] ? arr[1] : arr[0];
        int min2 = arr[0] > arr[1] ? arr[0] : arr[1];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < min && min2 >= min) return false;
            if (arr[i] < min) {
                min2 = min;
                min = arr[i];
            } else {
                if (arr[i] < min2) {
                    min2 = arr[i];
                }
            }

        }
        return true;
    }
}
