package daily2019;

/*
Given a list of elements, find the majority element, which appears more than half the time (> floor(len(lst) / 2.0)).

You can assume that such element exists.

For example, given [1, 2, 1, 1, 3, 4, 0], return 1.

@Mongodb
@answered

https://www.geeksforgeeks.org/majority-element/
https://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/

 */
public class D20190308 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 1, 3, 4, 1, 1, 0};
        System.out.println(majorityElem(arr));
    }

    // 自己写不出
    // O(n) O(1)
    public static int majorityElem(int[] arr) {
        int m_i = 0;
        int m = arr[0];
        int c = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == m) c++;
            else {
                c--;
                if (c == 0) {
                    m_i = i;
                    m = arr[i];
                    c = 1;
                }
            }
        }
        return m;
    }

    /*
    真正的逻辑
NOTE : This Method only works when we are given that majority element do exist in the array ,
 otherwise this method won’t work , as in the problem definition we said that majority element may or may not exist but for
  applying this approach you can assume that majority element do exist in the given input array

The first step gives the element that may be majority element in the array. If there is a majority element in an array,
then this step will definitely return majority element, otherwise it will return candidate for majority element.
Check if the element obtained from above step is majority element.This step is necessary as we are not always sure that
element return by first step is majority element.


Let the array be A[] = 2, 2, 3, 5, 2, 2, 6
    Initialize maj_index = 0, count = 1
Next element is 2, which is same as a[maj_index] => count = 2
Next element is 3, which is different from a[maj_index] => count = 1
Next element is 5, which is different from a[maj_index] => count = 0
Since count = 0, change candidate for majority element to 5 => maj_index = 3, count = 1
Next element is 2, which is different from a[maj_index] => count = 0
Since count = 0, change candidate for majority element to 2 => maj_index = 4
Next element is 2, which is same as a[maj_index] => count = 2
Next element is 6, which is different from a[maj_index] => count = 1
Finally candidate for majority element is 2.

     */

    static int findCandidate(int a[], int size)
    {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++)
        {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0)
            {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    /* Function to check if the candidate occurs more
       than n/2 times */
    static boolean isMajority(int a[], int size, int cand)
    {
        int i, count = 0;
        for (i = 0; i < size; i++)
        {
            if (a[i] == cand)
                count++;
        }
        if (count > size / 2)
            return true;
        else
            return false;
    }
}
