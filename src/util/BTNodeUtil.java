package util;

import java.util.*;

// import https://zhuanlan.zhihu.com/p/61445865
public class BTNodeUtil {

    public static int maxDeath(BTNode node){
        if(node==null){
            return 0;
        }
        int left = maxDeath(node.left);
        int right = maxDeath(node.right);
        return Math.max(left,right) + 1;
    }

    public static int getMinDepth(BTNode root){
        if(root == null){
            return 0;
        }
        return getMin(root);
    }

    public static int getMin(BTNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left == null&&root.right == null){
            return 1;
        }
        return Math.min(getMin(root.left),getMin(root.right)) + 1;
    }

    public static int numOfBTNode(BTNode root){
        if(root == null){
            return 0;

        }
        int left = numOfBTNode(root.left);
        int right = numOfBTNode(root.right);
        return left + right + 1;
    }

    public static int numsOfNoChildNode(BTNode root){
        if(root == null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return numsOfNoChildNode(root.left)+numsOfNoChildNode(root.right);
    }

    // kth level node count
    public static int numsOfkLevelBTNode(BTNode root,int k){
        if(root == null||k<1){
            return 0;
        }
        if(k==1){
            return 1;
        }
        int numsLeft = numsOfkLevelBTNode(root.left,k-1);
        int numsRight = numsOfkLevelBTNode(root.right,k-1);
        return numsLeft + numsRight;
    }

    // is balance bt or not
    public static boolean isBalanced(BTNode node){
        return maxDeath2(node)!=-1;
    }


    public static int maxDeath2(BTNode node){
        if(node == null){
            return 0;
        }
        int left = maxDeath2(node.left);
        int right = maxDeath2(node.right);
        if(left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    // is complete bt
    public static boolean isCompleteBTNode(BTNode root){
        if(root == null){
            return false;
        }
        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);
        boolean result = true;
        boolean hasNoChild = false;
        while(!queue.isEmpty()){
            BTNode current = queue.remove();
            if(hasNoChild){
                if(current.left!=null||current.right!=null){
                    result = false;
                    break;
                }
            }else{
                if(current.left!=null&&current.right!=null){
                    queue.add(current.left);
                    queue.add(current.right);
                }else if(current.left!=null&&current.right==null){
                    queue.add(current.left);
                    hasNoChild = true;

                }else if(current.left==null&&current.right!=null){
                    result = false;
                    break;
                }else{
                    hasNoChild = true;
                }
            }

        }
        return result;
    }

    // tree is equal?
    public static boolean isSameBTNode(BTNode t1,BTNode t2){
        if(t1==null&&t2==null){
            return true;
        }
        else if(t1==null||t2==null){
            return false;
        }
        if(t1.val != t2.val){
            return false;
        }
        boolean left = isSameBTNode(t1.left,t2.left);
        boolean right = isSameBTNode(t1.right,t2.right);
        return left&&right;
    }

    // mirror tree?
    public static boolean isMirror(BTNode t1,BTNode t2){
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        if(t1.val != t2.val){
            return false;
        }
        return isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);

    }

    // 两个bt最低公共祖先node
    public static BTNode getLastCommonParent(BTNode root,BTNode t1,BTNode t2){
        if(findNode(root.left,t1)){
            if(findNode(root.right,t2)){
                return root;
            }else{
                return getLastCommonParent(root.left,t1,t2);
            }
        }else{
            if(findNode(root.left,t2)){
                return root;
            }else{
                return getLastCommonParent(root.right,t1,t2);
            }
        }
    }
    // 查找节点node是否在当前 二叉树中
    public static boolean findNode(BTNode root,BTNode node){
        if(root == null || node == null){
            return false;
        }
        if(root == node){
            return true;
        }
        boolean found = findNode(root.left,node);
        if(!found){
            found = findNode(root.right,node);
        }
        return found;
    }

    // preOrder for
    public static List<Integer> preOrder(BTNode root){
        Stack<BTNode> stack = new Stack<BTNode>();
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        stack.push(root);
        while(!stack.empty()){
            BTNode node = stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }

        }
        return list;
    }

    // preOrer recursive
    public static ArrayList<Integer> preOrderReverse(BTNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        preOrder2(root,result);
        return result;

    }
    public static void preOrder2(BTNode root,ArrayList<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        preOrder2(root.left,result);
        preOrder2(root.right,result);
    }
    
    // inOrder
    public static List<Integer> inOrder(BTNode root){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<BTNode> stack = new Stack<BTNode>();
        BTNode current = root;
        while(current != null|| !stack.empty()){
            while(current != null){
                stack.add(current);
                current = current.left;
            }
            current = stack.peek();
            stack.pop();
            list.add(current.val);
            current = current.right;

        }
        return list;
    }

    public static List<Integer> postOrder(BTNode root){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        list.addAll(postOrder(root.left));
        list.addAll(postOrder(root.right));
        list.add(root.val);
        return list;
    }

    // build tree by preorder and inorder
    public static BTNode buildBTNode(int[] preorder,int[] inorder){
        if(preorder.length!=inorder.length){
            return null;
        }
        return myBuildTree(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
    }
    public static BTNode myBuildTree(int[] inorder,int instart,int inend,int[] preorder,int prestart,int preend){
        if(instart>inend){
            return null;
        }
        BTNode root = new BTNode(preorder[prestart]);
        int position = findPosition(inorder,instart,inend,preorder[prestart]);
        root.left = myBuildTree(inorder,instart,position-1,preorder,prestart+1,prestart+position-instart);
        root.right = myBuildTree(inorder,position+1,inend,preorder,position-inend+preend+1,preend);
        return root;
    }
    public static int findPosition(int[] arr,int start,int end,int key){
        int i;
        for(i = start;i<=end;i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    // insert node
    public static BTNode insertNode(BTNode root,BTNode node){
        if(root == node){
            return node;
        }
        BTNode tmp = new BTNode();
        tmp = root;
        BTNode last = null;
        while(tmp!=null){
            last = tmp;
            if(tmp.val>node.val){
                tmp = tmp.left;
            }else{
                tmp = tmp.right;
            }
        }
        if(last!=null){
            if(last.val>node.val){
                last.left = node;
            }else{
                last.right = node;
            }
        }
        return root;
    }
    
    // path sum to target
    public static  void findPath(BTNode root,int i){
        if(root == null){
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int currentSum = 0;
        findPath(root, i, stack, currentSum);

    }
    public static void findPath(BTNode r,int i,Stack<Integer> stack,int currentSum){
        currentSum+=r.val;
        stack.push(r.val);
        if(r.left==null&&r.right==null){
            if(currentSum==i){
                for(int path:stack){
                    System.out.println(path);
                }

            }
        }
        if(r.left!=null){
            findPath(r.left, i, stack, currentSum);
        }
        if(r.right!=null){
            findPath(r.right, i, stack, currentSum);
        }
        stack.pop();
    }

    // find all node between k1, k2
    public static List<Integer> result;
    public static List<Integer> searchRange(BTNode root,int k1,int k2){
        result = new ArrayList<Integer>();
        searchHelper(root,k1,k2);
        return result;
    }
    public static  void searchHelper(BTNode root,int k1,int k2){
        if(root == null){
            return;
        }
        if(root.val>k1){
            searchHelper(root.left,k1,k2);
        }
        if(root.val>=k1&&root.val<=k2){
            result.add(root.val);
        }
        if(root.val<k2){
            searchHelper(root.right,k1,k2);
        }
    }

    //level print
    public static List<List<Integer>> levelOrder(BTNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<BTNode> queue = new LinkedList<BTNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i = 0;i < size ;i++){
                BTNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    /*
    二叉树内两个节点的最长距离
二叉树中两个节点的最长距离可能有三种情况：
1.左子树的最大深度+右子树的最大深度为二叉树的最长距离
2.左子树中的最长距离即为二叉树的最长距离
3.右子树种的最长距离即为二叉树的最长距离
因此，递归求解即可
     */

    private static class Result{
        int maxDistance;
        int maxDepth;
        public Result() {
        }

        public Result(int maxDistance, int maxDepth) {
            this.maxDistance = maxDistance;
            this.maxDepth = maxDepth;
        }
    }
    int getMaxDistance(BTNode root){
        return getMaxDistanceResult(root).maxDistance;
    }
    Result getMaxDistanceResult(BTNode root){
        if(root == null){
            Result empty = new Result(0,-1);
            return empty;
        }
        Result lmd = getMaxDistanceResult(root.left);
        Result rmd = getMaxDistanceResult(root.right);
        Result result = new Result();
        result.maxDepth = Math.max(lmd.maxDepth,rmd.maxDepth) + 1;
        result.maxDistance = Math.max(lmd.maxDepth + rmd.maxDepth,Math.max(lmd.maxDistance,rmd.maxDistance));
        return result;
    }

    // 给出 n，问由 1...n 为节点组成的不同的二叉查找树有多少种？
    public static int numTrees(int n ){
        int[] counts = new int[n+2];
        counts[0] = 1;
        counts[1] = 1;
        for(int i = 2;i<=n;i++){
            for(int j = 0;j<i;j++){
                counts[i] += counts[j] * counts[i-j-1];
            }
        }
        return counts[n];
    }

    /*
    判断二叉树是否是合法的二叉查找树(BST)
一棵BST定义为：
节点的左子树中的值要严格小于该节点的值。
节点的右子树中的值要严格大于该节点的值。
左右子树也必须是二叉查找树。
一个节点的树也是二叉查找树。
     */
    public int lastVal = Integer.MAX_VALUE;
    public boolean firstNode = true;
    public boolean isValidBST(BTNode root) {
        // write your code here
        if(root==null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(!firstNode&&lastVal >= root.val){
            return false;
        }
        firstNode = false;
        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
