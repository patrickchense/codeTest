https://docs.google.com/document/d/1DPcHx-7Lkkhaf2El80ru-GLz37z93iGYB6adHTN01S0/edit

##两个字符串数组，找第一个中所有字符串，包含任意一个第二组字符串的
###https://leetcode.com/problems/word-subsets/description/ 
###解法
自己解, 纯逻辑，找到B的所有字符串的合集，注意重复的字符串(利用int[26]数组标记duplicat)  
然后，每个A的字符串，排序之后再找是否和之前的common匹配   

比较A的时候，也是利用int[26]来，然后比较每个位置和common的数量如果一个小于就false  

 
##Construct Binary Tree from String
###地址
https://blog.csdn.net/mcf171/article/details/61616098 


##string 利用stack 是 括号匹配的问题系列,  
###https://leetcode.com/problems/score-of-parentheses/description/ 
###解法
解决的主要方式，利用stack 存sum而不是塞(进去, ( == -1, 塞入，) 直接计算弹出
```java
char c = S.charAt(i);
			if (c == '(') {
				stack.addFirst(-1);
			} else {
				int count = 0;
				while (!stack.isEmpty() && stack.peekFirst() != -1) {
					count += stack.removeFirst();
				}
				stack.removeFirst();
				count = count == 0 ? 1 : 2 * count;
				stack.addFirst(count);
			}
```



##string 单词逆转，
###https://leetcode.com/problems/reverse-words-in-a-string/description/ 
###解法
一种是通过string的split来操作  
一种是通过纯字符来操作，也就是碰到’ ‘ 然后拼出单词  


