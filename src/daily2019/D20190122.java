package daily2019;

import util.ArrayUtil;
import util.BTNode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, return all paths from the root to leaves.

For example, given the tree

   1
  / \
 2   3
    / \
   4   5
it should return [[1, 2], [1, 3, 4], [1, 3, 5]].

@Facebook
@binarytree

@path

@recursive

@solved


 */
public class D20190122 {

    public static void main(String[] args) {
        BTNode n1 = new BTNode(1);
        BTNode n2 = new BTNode(2);
        BTNode n3 = new BTNode(3);
        BTNode n4 = new BTNode(4);
        BTNode n5 = new BTNode(5);
        n3.left = n4;
        n3.right = n5;
        n1.left = n2;
        n1.right = n3;
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        findAllPath(n1, paths, cur);
        ArrayUtil.printList(paths);
    }

    // 递归的关键还是在于找到结束条件
    public static void findAllPath(BTNode root, List<List<Integer>> paths, List<Integer> cur)  {
        cur.add(root.val);
        if (root.left == null && root.right == null) {
            List<Integer> p = new ArrayList<>(cur);
            paths.add(p);
            return;
        }
        if (root.left != null) {
            findAllPath(root.left, paths, cur);
            cur.remove(cur.size() - 1);
        }
        if (root.right != null) {
            findAllPath(root.right, paths, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
