package daily2019;

import util.BSTNode;

import java.util.HashMap;
import java.util.Map;

/*
Given a binary tree, return the level of the tree with minimum sum.

找个例子
              1
            /   \
           2     3
         /  \   /  \
        4   5   6   7
           /     \
          8       9

Output : 3,
Leaf nodes 4 and 7 are at minimum level.
Their sum = (4 + 7) = 11.

这题题意不清，例子是我自己找的，我的理解也是同样，返回3， 第三层的leaf sum最小
@Facebook
@binarytree
@sum
@solved
@review

https://www.geeksforgeeks.org/sum-leaf-nodes-minimum-level/
相关的是binarytree的分层的题
https://www.geeksforgeeks.org/print-leaf-nodes-at-a-given-level/
https://www.geeksforgeeks.org/difference-between-sums-of-odd-and-even-levels/
https://www.geeksforgeeks.org/connect-nodes-level-level-order-traversal/
https://www.geeksforgeeks.org/find-depth-of-the-deepest-odd-level-node/
https://www.geeksforgeeks.org/sum-leaf-nodes-binary-tree/
https://www.geeksforgeeks.org/count-non-leaf-nodes-binary-tree/

https://www.geeksforgeeks.org/determine-the-count-of-leaf-nodes-in-an-n-ary-tree/
https://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
https://www.geeksforgeeks.org/print-leaf-nodes-left-right-binary-tree/
https://www.geeksforgeeks.org/number-of-leaf-nodes-in-the-subtree-of-every-node-of-an-n-ary-tree/

 */
public class D20190129 {

    public static void main(String[] args) {
        BSTNode n1 = new BSTNode(8);
        BSTNode n2 = new BSTNode(9);
        BSTNode n3 = new BSTNode(4);
        BSTNode n4 = new BSTNode(5);
        BSTNode n5 = new BSTNode(6);
        BSTNode n6 = new BSTNode(7);
        BSTNode n7 = new BSTNode(2);
        BSTNode n8 = new BSTNode(3);
        BSTNode n9 = new BSTNode(1);

        n4.left = n1;
        n5.right = n2;
        n7.left = n3;
        n7.right = n4;
        n8.left = n5;
        n8.right = n6;
        n9.left = n7;
        n9.right = n8;

        Map<Integer, Integer> res = new HashMap<>();
        levelSum(n9, res, 1);
        int max = Integer.MAX_VALUE;
        int i = 0;
        for (Map.Entry<Integer, Integer> e : res.entrySet()) {
            if (e.getValue() < max) {
                i = e.getKey();
                max = e.getValue();
            }
        }
        System.out.println(i);
    }

    public static void levelSum(BSTNode root, Map<Integer, Integer> res, int level) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (res.containsKey(level)) {
                res.put(level, res.get(level) + root.val);
            }
            else {
                res.put(level, root.val);
            }
        }
        levelSum(root.left, res, ++level);
        levelSum(root.right, res, level);
        level--;
    }
}
