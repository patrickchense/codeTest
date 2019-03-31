package daily2019;

import util.BTNode;

/*
Given a tree, find the largest tree/subtree that is a BST.
      5
    /  \
   2    4
 /  \
1    3

       50
     /    \
  30       60
 /  \     /  \
5   20   45    70
              /  \
            65    80

Given a tree, return the size of the largest tree/subtree that is a BST.

@Apple
@binarytree
@review
@answered

二叉树BST特点?
ordered
no more than two child
left < root < right

how to define largest?
more nodes?


https://www.geeksforgeeks.org/largest-bst-binary-tree-set-2/
https://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/


In this post a different O(n) solution is discussed. This solution is simpler than the solutions discussed above and works in O(n) time.

The idea is based on method 3 of check if a binary tree is BST article.

A Tree is BST if following is true for every node x.

The largest value in left subtree (of x) is smaller than value of x.
The smallest value in right subtree (of x) is greater than value of x.
We traverse tree in bottom up manner. For every traversed node, we return maximum and minimum values in subtree rooted with it.
If any node follows above properties and size of


https://www.geeksforgeeks.org/find-largest-subtree-sum-tree/
https://www.geeksforgeeks.org/find-largest-subtree-having-identical-left-and-right-subtrees/
https://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
 */
public class D20190105 {

    public static void main(String[] args) {
        BTNode n1 = new BTNode(5);
        BTNode n2 = new BTNode(2);
        BTNode n3 = new BTNode(4);
        BTNode n4 = new BTNode(1);
        BTNode n5 = new BTNode(3);
        n2.left = n4;
        n2.right = n5;
        n1.left = n2;
        n1.right = n3;
        System.out.println(largestBST(n1));
    }



    /*
    In method 1, we traverse the tree in top down manner and do BST test for every node. If we traverse the tree in bottom up manner,
    then we can pass information about subtrees to the parent. The passed information can be used by the parent to do BST test (for parent node)
    only in constant time (or O(1) time). A left subtree need to tell the parent whether it is BST or not and also need to pass maximum value in it.
    So that we can compare the maximum value with the parent’s data to check the BST property. Similarly, the right subtree need to pass the minimum value up the tree.
     The subtrees need to pass the following information up the tree for the finding the largest BST.
1) Whether the subtree itself is BST or not (In the following code, is_bst_ref is used for this purpose)
2) If the subtree is left subtree of its parent, then maximum value in it. And if it is right subtree then minimum value in it.
3) Size of this subtree if this subtree is BST (In the following code, return value of largestBSTtil() is used for this purpose)

max_ref is used for passing the maximum value up the tree and min_ptr is used for passing minimum value up the tree.

简单说就是不从root往下遍历，而是从leaf往上遍历，递归判断每个left/right是不是BST,然后size等，需要一个额外的类来记录这些
     */

    static class Value {

        int max_size = 0; // for size of largest BST
        boolean is_bst = false;
        int min = Integer.MAX_VALUE;  // For minimum value in right subtree
        int max = Integer.MIN_VALUE;  // For maximum value in left subtree

    }

    static Value val = new Value();
    static int largestBST(BTNode node) {

        largestBSTUtil(node, val, val, val, val);

        return val.max_size;
    }

    /* largestBSTUtil() updates *max_size_ref for the size of the largest BST
     subtree.   Also, if the tree rooted with node is non-empty and a BST,
     then returns size of the tree. Otherwise returns 0.*/
    static int largestBSTUtil(BTNode node, Value min_ref, Value max_ref, Value max_size_ref, Value is_bst_ref) {

        /* Base Case */
        if (node == null) {
            is_bst_ref.is_bst = true; // An empty tree is BST
            return 0;    // Size of the BST is 0
        }

        int min = Integer.MAX_VALUE;

        /* A flag variable for left subtree property
         i.e., max(root->left) < root->data */
        boolean left_flag = false;

        /* A flag variable for right subtree property
         i.e., min(root->right) > root->data */
        boolean right_flag = false;

        int ls, rs; // To store sizes of left and right subtrees

        /* Following tasks are done by recursive call for left subtree
         a) Get the maximum value in left subtree (Stored in *max_ref)
         b) Check whether Left Subtree is BST or not (Stored in *is_bst_ref)
         c) Get the size of maximum size BST in left subtree (updates *max_size) */
        max_ref.max = Integer.MIN_VALUE;
        ls = largestBSTUtil(node.left, min_ref, max_ref, max_size_ref, is_bst_ref);
        if (is_bst_ref.is_bst == true && node.val > max_ref.max) {
            left_flag = true;
        }

        /* Before updating *min_ref, store the min value in left subtree. So that we
         have the correct minimum value for this subtree */
        min = min_ref.min;

        /* The following recursive call does similar (similar to left subtree)
         task for right subtree */
        min_ref.min = Integer.MAX_VALUE;
        rs = largestBSTUtil(node.right, min_ref, max_ref, max_size_ref, is_bst_ref);
        if (is_bst_ref.is_bst == true && node.val < min_ref.min) {
            right_flag = true;
        }

        // Update min and max values for the parent recursive calls
        if (min < min_ref.min) {
            min_ref.min = min;
        }
        if (node.val < min_ref.min) // For leaf nodes
        {
            min_ref.min = node.val;
        }
        if (node.val > max_ref.max) {
            max_ref.max = node.val;
        }

        /* If both left and right subtrees are BST. And left and right
         subtree properties hold for this node, then this tree is BST.
         So return the size of this tree */
        if (left_flag && right_flag) {
            if (ls + rs + 1 > max_size_ref.max_size) {
                max_size_ref.max_size = ls + rs + 1;
            }
            return ls + rs + 1;
        } else {
            //Since this subtree is not BST, set is_bst flag for parent calls
            is_bst_ref.is_bst = false;
            return 0;
        }
    }
}
