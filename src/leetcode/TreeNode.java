package leetcode;


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       printBFSOrder(this, sb);
       return sb.toString();
    }

    void printPostorder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        // first recur on left subtree
        printPostorder(node.left, sb);

        // then recur on right subtree
        printPostorder(node.right, sb);

        // now deal with the node
        sb.append(node.val).append(",");
    }

    void printPreorder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val).append(",");
        printPostorder(node.left, sb);
        printPostorder(node.right, sb);
    }

    void printInOrder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        printPostorder(node.left, sb);
        sb.append(node.val).append(",");
        printPostorder(node.right, sb);
    }

    void printBFSOrder(TreeNode node, StringBuilder sb) {
        int height = height(node);
        for (int i = 1; i <= height; i++)
            printLevelOrder(node, i, sb);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        return lh > rh ? lh + 1 : rh + 1;
    }

    void printLevelOrder(TreeNode node, int level, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
            return;
        }
        if (level == 1)
            sb.append(node.val).append(",");
        else if (level > 1)
        {
            printLevelOrder(node.left, level-1, sb);
            printLevelOrder(node.right, level-1, sb);
        }

    }
}
