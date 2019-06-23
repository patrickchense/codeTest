package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.


@solved
@binarytree
@BFS

自己解决了一种方式, 但是从速度和memory上都没有很好，看看如何optimize


 */
public class LT_116_RightNextPointer {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null) return null;
        List<Node> list = new ArrayList<>();
        list.add(root);
        boolean isBreak = false;
        while(!isBreak) {
            int len = list.size();
            for (int i = 0; i < len; i++) {
                if (i + 1 < len) {
                    list.get(i).next = list.get(i+1);
                }
                if (!isBreak && list.get(i).left == null) isBreak = true;
                if (!isBreak) {
                    list.add(list.get(i).left);
                    list.add(list.get(i).right);
                }
            }
            list = list.subList(len, list.size());
        }
        return root;
    }


    // MORE FASTER, USING QUEUE,
    public Node connect2(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node cur = q.poll();
                if(i!=size-1) cur.next = q.peek();
                else cur.next = null;
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
        }
        return root;
    }
}
