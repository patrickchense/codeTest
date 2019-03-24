package daily2019;

import java.util.Arrays;

/*
Given a pivot x, and a list lst, partition the list into three parts.

The first part contains all elements in lst that are less than x
The second part contains all elements in lst that are equal to x
The third part contains all elements in lst that are larger than x
Ordering within a part can be arbitrary.

For example, given x = 10 and lst = [9, 12, 3, 5, 14, 10, 10], one partition may be `[9, 3, 5, 10, 10, 12, 14].

@Amazon

半quicksort
@sort
@quicksort
@solved
@review

https://www.geeksforgeeks.org/partitioning-a-linked-list-around-a-given-value-and-keeping-the-original-order/ 结构是Linkedlist怎么做?
https://www.programcreek.com/2013/02/leetcode-partition-list-java/
https://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/ 不是pivot,是一个range
https://stackoverflow.com/questions/54859356/optimizing-quicksort-when-there-are-lots-of-duplicate-in-the-array 优化quicksort，很多duplicate的时候， dutch national flag问题


 */
public class D20190224 {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 12, 3, 5, 14, 10, 10};
        halfQuickSort(arr, 10);
        System.out.println(Arrays.toString(arr));
    }

    public static void halfQuickSort(int[] arr, int pivot) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pivot) {
                index = i;
                break;
            }
        }
        int i = 0;
        int j = arr.length-1;
        while(i < index && j > index) {
            while(arr[i] < pivot) i++;
            while(arr[j] > pivot) j--;
            // 等于的处理是难点, 在碰到相等的时候，左边的往index+1swap,右边的往index-1swap，保证index+1,或者index--，这样移动了index，那么i,j不会受到影响
            if (arr[i] == pivot) {
                //swap i, index+1;
                swap(arr, i, index+1);
                index++;
                continue;
            }
            if (arr[j] == pivot) {
                swap(arr, j, index-1);
                index--;
                continue;
            }
            swap(arr, i, j);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
