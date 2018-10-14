https://docs.google.com/document/d/1HQ3IH2Vw8M_8GTDGBQznA6z0LR_Ze-dRzrTXA0z7mL4/edit

##BST 实现
###location
https://leetcode.com/problems/binary-search/description/
###solution
最简单的，一个升序数组找target
```java
 while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid -1;
        }
        return -1;
```


##kth 系列
###kth smallest
####location
https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/ 
####solution
####最暴力
先打印完整的numslist，然后返回第k-1个
搜索，中序遍历，遍历左子树个数+1 == k 那么当前节点就是
```java
int count = countNodes(root.left);  //先找左边个数 当k == count+1 的时候 就说明当然节点是
        if (k <= count) {
            return kthSmallest(root.left, k);  // k 比count小， 继续找左边
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node， 找右边
        }
        
        return root.val;
   
计算count:
if (n == null) return 0;
return 1 + countNodes(n.left) + countNodes(n.right);
```     

####DFS的方式
关键在于，理解左节点为空的时候可以 k--,  当k == 0 的时候就是kth 最小
```java
if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
```        
深刻理解，BST，左边的都比当前节点小，右边的都比当前节点大

###kth smallest pairt distance
####location
https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/ 
####solution
计算i,j 之间distance的kth small，需要一个BST的观念的转变，常规的都是通过index(start, end)来搜索，而这里把start,end变成了最大最小间隔，然后计算真正start/end之间的小于k的间隔的数量，然后得到k的间隔
```java
核心:
while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(a, mid) < k) // 计算每次gap小于mid的数量, 如果这个数大于k，那么需要减小mid, hight= mid，在更小的范围查找，如果这个数小于k，那么扩大mid，直到mid==kth，这时候找的就是正确的
                low = mid + 1;
            else
                high = mid;
        }

//countPairs:  计算每次gap小于mid的数量
int n = a.length, res = 0;
        for (int i = 0; i < n; ++i) {
            int j = i;
            while (j < n && a[j] - a[i] <= mid) j++;
            res += j - i - 1; // 直到j 如果都小于mid, 那么数量是 j-i-1
        }
        return res;
```

###上面的kth 最小的再变种， 乘法表找最小kth
####location
https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/ 
####solution
唯一的区别是，在处理count的时候，不能for/while了，这样会超时
采用的方法是
```java
	for (int i = 1; i <= m; i++) {
	    int temp = Math.min(mid / i , n);  // 利用m * n <= mid => mid/m 大于1的所有值，就是count
	    count += temp;
	}
```



https://leetcode.com/problems/k-th-smallest-prime-fraction/description/ 


##kth类似问题的总结
###location
https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115819/Summary-of-solutions-for-problems-%22reducible%22-to-LeetCode-378 


##扭转的BST 
###location
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/ 
###solution
处理的关键在于理解一个现象
```java
if (nums[mid] < nums[end] || nums[mid] < nums[start]) { 表示右边已经排序了，左边没有
if (nums[mid] > nums[start] || nums[mid] > nums[end]) { 表示左边排序了，右边没有
```
如果start == mid == end, 只要start ++ 或者 end --





