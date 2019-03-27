package daily2019;

import util.TreeNode;

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
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n3.left = n4;
        n3.right = n5;
        n1.right = n3;

        StringBuilder sb = new StringBuilder();
        TreeNode.printLevelOrderIgnoreNull(n1, sb);
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
