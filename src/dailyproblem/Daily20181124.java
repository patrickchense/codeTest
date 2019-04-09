package dailyproblem;

import util.ArrayUtil;

import java.util.Arrays;
import java.util.Random;

/*
Given a function that generates perfectly random numbers between 1 and k (inclusive), where k is an input, write a function that shuffles a deck of cards represented as an array using only swaps.

It should run in O(N) time.

Hint: Make sure each one of the 52! permutations of the deck is equally likely.

@Facebook
@review
@answered
@random

第一次做这种random题，没经验
https://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-space


这题应该相似，还是利用了Random类
https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/

Let the given array be arr[]. A simple solution is to create an auxiliary array temp[] which is initially a copy of arr[]. Randomly select an element from temp[],
 copy the randomly selected element to arr[0] and remove the selected element from temp[]. Repeat the same process n times and keep copying elements
  to arr[1], arr[2], … . The time complexity of this solution will be O(n^2).

Fisher–Yates shuffle Algorithm works in O(n) time complexity. The assumption here is, we are given a function rand() that generates random number in O(1) time.
The idea is to start from the last element, swap it with a randomly selected element from the whole array (including last). Now consider the array from 0 to n-2 (size reduced by 1), and repeat the process till we hit the first element.

Following is the detailed algorithm

To shuffle an array a of n elements (indices 0..n-1):
  for i from n - 1 downto 1 do
       j = random integer with 0 <= j <= i
       exchange a[j] and a[i]

 */
public class Daily20181124 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(randomize(new Integer[]{1,2,3,4,5,6,7,8,9,10}, 10)));
        System.out.println(Arrays.toString(randomize(new Integer[]{1,2,3,4,5,6,7,8,9,10}, 10)));
    }

    public static Integer[] randomize(Integer[] arr, int k) {
        Random r = new Random();
        for (int i = k - 1; i >0; i--) {
            int j =  r.nextInt(i+1);

            ArrayUtil.swap(arr, i, j);
        }
        return arr;
    }

}
