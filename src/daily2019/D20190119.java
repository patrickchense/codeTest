package daily2019;

import util.BTNode;

/*
Print the nodes in a binary tree level-wise. For example, the following should print 1, 2, 3, 4, 5.

  1
 / \
2   3
   / \
  4   5

@Microsoft

@solved
@binarytree
@traverse

关于BinaryTree 在TreeNode 里很多方法很重要，要完全理解
 */
public class D20190119 {

    public static void main(String[] args) {
        BTNode n1 = new BTNode(1);
        BTNode n2 = new BTNode(2);
        BTNode n3 = new BTNode(3);
        BTNode n4 = new BTNode(4);
        BTNode n5 = new BTNode(5);

        n1.left = n2;
        n3.left = n4;
        n3.right = n5;
        n1.right = n3;

        StringBuilder sb = new StringBuilder();
        BTNode.printLevelOrderIgnoreNull(n1, sb);
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
