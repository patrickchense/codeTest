https://docs.google.com/document/d/1YLFFyR-xlDdzm1I5l3vRVKT-73nQ1Ont4tgBL-bMfw0/edit

##最深的最左的节点值
###location
https://leetcode.com/problems/find-bottom-left-tree-value/description/
###解法
经典BFS 
利用了Queue，先进先出的特点，然后遍历的时候先右后左，保证最后出队列的一定是一个最左的，最低的
```java
queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
```

##每层最大值
###location https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/ 
###solution
也是经典的BFS，遍历每行，取最大值，然后便利下一行
然后和上面一题一样利用了一个queue(linkedList)来实现遍历节点，删除节点


##数组转二叉树1
###根据中序和后序遍历的数字串来构成tree
####location
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/ 
####solution
特点： post的最后一个是root, 倒数第二个root右子数节点，左子树的节点是post.length-1  - (inorder.length-1 - i  + 1)  // i 是root的再inorder中的位置
根据root，找到inorder中的root，然后可以分别遍历右子数和左子树，然后递归左右子树即可
```java
if (start > end || idx < 0) { return null; }
    TreeNode root = new TreeNode(post[idx]);
    int i;
    for (i = start; i <= end; i++) {
      if (in[i] == root.val) {
        break;
      }
    }
    root.right = helper(post, idx - 1, in, i + 1, end);
    root.left = helper(post, idx - (end - i  + 1), in, start, i - 1);
    return root;  
```

###数组转二叉树2 (升序数组), highest balance BST
####location
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/ 


