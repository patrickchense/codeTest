package leetcode.str;

/*
leetcode 556
https://leetcode.com/problems/next-greater-element-iii/submissions/1

Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

Example 1:

Input: 12
Output: 21


Example 2:

Input: 21
Output: -1
 */
public class NextGreaterElement {

    public int nextGreaterElement(int n) {
        if (n == Integer.MAX_VALUE || n < 10) return -1;
        String max = String.valueOf(Integer.MAX_VALUE);

        String next = String.valueOf(n);
        char[] chars = next.toCharArray();
        int len = next.length();
        boolean found = false;
        int[] freq = new int['9' + 1];

        for (int i = len - 1; !found && i >= 1; i--) {
            char c = chars[i];
            freq[c]++;

            if (chars[i] > chars[i - 1]) {
                found = true;
                freq[chars[i - 1]]++;
                char min = c;
                for (int j = i + 1; j < len; j++)
                    if (chars[j] > chars[i - 1]) min = chars[j];
                    else break;
                chars[i - 1] = min;
                freq[min]--;

                for (char j = '0'; j <= '9'; j++)
                    for (int k = 1; i < len && k <= freq[j]; k++)
                        chars[i++] = j;

                next = new String(chars);
            }
        }

        if (!found || (len == max.length() && next.compareTo(max) > 0)) return -1;
        return Integer.parseInt(next);
    }

    /*
   Intuition comes from writing down examples (examples that need a lot of swaps to get to the smallest higher number).
1.Starting from the right going to the left, we want to find the first idx where character at idx < character at idx+1.
In the example: 1 5 8 4 7 6 5 3 1, idx would be at 4 since 4 < 7

2.Now we need to swap 4 with the smallest greater than number to the right of it because this would increase the number the smallest amount. Any number smaller would decrease the number, and any number greater would increase it by more. We know the elements to the right of 4 are in decreasing order since we already checked for that.
We find increment a right pointer (i) until the digit at i is less than the digit at idx. So in this case 4 > 3 then we backtrack 1 since we need the last found greater element. So we get 4 and 5.
We swap 4 and 5 to get 1 5 8 5 7 6 4 3 1.

3.The numbers to the right of 5 (still the idx pointer) are all in decreasing order since we basically inserted the 4. To get the smallest number we need to make them in increasing order, which means we reverse the positions to the right of the 5.
Finally we get 1 5 8 5 1 3 4 6 7.
Leetcode has some edge cases:

Sometimes when swapping a number the number can turn over the maximum value of an int making integer.parse give an error. Leetcode expects this to count as a -1, so we need a try catch.
In step 2 if the number isnt found, then after all the swapping the result will be equal to the start number so return -1 since it's impossible to make bigger
     */
    public int nextGreaterElement2(int n) {
        StringBuilder sb = new StringBuilder(Integer.toString(n));
        int idx = sb.length()-1;
        for(int i=sb.length()-1;i>=1;--i){
            idx=i-1;
            if(sb.charAt(i-1)<sb.charAt(i))
            {
                break;
            }
        }
        int i=idx+1;
        while(i<sb.length()&& sb.charAt(i)>sb.charAt(idx)){
            ++i;
        }
        --i;
        //never found a value that is decreasing
        if(sb.charAt(idx)>=sb.charAt(i)){
            return -1;
        }
        swap(sb,idx,i);
        ++idx;
        i=sb.length()-1;
        while(idx<i){
            swap(sb,idx,i);
            ++idx;
            --i;
        }
        int res= -1;
        try{
            res = Integer.parseInt(sb.toString());
        }catch(Exception e){
            return -1;
        }
        return res;
    }
    private void swap(StringBuilder sb,int i, int j){
        char temp = sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,temp);
    }
}
