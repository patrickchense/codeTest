package daily2019;

/*
Given an array of numbers and an index i, return the index of the nearest larger number of the number at index i, where distance is measured in array indices.

For example, given [4, 1, 3, 5, 6] and index 0, you should return 3.

If two distances to larger numbers are the equal, then return any one of them. If the array at i doesn't have a nearest larger integer, then return null.

Follow-up: If you can preprocess the array, can you do this in constant time?

@Google
@solved
 */
public class D20190225 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 3, 5, 6};
        System.out.println(nearestLargerDistance(0, arr));
        System.out.println(nearestLargerDistance(1, arr));
        System.out.println(nearestLargerDistance(2, arr));
        System.out.println(nearestLargerDistance(3, arr));
        System.out.println(nearestLargerDistance(4, arr));
    }

    // O(n)
    public static Integer nearestLargerDistance(int original, int[] arr) {
        int n = arr[original];
        int nearIndex = Integer.MAX_VALUE;
        for(int i = original+1; i < arr.length; i++) {
            if (arr[i] > n) {
                nearIndex = i - original;
                break;
            }
        }
        int nearIndexLeft = Integer.MAX_VALUE;
        for (int i = original -1; i >= 0; i--) {
            if (arr[i] > n) {
                nearIndexLeft = original -i;
                break;
            }
        }
        if (nearIndex == Integer.MAX_VALUE && nearIndexLeft == Integer.MAX_VALUE) return null;
        return Math.min(nearIndex, nearIndexLeft);
    }

    // how O(1) ? sorted? always return 1
    // hashmap?
}
