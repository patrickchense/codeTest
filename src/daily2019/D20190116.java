package daily2019;

import util.Node;

/*
Determine whether a doubly linked list is a palindrome. What if it’s singly linked?

For example, 1 -> 4 -> 3 -> 4 -> 1 returns true while 1 -> 4 returns false.

@Google
@linkedlist
@palindrome

@solved
@review

这里在比较值的时候，感觉还可以提高速度？怎么做？
https://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/
 */
public class D20190116 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(4);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(isPalindromeLinkedlist(n1));
        System.out.println(isPalindrome(n1));

        Node t1 = new Node(1);
        Node t2 = new Node(4);
        t1.next = t2;
        System.out.println(isPalindromeLinkedlist(t1));
        System.out.println(isPalindrome(t1));
    }

    // palindrome reuqest  l[i] == l[len-1-i]
    // 对于Linkedlist 只要找到长度，然后移动到位置，0, len-1-1,   1, len-1-1-1,
    public static boolean isPalindromeLinkedlist(Node head) {
        Node t = head;
        int len = 0;
        while(t.next != null) {
            len++;
            t = t.next;
        }
        int i = 0;
        int j = len;
        while (i < j) {
            Node t1 = head;
            for(int k = 0; k < i; k++) t1 = t1.next;
            Node t2 = head;
            for(int k = j; k > 0; k--) t2 = t2.next;
            if (t1.data != t2.data) return false;
            i++;
            j--;
        }
        return true;
    }
    
    //倒序的方式 O(n) O(n)
    public static boolean isPalindrome(Node head) {
        if(head == null)
            return true;

        Node p = head;
        Node prev = new Node(head.data);

        while(p.next != null){
            Node temp = new Node(p.next.data);
            temp.next = prev;
            prev = temp;
            p = p.next;
        }

        Node p1 = head;
        Node p2 = prev;

        while(p1!=null){
            if(p1.data != p2.data)
                return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
    
    // break reserve the second half
    public boolean isPalindrome2(Node head) {

        if(head == null || head.next==null)
            return true;

        //find list center
        Node fast = head;
        Node slow = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node secondHead = slow.next;
        slow.next = null;

        //reverse second part of the list
        Node p1 = secondHead;
        Node p2 = p1.next;

        while(p1!=null && p2!=null){
            Node temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        secondHead.next = null;

        //compare two sublists now
        Node p = (p2==null?p1:p2);
        Node q = head;
        while(p!=null){
            if(p.data != q.data)
                return false;

            p = p.next;
            q = q.next;

        }

        return true;
    }
}
