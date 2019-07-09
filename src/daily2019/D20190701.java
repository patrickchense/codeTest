package daily2019;

/*
Given a sorted list of integers of length N, determine if an element x is in the list without performing any multiplication, division, or bit-shift operations.

Do this in O(log N) time.

@hard
@Netflix
@solved
@binarysearch
 */
public class D20190701 {

    public static void main(String[] args) {
        System.out.println(findX(new int[]{1,3,6,10,20}, 0, 4, 15));
        System.out.println(findX(new int[]{1,3,6,10,20}, 0, 4, 3));
        System.out.println(findX(new int[]{1,3,6,10,20}, 0, 4, 8));
    }

    public static boolean findX(int[] arr, int i, int j, int x) {
        if (i > j) return false;
        if (i == j && arr[i] != x) return false;
        if (arr[i] == x || arr[j] == x) return true;
        int index = i + (int)Math.floor(Math.sqrt(j - i));
        System.out.println("i=" + i + ",j=" + j + ",index=" + index);
        if (arr[index] == x) return true;
        else if (arr[index] > x) return findX(arr, i, index-1, x);
        else return findX(arr, index+1, j, x);
    }
}
