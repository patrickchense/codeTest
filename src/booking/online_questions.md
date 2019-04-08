1. 2- (Coding test at hackerrank) You have a list of words and  a list of hotel reviews, try to sort the hotels based on the number of words from the first list that is exist in the each review. if an hotel has maximum number of 4 words then it should be the highest in the sorting
Given a string of parentheses, check if the parentheses are balanced. Then the question was extended to all types of brackets
这个都可以通过Daily20181031, D20190223解决   

2. What a fibonacci function which return N th position number both in recursive and loop, also give the explanation on both implementation on their time efficiency

3. What is HashMap ? Give the comparison on HashMap and TreeMap, that is the efficiency on their intersection and traverse.  

4. input interger 1234, return "1234" in string or characters 

5. Find Nth nearest neighbours in a graph.

6. shift an array to the right by n positions such that the right most indexes are become the first ones and the first ones move ahead.
   like:
   1 2 3 4 5 --> shift by 2 --> 4 5 1 2 3
   这里有两种，一种是Linkedlist, 一种是array
   array在这里，D20190207， 两种方式，一种是利用额外空间, O(n), O(n), 还有一种是reverse，3次即可(O(2n) -> O(n))
7. Union of n arrays with x elements. Output common members contained in at least 2 arrays. Explain the complexity of the algorithm used
8. Given any number of arrays containing numbers, write a function which
   finds the numbers that appear in exactly two arrays.
   
   arrays = [
       [6, 2, 2, 0, 4],
       [5, 0, 2, 6, 7, 1],
       [6, 7, 9, 9],
   ]
   find_in_two(arrays) should return [2, 0, 7]  
9. Find how many moves it takes from point A in a maze to point B.  
10. Finding the knights tour on a chess board ?  
11. Can be solved by using sliding window technique or tries.  
12. Stack implementation
13. Given an array of words as NSStrings you should return another array of NSStrings, each containing words that are mutual anagrams  
14. Count number of islands in a matrix.  
15. the longest sequence in array (a,a+1,a+2,...)
16. Given a string of characters, find the maximum substring with no repetitions.

[careercup with bookings](https://careercup.appspot.com/page?pid=bookingcom-interview-questions&sort=date)
17. Given a file containing n words.Given a word w and a number k.Find k words in the file occuring before occurence of w.Assume that the average word size is m in the file 
    eg. 
    aaa 
    bbb 
    ccc 
    booking 
    alpha 
    beta 
    gamma 
    
    for k=3 and w = booking 
    the output should be [aaa,bbb,ccc,booking] 
    similarly for k =2 and w = beta 
    output should be [booking,alpha,beta] 
    Assume that the file size can grow very large 
    and try to get solution with space complexity lesser than O(n) 
    
    I suggested solution for iterating through file until the word w is found and maintaiining a queue of size K 
    The time complexity of my solution was O(nm) 
    and space complexity was O(k) .Any answers to improve the time and space complexity 
    Apparently they were looking for a better implementation of grep
    很简单啊，queue，直接remove, 当arr[i] != w的时候，queue size == k, add, linkedlist就能支持, remove/add 都是O(1)
18. Given arrays for N (>= 2) users, each representing the IDs of hotels visited, find the common IDs of the hotels visited amongst the users. 
    Input: 
    userA = { 2, 3, 1 } 
    userB = { 2, 5, 3 } 
    userC = { 7, 3, 1 } 
    Output: 
    {3} 
    Assumptions: 
    Arrays are unsorted. 
    Cases: 
    1) Each array consists of distinct hotel IDs 
    2) Each array may contain duplicate hotel IDs
    
    我的想法，简单就是hashMap, 但是如果是sorted的话，不用这么复杂，如果不用space, 可以sort,O(3nlogn)，然后判断
    https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/   

19. Given a set of hotels and its guests reviews, sort the hotels based on a list of words specified by a user. 
The criteria to sort the hotels should be how many times the words specified by the user is mentioned in the hotel reviews. 
    Input 
    The first line contains a space-separated set of words which we want to find mentions in the hotel reviews. 
    The second line contains one integer M, which is the number of reviews. 
    This is followed by M+M lines, which alternates an hotel ID and a review belonging to that hotel. 
    
    Output 
    A list of hotel IDs sorted, in descending order, by how many mentions they have of the words specified in the input. If the count is same, sort according to the hotel IDs.
    用Map保存次数，总是个解决办法，O(2m * w) 空间, O(m) 时间
20. Consider a hotel where the guest is checked in and check out. Find a day when the maximum number of guests stay in a hotel. 
    example: 
    Input : 
    [ 
    {check-in : 1, check-out 4}, 
    {check-in : 2, check-out 5}, 
    {check-in : 10, check-out 12}, 
    {check-in : 5, check-out 9}, 
    {check-in : 5, check-out 12} 
    ] 
    Output : 5
    跟 bus/rail station题类似，但是我感觉题目有点问题，我找找 bus/rail station
    https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/ dp问题，的确排序能解决
21. Given number N, Find the least number of perfect square number sum needed to get N. 
    Example : 
    n=5 (4+1) i.e. 2 
    n=7 (4+1+1+1) i.e. 4 
    n=12 (4+4+4) i.e 3 
    n=20 (16+4) i.e. 2
    math的问题，找到square sum = target， D20190309 就是这个问题, 
22. Given a stream of characters (e.g. acacabcatghhellomvnsdb) and a list of words (e.g. ["aca","cat","hello","world"] ) 
    find and display count of each and every word once the stream ends.(Like : "aca" : 2 , "cat" : 1 , "hello" : 1 , "world" : 0 ).
    map统计，Trie树？？

23. You are building a small command-line application to calculate hotel availability for a city. Your application reads in two (2) data files, and outputs its answer to STDOUT. 
    Your application will read in: 
    · a list of hotels along with how many rooms each contains (in no particular order) 
    · a list of bookings that have been made (in no particular order) 
    Your application will then print the list of all hotels which have availability for check-in and check- out date range, if any. 
    Do not worry about whether a specific room is available in a hotel for the entire booking period without switching rooms: availability is defined as the hotel having at least one (1) available room for each night of the target stay, regardless of whether it's the same room from day to day. 
    Data Files 
    hotels.csv 
     Name, Rooms 
    Westin, 10 
    Best Western, 20 
    Hilton, 10 
    ... 
    
    bookings.csv 
     Name, Checkin, Checkout 
    Hilton, 2015-04-02, 2015-04-03 
    Hilton, 2015-04-02, 2015-04-04 
    Westin, 2015-05-01, 2015-05-20
    
24. There's a very simple compression algorithm that takes subsequent characters and just emits how often they were seen. 
    Example: 
    abababaabbbaaaaa
    变成1a1b1a1b1a1b2a3b5a,  就是比较前面，一致i++,不一致，把i+char append到sb, 然后i=1
25. $a = [3, 1, 4, 5, 19, 6];
    $b = [14, 9, 22, 36, 8, 0, 64, 25];
     Some elements in the second array are squares. 
     Print elements that have a square root existing in the first array. 
     $b[1] = 9, it’s square root is 3 ($a[0]) 
     $b[3] = 36, it’s square root is 6 ($a[5]) 
     $b[7] = 25, it’s square root is 5 ($a[3]) 
     Result: 
     9 
     36 
     25
    sort, 然后比较O(nlogn)

26. A multiset or a bag is a collection of elements that can be repeated. Contrast with a set, where elements cannot be repeated. 
    Multisets can be intersected just like sets can be intersected. 
    Input : 
    A = [0,1,1,2,2,5] 
    B = [0,1,2,2,2,6] 
    Output : 
    A ∩ B = C = [0,1,2,2] 
    Input : 
    A = [0,1,1] 
    B = [0,1,2,3,4,5,6] 
    Output 
    A ∩ B = C = [0,1] 
    Write a function to find the intersection of two integer arrays in that way?
    就是与，简单 A[i] XOR B[i] == 0 

27. "Smart substring" 
    Write a function that takes maximum 30 characters from a string but without cutting the words. 
    Full description: 
    "Featuring stylish rooms and moorings for recreation boats, Room Mate Aitana is a designer hotel built in 2013 on an island in the IJ River in Amsterdam." 
    First 30 characters: 
    "Featuring stylish rooms and mo" 
    Smarter approach (max 30 characters, no words are broken): 
    "Featuring stylish rooms and"

28. How do you remove repeated values from a INT array, returning the resultant array in the same order as original ?
    using set is the simplest. sorted ? or not sorted ?
    sorted O(n) O(1) solutions, https://www.geeksforgeeks.org/remove-duplicates-sorted-array/  
    unsorted, https://www.geeksforgeeks.org/remove-duplicates-from-unsorted-array/ , using map




