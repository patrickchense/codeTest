https://docs.google.com/document/d/18wM2MSKbbKonx4N82IvBU2m3oTHWp5xRi9b8uDok2U0/edit

##kth largest quick sort
###location
https://leetcode.com/problems/kth-largest-element-in-an-array/description/ 
###solution
关键在于快排的使用，pivot的找到，需要复习一下

##Reverser Pairs 类似问题总结
###location
https://leetcode.com/problems/reverse-pairs/description/ 
###solution
nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j]
https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-%22Reverse-Pairs%22 
####解法，BST, BIT, Merged-Sort, 
```$xslt
分治的关键在于breakdown array to subproblem
T(i,j) 就是这里的子问题，很明显解为T(0,n-1), 两种常规方法推导
T(i,j) = T(i,j-1) + C,  C在这里就是nums(i,j)
T(i,j) = T(i, m) + T(m+1, j) + C, m = (i+j)/2, 
```
https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-%22Reverse-Pairs%22 

##sort linkedlist in O(nlogn)  O(const) space
###location
https://leetcode.com/problems/sort-list/description/ 
###solution
关键在于转换linkedList，去适配merge sort,
```$xslt
1. 通过快慢指针，切分nodelist, 
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;  // cut nodes , great
2 merge sort 2个subnodelist
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

3 merge 
	ListNode l = new ListNode(0), p = l;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null) {
            p.next = l1;
            
        }
        if(l2 != null) {
            p.next = l2;
            
        }
merge 总是需要两个额外的指针，一个移动，一个指向头
```  




####特殊
一个数字，组合值最大，数字转字符串比较的例子
https://leetcode.com/problems/largest-number/description/ 
利用了一个特点，字符串比较数值
```java
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
                return s1.compareTo(s2);
            }
        });
```

##在链表上实现插入排序
###location
https://leetcode.com/problems/insertion-sort-list/description/ 
###solution
插入的算法，遍历每个元素，插入到之前合适的位置( a[i] < a[cur] < a[j])



##hard  单词缩写, 
###location
http://bookshadow.com/weblog/2017/03/12/leetcode-word-abbreviation/
###question
```
Given an array of n distinct non-empty strings, you need to generate minimal possible abbreviations for every word following rules below.
Begin with the first character and then the number of characters abbreviated, which followed by the last character.
If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used instead of only the first character until making the map from word to abbreviation become unique. In other words, a final abbreviation cannot map to more than one original words.
If the abbreviation doesn't make the word shorter, then keep it as original.
Example:
Input: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
Note:
Both n and the length of each word will not exceed 400.
The length of each word is greater than 1.
The words consist of lowercase English letters only.
The return answers should be in the same order as the original array.
```

















