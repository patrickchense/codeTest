package leetcode.tree;

import java.util.Stack;

/*
https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.

@answered
@tire
@review

TIRE tree classic，还是不会

 */
public class LT_421_MaxXORTwoInArray {

    public int findMaximumXOR(int[] nums) {

        //*** Create the tree from nums
        Node root = new Node((byte) 0);
        for(int num : nums){
            insert(root, num);
        }

        return find(root, root, 0, 0, 0);
    }

    //*** step - position in the tree or numbers (ex: 10110, step=0 it's 1, step=1 it's 0)
    //*** cur1, cur2 - numbers that we get wen reach the end of the tree
    //*** n1,n2 - nodes in the current step of the tree
    private int find(Node n1, Node n2, int cur1, int cur2, int step){

        //*** Add one digit to the end of the numbers
        cur1 <<= 1;
        cur1 += n1.val;
        cur2 <<= 1;
        cur2 += n2.val;

        //*** When we reach the end of the tree -> return XOR of the assembled numbers
        if(step == 31)
            return cur1^cur2;

        //*** XOR gives max result if digits are different -> search for the next different digits in the tree
        int maxRes = -1;
        if(n1.zero != null && n2.one != null){
            maxRes = Math.max(maxRes, find(n1.zero, n2.one, cur1, cur2, step+1));
        }
        if (n1.one != null && n2.zero != null){
            if(maxRes < 0 || cur1 != cur2)
                maxRes = Math.max(maxRes, find(n1.one, n2.zero, cur1, cur2, step+1));
        }

        //*** If there are no different digits -> take the same
        if(maxRes < 0) {
            if (n1.one != null && n2.one != null) {
                maxRes = Math.max(maxRes, find(n1.one, n2.one, cur1, cur2, step+1));
            }
            if (n1.zero != null && n2.zero != null) {
                maxRes = Math.max(maxRes, find(n1.zero, n2.zero, cur1, cur2, step+1));
            }
        }
        return maxRes;
    }

    //*** Create tree with the same length for all values
    private void insert(Node root, int num){

        //*** Get digits from the num and add it to the stack one by one
        Stack<Byte> stack = new Stack<>();
        while(num != 0){
            stack.push((byte) ((num & 1) != 0 ? 1 : 0));
            num >>= 1;
        }

        //*** If count digits is less than the max -> add 0 to the head
        while(stack.size() < 31){
            stack.push((byte)0);
        }

        //*** Add new number to the root (tree)
        Node node = root;
        while(!stack.isEmpty()){
            Byte val = stack.pop();
            Node child = val == 1 ? node.one : node.zero;
            if(child == null){
                child = new Node(val);
                if(val == 1)
                    node.one = child;
                else
                    node.zero = child;
            }
            node = child;
        }
    }

    private class Node {
        byte val;
        Node one;
        Node zero;
        public Node(byte val){
            this.val = val;
        }
    }
}
