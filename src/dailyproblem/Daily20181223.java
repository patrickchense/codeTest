package dailyproblem;

import util.BTNode;

/*
Given the root of a binary tree, return a deepest node. For example, in the following tree, return d.

    a1
   / \
  b2   c4
 /
d3
@google
@binarytree
@recursive

关键是记录最深的level, 递归每次只能返回一项，这里选择返回node，所以记录max_level is key
 */
public class Daily20181223 {
    public static void main(String[] args){
        BTNode n1 = new BTNode(1);
        BTNode n2 = new BTNode(2);
        BTNode n3 = new BTNode(3);
        BTNode n4 = new BTNode(4);
        n2.left = n3;
        n1.left = n2;
        n1.right = n4;
        BTNode deep = deepest(n1);
        System.out.println(deep.val);
    }

    static int max_height = 0;

    public static BTNode deepest(BTNode root ) {
        if(root == null) return null;
        if (root.left == null && root.right == null) {
            max_height++;
            return root;
        }
        BTNode leftDeep = null;
        BTNode rightDeep = null;
        max_height++;
        int cur = max_height;
        int left = cur;
        int right = cur;
        if (root.left != null) {
            leftDeep = deepest(root.left);
            left = max_height;
            max_height = cur;
        }
        if (root.right != null) {
            rightDeep = deepest(root.right);
            right = max_height;
            max_height = cur;
        }
        if (left > right) {
            max_height = left;
            return leftDeep;
        }
        max_height = right;
        return rightDeep;
    }
}
