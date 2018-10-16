package GoldmanSachs;

/*
https://www.geeksforgeeks.org/goldman-sachs-interview-experience-set-35-experienced/  questions 3

Write a program to count frequency of each number in an array of elements without using a hash table.

I gave O(n) complexity solution, but the interviewer was not satisfied with it and asked me to implement a balanced binary search tree which I couldn’t.

 */
public class CountFrequency {

    /*
    sorted?
     */
    // Function to find counts of all elements present in
    // arr[0..n-1]. The array elements must be range from
    // 1 to n
    void findCounts(int arr[], int n) {
        // Traverse all array elements
        int i = 0;
        while (i < n) {
            // If this element is already processed,
            // then nothing to do
            if (arr[i] <= 0) {
                i++;
                continue;
            }

            // Find index corresponding to this element
            // For example, index for 5 is 4
            int elementIndex = arr[i] - 1;

            // If the elementIndex has an element that is not
            // processed yet, then first store that element
            // to arr[i] so that we don't loose anything.
            if (arr[elementIndex] > 0) {
                arr[i] = arr[elementIndex];

                // After storing arr[elementIndex], change it
                // to store initial count of 'arr[i]'
                arr[elementIndex] = -1;
            } else {
                // If this is NOT first occurrence of arr[i],
                // then increment its count.
                arr[elementIndex]--;

                // And initialize arr[i] as 0 means the element
                // 'i+1' is not seen so far
                arr[i] = 0;
                i++;
            }
        }

        System.out.println("Below are counts of all elements");
        for (int j = 0; j < n; j++)
            System.out.println(j + 1 + "->" + Math.abs(arr[j]));
    }


    // Function to find counts of all elements present in
    // arr[0..n-1]. The array elements must be range from
    // 1 to n
    /*
    1)  Subtract 1 from every element so that the elements
    become in range from 0 to n-1
    for (int j =0; j < n; j++)
        arr[j] = arr[j]-1;

2)  Use every element arr[i] as index and add 'n' to
    element present at arr[i]%n to keep track of count of
    occurrences of arr[i]
    for (int i=0; i < n; i++)
        arr[arr[i]%n] = arr[arr[i]%n] + n;

3)  To print counts, simply print the number of times n
    was added at index corresponding to every element
    for (int i =0; i < n; i++)
        print "(i + 1) -> arr[i] "
     */
    void printfrequency(int arr[], int n) {
        // Subtract 1 from every element so that the elements
        // become in range from 0 to n-1
        for (int j = 0; j < n; j++)
            arr[j] = arr[j] - 1;

        // Use every element arr[i] as index and add 'n' to
        // element present at arr[i]%n to keep track of count of
        // occurrences of arr[i]
        for (int i = 0; i < n; i++)
            arr[arr[i] % n] = arr[arr[i] % n] + n;

        // To print counts, simply print the number of times n
        // was added at index corresponding to every element
        for (int i = 0; i < n; i++)
            System.out.println(i + 1 + "->" + arr[i] / n);
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        CountFrequency count = new CountFrequency();
        int arr[] = {2, 3, 3, 2, 5};
        count.findCounts(arr, arr.length);

        int arr1[] = {1};
        count.findCounts(arr1, arr1.length);

        int arr3[] = {4, 4, 4, 4};
        count.findCounts(arr3, arr3.length);

        int arr2[] = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1};
        count.findCounts(arr2, arr2.length);

        int arr4[] = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        count.findCounts(arr4, arr4.length);

        int arr5[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        count.findCounts(arr5, arr5.length);

        int arr6[] = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        count.findCounts(arr6, arr6.length);
    }
}
