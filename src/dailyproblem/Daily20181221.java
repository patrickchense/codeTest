package dailyproblem;

import util.Node;

import java.util.List;
import java.util.PriorityQueue;

import static util.ArrayUtil.printList;
import static util.ArrayUtil.printNode;

/*
Given k sorted singly linked lists, write a function to merge all the lists into one sorted singly linked list.

@Google
@souce https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
@review
@linkedlist
@sorted

 */
public class Daily20181221 {

    public static void main(String[] args) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        Node arr[]=new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        // Merge all lists
        Node head = mergeKLists(arr, k - 1);

        printNode(head);
    }

    /*
        2-> 5 -> 9
        3-> 4->7
        1->10->11
          1->
            1->2
                1->2->3
                    1->2->3->4

        O(n), space,  O(n*log(k)) time
     */
    public static Node mergeKSortedLinkedList(List<Node> lists) {
        if(lists==null||lists.size()==0)
            return null;

        PriorityQueue<Node> queue = new PriorityQueue<Node>((l1, l2) -> l1.data - l2.data);

        Node head = new Node(0);
        Node p = head;

        for(Node list: lists){
            if(list!=null)
                queue.offer(list);
        }

        while(!queue.isEmpty()){
            Node n = queue.poll();
            p.next = n;
            p=p.next;

            if(n.next!=null)
                queue.offer(n.next);
        }

        return head.next;

    }

    // recursive sort merge
    public static Node sortedMerge(Node a, Node b)
    {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        else if(b == null)
            return a;

        /* Pick either a or b, and recur */
        if(a.data <= b.data)
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else
        {
            result = b;
            result.next = sortedMerge(a, b.next);
        }

        return result;
    }

    // The main function that takes an array of lists
    // arr[0..last] and generates the sorted output
    public static Node mergeKLists(Node arr[], int last)
    {
        // repeat until only one list is left
        while (last != 0)
        {
            int i = 0, j = last;

            // (i, j) forms a pair
            while (i < j)
            {
                // merge List i with List j and store
                // merged list in List i
                arr[i] = sortedMerge(arr[i], arr[j]);

                // consider next pair
                i++; j--;

                // If all pairs are merged, update last
                if (i >= j)
                    last = j;
            }
        }

        return arr[0];
    }
}
