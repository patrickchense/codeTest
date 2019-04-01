package dailyproblem;

import util.BTNode;
import util.TreeNode;

/*
nvert a binary tree.

For example, given the following tree:

    a1
   /   \
  b2    c3
 /   \  /
d4   e5 f
should become:

  a
 / \
 c  b
 \  / \
  f e  d



@google
@binarytree
@rotate
@solved

树的扭转
这里的逻辑，left 变成right
 */
public class Daily20181226 {

    public static void main(String[] args) {
        BTNode n1 = new BTNode(1);
        BTNode n2 = new BTNode(2);
        BTNode n3 = new BTNode(3);
        BTNode n4 = new BTNode(4);
        BTNode n5 = new BTNode(5);
        BTNode n6 = new BTNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        StringBuilder sb = new StringBuilder();
        n1.printInOrder(n1, sb);
        System.out.println(sb.toString());
        BTNode n = rotate(n1);
        sb = new StringBuilder();
        n.printInOrder(n, sb);
        System.out.println(sb.toString());
    }


    public static BTNode rotate(BTNode root) {
        if (root == null) return null;
        BTNode t = root.right;
        if (root.left != null) {
            root.right = rotate(root.left);
            root.left = null;
        } else {
            root.right = null; //忘了设置right == null, 如果left == null, 就不会进入上面的,right就还是原来的
        }
        if (t != null) {
            root.left = rotate(t);
        }
        return root;
    }
}
