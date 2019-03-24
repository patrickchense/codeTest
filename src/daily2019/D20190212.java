package daily2019;

/*
Given the head to a singly linked list, where each node also has a “random” pointer that points to anywhere in the linked list, deep clone the list.

@Snapchat
@linkedlist
@answered
@review

https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
https://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/

 */
public class D20190212 {

    class RandomNode {
        int val;
        RandomNode next;
        RandomNode random;

        public RandomNode(int val) {this.val = val;}
    }

    public static void main(String[] args) {

    }

/*
1) Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List, create the copy of 2 and insert it between 2 & 3..
Continue in this fashion, add the copy of N afte the Nth node
2) Now copy the arbitrary link in this fashion
 original->next->arbitrary = original->arbitrary->next;
This works because original->next is nothing but copy of original and Original->arbitrary->next is nothing but copy of arbitrary.
3) Now restore the original and copy linked lists in this fashion in a single loop.

     original->next = original->next->next;
     copy->next = copy->next->next;
4) Make sure that last element of original->next is NULL.

O(n) O(1)

 */

    public RandomNode deepClone(RandomNode root) {

        return null;
    }
}
