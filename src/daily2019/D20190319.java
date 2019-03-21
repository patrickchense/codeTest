package daily2019;

/*
Implement a 2D iterator class. It will be initialized with an array of arrays, and should implement the following methods:

next(): returns the next element in the array of arrays. If there are no more elements, raise an exception.
has_next(): returns whether or not the iterator still has elements left.
For example, given the input [[1, 2], [3], [], [4, 5, 6]], calling next() repeatedly should output 1, 2, 3, 4, 5, 6.

Do not use flatten or otherwise clone the arrays. Some of the arrays can be empty.

@Uber

 */
public class D20190319 {
    public static void main(String[] args) {

    }

    class TwoDIterator {
        class Node{
            Node next;
            Integer val;
        }

        Node[] nodes;

        int s = 0;

        Node cur = null;

        int cur_i = 1;

        public TwoDIterator(int[][] arrays) {
            nodes = new Node[arrays.length];
            for (int[] arr : arrays) {
                Node head = new Node();
                head.val = 0;
                if (arr != null && arr.length > 0) {
                    Node prev = head;
                    for (int i : arr) {
                        Node n = new Node();
                        n.val = i;
                        prev.next = n;
                        prev = n;
                    }
                }
                nodes[s++] = head;
            }
        }

        public Integer next() throws Exception {
            if (nodes == null) throw new Exception("out of bounds");
            if (cur == null) cur = nodes[0];
            if (cur != null) {
                if (cur.next == null && cur_i == nodes.length - 1) throw new Exception("out of bounds");
                if (cur.next == null) {
                    cur = nodes[cur_i++];
                }
            }
            Integer res = cur.next == null ? null : cur.next.val;
            cur = cur.next;
            return res;
        }

        public boolean has_next() {
            if (nodes == null) return false;
            if (cur == null) return true;
            if (cur.next == null && cur_i == nodes.length - 1) return false;
            return true;
        }
    }
}
