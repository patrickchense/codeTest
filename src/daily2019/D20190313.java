package daily2019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Given a tree where each edge has a weight, compute the length of the longest path in the tree.

For example, given the following tree:

   a
  /|\
 b c d
    / \
   e   f
  / \
 g   h
and the weights: a-b: 3, a-c: 5, a-d: 8, d-e: 2, d-f: 4, e-g: 1, e-h: 1, the longest path would be c -> a -> d -> f, with a length of 17.

The path does not have to pass through the root, and each node can have any amount of children.

@Uber
@solved

 */
public class D20190313 {

    static class TreeNode {
        TreeNode[] nodes;
        int[] weights;
    }

    public static void main(String[] args) {
        TreeNode h = new TreeNode();
        TreeNode g = new TreeNode();
        TreeNode e = new TreeNode();
        e.nodes = new TreeNode[]{g, h};
        e.weights = new int[]{1, 1};
        TreeNode f = new TreeNode();
        TreeNode d = new TreeNode();
        d.nodes = new TreeNode[]{e, f};
        d.weights = new int[]{2, 4};
        TreeNode c = new TreeNode();
        TreeNode b = new TreeNode();
        TreeNode a = new TreeNode();
        a.nodes = new TreeNode[]{b, c, d};
        a.weights = new int[]{3, 5, 8};

        System.out.println(longestPath(a));
    }

    /*
    1. find all the path
    2. max(2path) is the biggest, can't share
        从root开始，取max，放到list，list排序

        O(nlogn)
     */
    public static int longestPath(TreeNode root) {
        List<Integer> weights = new ArrayList<>();
        for (int i = 0; i < root.nodes.length; i++) {
            weights.add(findAllWeights(root.nodes[i], weights, root.weights[i]));
        }
        weights.sort(Comparator.comparingInt(a -> a));
        return weights.get(weights.size() - 2) + weights.get(weights.size() - 1);
    }

    private static int findAllWeights(TreeNode root, List<Integer> weights, int cur) {
        if (root == null || root.nodes == null || root.nodes.length == 0) {
            return cur;
        }
        int max = 0;
        for (int i = 0; i < root.nodes.length; i++) {
            max = Math.max(findAllWeights(root.nodes[i], weights, cur + root.weights[i]), max);
        }
        return max;
    }
}
