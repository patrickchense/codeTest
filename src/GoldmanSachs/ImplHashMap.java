package GoldmanSachs;

/*

leetcode 706
https://leetcode.com/problems/design-hashmap/description/

Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

 */
public class ImplHashMap {

    /*
    hashmap, use hashSet inside
    use segments
    attrs:
        float loadFactor
        int size
        Set<K>        keySet
        Collection<V> values
        Node<K,V> table  // use to impl same key linked list
    functions:
        init:
            ()
            (size, factor)
            (size)
        put:
            put(k,v)
            putAll(map)
            replace(k,v,v)
        get:
            Set<k> keySet()
            v get(k)

            int hash(k)
            int size()
            Set<Map.Entry<K,V>> entrySet()
            Collection<V> values()
        delete:
            V remove(k)
        others:
            boolean isEmpty
            boolean containsKey(k)
     */

    /*
    can't resize
     */
    class MyHashMap {
        final Bucket[] buckets = new Bucket[10000];

        public void put(int key, int value) {
            int i = idx(key);
            if (buckets[i] == null)
                buckets[i] = new Bucket();
            ListNode prev = find(buckets[i], key);
            if (prev.next == null)
                prev.next = new ListNode(key, value);
            else prev.next.val = value;
        }

        public int get(int key) {
            int i = idx(key);
            if (buckets[i] == null)
                return -1;
            ListNode node = find(buckets[i], key);
            return node.next == null ? -1 : node.next.val;
        }

        public void remove(int key) {
            int i = idx(key);
            if (buckets[i] == null) return;
            ListNode prev = find(buckets[i], key);
            if (prev.next == null) return;
            prev.next = prev.next.next;
        }

        int idx(int key) {
            return Integer.hashCode(key) % buckets.length;
        }

        /*
        very smart to return prev not current
         */
        ListNode find(Bucket bucket, int key) {
            ListNode node = bucket.head, prev = null;
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }
    }

    class Bucket {
        final ListNode head = new ListNode(-1, -1);
    }

    class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
