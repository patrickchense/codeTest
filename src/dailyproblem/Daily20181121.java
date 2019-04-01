package dailyproblem;

/*
Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.

For example, given the following preorder traversal:

[a, b, d, e, c, f, g]

And the following inorder traversal:

[d, b, e, a, f, c, g]

You should return the following tree:

    a
   / \
  b   c
 / \ / \
d  e f  g
@google

@classic
@solved
@binarytree
@traverse

preOder/inOrder string to a tree  @memtioned bfd_dfs.md

https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/

 */
public class Daily20181121 {

    static class Node {
        char val;
        Node left;
        Node right;

        public Node(char val) {
            this.val = val;
        }
    }


    static int preIndex = 0;

    public static Node reConstructTree(char in[], char pre[], int inStart, int inEnd) {

        if (inStart >= inEnd) return null;

        Node tNode = new Node(pre[preIndex++]);

        int inIndex = search(in, inStart, inEnd, tNode.val);
        tNode.left = reConstructTree(in, pre, inStart, inIndex);
        tNode.right = reConstructTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    private static int search(char[] in, int inStart, int inEnd, char val) {
        for (int i = inStart; i < inEnd; i++) {
            if (in[i] == val) return i;
        }
        return -1;
    }

    static void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.val + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

   public static void main(String[] args) {
       char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
       char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
       Node root = reConstructTree(in, pre, 0, in.length);

       // building the tree by printing inorder traversal
       System.out.println("Inorder traversal of constructed tree is : ");
       printInorder(root);
       System.out.println();
        preIndex = 0;
      String a = "abdecfg";
      String b = "dbeafcg";
      root = reConstructTree(b.toCharArray(), a.toCharArray(), 0, a.length());
       printInorder(root);
       System.out.println();
   }

}
