package amazon;

/*
https://leetcode.com/discuss/interview-question/362324/Two-Sigma-or-OA-2019-or-SWE

Given two sentences, s and t, t is a subsequence of s if all of the words in t occur in the occur in the same order within s.
Words do not have to appear contiguously in s, but order must be maintained. For example, given the sentance "I like cheese", one example of
a subsequence would be "I cheese".

In this challenge, you will be given two sentences, s and t.
It is guaranteed that string t is a subsequence of string s. When reading string s from left to right, locate the first occurence of subsequence t.
Remove this subsequence and return the remaining elements of string s in order.

Example:
s = I like eating cheese do you like cheese
t = like cheese
Return: I eating do you like cheese

Helpful note:
Be sure to always take the first occurrence of an element if it appears multiple times in a subsequence. For example:
s = I like soft cheese and hard cheese yum
t = like cheese yum
Notice that there are two subsequences in string s containing t
	I like soft cheese and hard cheese yum
	I like soft cheese and hard cheese yum
The correct return will remove the 4th word, not the 7th word, returning "I soft and hard cheese" rather than "I soft cheese and hard".

sample input 0:
I use HackerRank to be a better programmer and to practice
HackerRank to practice

output:
I
use
be
a
better
programmer
and
to

explanation:
we find the first subsequence of "HackerRank to practice" in string s, which occurs at words 3,4 and 11. Removing these words, we return the remaining elements
of string s as separate words.


 */
public class MissingWords {
}
