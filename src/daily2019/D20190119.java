package daily2019;

import util.BSTNode;

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
        BSTNode n1 = new BSTNode(1);
        BSTNode n2 = new BSTNode(2);
        BSTNode n3 = new BSTNode(3);
        BSTNode n4 = new BSTNode(4);
        BSTNode n5 = new BSTNode(5);

        n1.left = n2;
        n3.left = n4;
        n3.right = n5;
        n1.right = n3;

        StringBuilder sb = new StringBuilder();
        BSTNode.printLevelOrderIgnoreNull(n1, sb);
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
