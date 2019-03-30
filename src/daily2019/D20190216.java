package daily2019;

import util.BSTNode;

/*
Given a binary tree, find a minimum path sum from root to a leaf.

For example, the minimum path in this tree is [10, 5, 1, -1], which has sum 15.

  10
 /  \
5    5
 \     \
   2    1
       /
     -1

@Apple
@answered
@review
@binarytree
@tree

https://algorithms.tutorialhorizon.com/given-a-binary-tree-find-out-the-maximum-sum-of-value-from-root-to-each-leaf/  解法


二叉树，路径求和等问题
https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/ sum to target

https://www.geeksforgeeks.org/shortest-root-to-leaf-path-sum-equal-to-a-given-number/
https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number-in-bst/
https://www.geeksforgeeks.org/find-pair-root-leaf-path-sum-equals-roots-data/
https://www.geeksforgeeks.org/root-leaf-path-maximum-distinct-nodes/
https://www.geeksforgeeks.org/sum-nodes-longest-path-root-leaf-node/
https://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
https://www.geeksforgeeks.org/print-the-first-shortest-root-to-leaf-path-in-a-binary-tree/


 */
public class D20190216 {

    public static void main(String[] args) {
        BSTNode n1 = new BSTNode(-1);
        BSTNode n2 = new BSTNode(2);
        BSTNode n3 = new BSTNode(1);
        n3.left = n1;
        BSTNode n4 = new BSTNode(5);
        BSTNode n5 = new BSTNode(5);
        n4.right = n2;
        n5.right = n3;
        BSTNode n6 = new BSTNode(10);
        n6.left = n4;
        n6.right = n5;

        minSum(n6, 0);
        System.out.println("min sum: " + minSum);
        System.out.print("Path: ");
        path(n6, minLeaf);
    }

    // 怎么把两个条件结合起来？ 一个是sum 一个是记录node val
    // 分2步走，找到最小的leaf, 在path
    static int minSum = Integer.MAX_VALUE;
    static BSTNode minLeaf = null;
    public static void minSum(BSTNode root, int sum){
        if(root!=null){
            sum=sum+root.val;
            if(sum < minSum && root.left==null && root.right==null){
                minLeaf = root;
                minSum = sum;
            }
            //	System.out.println("Sum " + sum);
            minSum(root.left,sum);
            minSum(root.right,sum);
        }
    }
    public static Boolean path(BSTNode root, BSTNode leaf){
        if(root==null) return false;
        if ((root == leaf) || path(root.left, leaf) ||path(root.right, leaf) )
        {
            System.out.print(" " + root.val);
            return true;
        }
        return false;
    }

    //计算最小
    public static int minPathSum(BSTNode root) {
        if(root == null) return 0;
        int sum = root.val;
        int leftSum = Integer.MAX_VALUE;
        int rightSum = Integer.MAX_VALUE;
        if(root.right==null && root.left==null) {
            return sum;
        }else{

            if(root.left!=null){
                leftSum = minPathSum(root.left);
            }
            if (root.right!=null){
                rightSum = minPathSum(root.right);
            }
            if(leftSum < rightSum){
                sum += leftSum;
            }else{
                sum += rightSum;
            }
        }

        return sum;
    }

}
