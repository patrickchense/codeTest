https://docs.google.com/document/d/1W5a51O1N6dJbpjzCyCqfApSauRx2BawIbnyK9iBA67E/edit
##二叉树
###地址
https://leetcode.com/problems/all-possible-full-binary-trees/description/ 


##0,01,0110 .. 表示的第n行，第k列的值
###地址
https://leetcode.com/problems/k-th-symbol-in-grammar/description/ 
###解法
####方法一
推理得到N row Kth symbol is generated from the N-1 row (K+1)%2th 位置决定  
然后得到
```$xslt
0 | odd (0) | 0
0 | even(1) | 1
1 | odd (0) | 1
1 | even(1) | 0
```
就是k的位置%2 和 之前位置的 0/1组合起来得到，当前的值，利用递归一句实现  
```$xslt
N==1?0:kthGrammar(N-1,(K+1)/2 ) ^ (K+1)%2;
```

####方法二
上面的有点难，更正常的推理是，每行2^n个，在每n/2的时候，左右是对称相反的，这样就可以把k归约到1，2位置，然后判断
```java
boolean same=true;  
        while(num>2){   
            if(K>num/2){   // 一半的位置，左右开始相反, 
                same=(!same); // 然后，就是减少k的位置到前半部分，然后取反, 最终一直到1,2两个位置吧
                K-=num/2;
            } 
            num=num/2;
        }
        if(K==1){  //这时候如果k在1 那么 same的话就是0， 反之 1
            if(same) return 0;
            else return 1;
        }
        else {
            if(same) return 1;
            else return 0;
        }
```



##0,1 位字符变换位置，使二进制最大
###地址
https://leetcode.com/problems/special-binary-string/description/
###解法
关键还在于找到规律
```$xslt
Split S into several special strings (as many as possible).
Special string starts with 1 and ends with 0. Recursion on the middle part.
Sort all special strings in lexicographically largest order.
Join and output all strings.
```




##1...n 得到所有可能的BST
###location:
https://leetcode.com/problems/unique-binary-search-trees-ii/description/ 
###solution
典型的递归，任意i为root，那么递归得到1..i-1的left 和 i+1 ...n 的right，然后组成root 加入到List中  
```java
List<TreeNode> left,right;
        for(int i=start;i<=end;i++)
        {
            left = genTrees(start, i-1);
            right = genTrees(i+1,end);
            
            for(TreeNode lnode: left)
            {
                for(TreeNode rnode: right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
```



