package daily2019;

import util.BTNode;
import util.NodeUtil;

/*
Given the sequence of keys visited by a postorder traversal of a binary search tree, reconstruct the tree.

For example, given the sequence 2, 4, 3, 8, 7, 5, you should construct the following tree:

    5
   / \
  3   7
 / \   \
2   4   8

@Google
@Medium
@binarytree
@classic

@solved
@10min

二叉树经典，从array -> tree的反向
 */
public class D20190331_2 {

     public static void main(String[] args) {
        BTNode n = buildBTByPostIntArray(new int[]{2, 4, 3, 8, 7, 5});
        StringBuilder sb = new StringBuilder();
        n.printPostorder(n, sb);
        System.out.println(sb);
        BTNode n1 = constructTree(new int[]{2, 4, 3, 8, 7, 5}, 6);
        sb = new StringBuilder();
         n1.printPostorder(n1, sb);
         System.out.println(sb);
     }

     // 后序遍历Int -> tree
     // last one is root
     // second last if > root,  is right of root, else is left of root
     // O(n^2)
     public static BTNode buildBTByPostIntArray(int[] arr) {
        BTNode root = new BTNode(arr[arr.length -1]);
        BTNode[] nodes = new BTNode[arr.length];
        nodes[0] = root;
        for (int i = arr.length -2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                // right
                BTNode n = new BTNode(arr[i]);
                nodes[arr.length- i - 1 - 1].right = n;
                nodes[arr.length- i - 1] = n;
            }
            else {
                // maybe left or parent's left
                for (int j = i+1; j < arr.length-1; j++) {
                    if (arr[j+1] > arr[j]) continue;
                    BTNode n = new BTNode(arr[i]);
                    nodes[arr.length - j - 1].left = n;
                    nodes[arr.length - i - 1] = n;
                    break;
                }
            }
        }
        return root;
     }

     // what's better ?
     //https://www.geeksforgeeks.org/construct-a-binary-search-tree-from-given-postorder/ O(n)
    // 其实递归的逻辑，先处理的是right，然后right处理结束，index自然移到了处理left的地方
     static  int postindex = 0;
    static BTNode constructTree(int post[], int size) {
         postindex = size - 1;
         return constructTreeUtil(post, postindex, post[postindex], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
     }

    static BTNode constructTreeUtil(int post[], int postIndex, int key, int min, int max, int size) {
        // Base case
        if (postindex < 0)
            return null;

        BTNode root = null;

        // If current element of post[] is in range, then
        // only it is part of current subtree
        if (key > min && key < max)
        {
            // Allocate memory for root of this subtree and decrement
            // *postIndex
            root = new BTNode(key);
            postindex = postindex - 1;

            if (postindex > 0)
            {
                // All nodes which are in range {key..max} will go in
                // right subtree, and first such node will be root of right
                // subtree
                root.right = constructTreeUtil(post, postIndex, post[postindex],key, max, size);
                // Contruct the subtree under root
                // All nodes which are in range {min .. key} will go in left
                // subtree, and first such node will be root of left subtree.
                root.left = constructTreeUtil(post, postIndex, post[postindex],min, key, size);
            }
        }
        return root;
    }

}
