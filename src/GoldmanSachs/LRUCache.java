package GoldmanSachs;

import java.util.HashMap;
import java.util.Map;

/*
How to implement LRU caching scheme? What data structures should be used?
We are given total possible page numbers that can be referred. We are also given cache (or memory) size (Number of page frames that cache can hold at a time).
 The LRU caching scheme is to remove the least recently used frame when the cache is full and a new page is referenced which is not there in cache.
 Please see the Galvin book for more details (see the LRU page replacement slide here).

 solution:
 We use two data structures to implement an LRU Cache.

Queue which is implemented using a doubly linked list.
    The maximum size of the queue will be equal to the total number of frames available (cache size).
    The most recently used pages will be near front end and least recently pages will be near rear end.
A Hash with page number as key and address of the corresponding queue node as value.

When a page is referenced, the required page may be in the memory.
If it is in the memory, we need to detach the node of the list and bring it to the front of the queue.
If the required page is not in the memory, we bring that in memory.
In simple words, we add a new node to the front of the queue and update the corresponding node address in the hash.
If the queue is full, i.e. all the frames are full, we remove a node from the rear of queue, and add the new node to the front of queue.


 */
public class LRUCache {
    class ListNode {
        int key;
        int val;
        ListNode prev, next;

        ListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    Map<Integer, ListNode> cache;
    ListNode head, tail;
    int size, capacity;

    public LRUCache(int capacity) {
        tail = head;
        cache = new HashMap<>();
        size = 0;
        this.capacity = capacity;
    }

    public void moveToLast(int key) {
        ListNode node = cache.get(key);
        tail.next = new ListNode(key, node.val);
        tail.next.prev = tail;
        tail = tail.next;
        removeNode(node);
        cache.put(key, tail);
    }

    public void removeNode(ListNode node) {
        cache.remove(node.key);
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        if (node == head) {
            head = head.next;
            if (head != null) head.prev = null;
        }
        if (node == tail) {
            tail = tail.prev;
        }
    }

    public void appendNode(int key, int value) {
        if (head == null) {
            head = new ListNode(key, value);
            tail = head;
            cache.put(key, head);
        } else {
            tail.next = new ListNode(key, value);
            tail.next.prev = tail;
            cache.put(key, tail.next);
            tail = tail.next;
        }
    }


    public int get(int key) {
        if (cache.containsKey(key)) {
            moveToLast(key);

            return cache.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            removeNode(cache.get(key));
            appendNode(key, value);
        } else if (size + 1 > capacity) {
            // remove first
            if (head != null) {
                removeNode(head);
            }
            appendNode(key, value);
        } else {
            // add
            appendNode(key, value);
            size++;
        }
    }
}
