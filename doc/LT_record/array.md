https://docs.google.com/document/d/1EYk9i50ByN4ZDIesfWJ3s4iCxsR61x9KMPvahifc55I/edit

##Kth sum的问题
###地址
https://leetcode.com/problems/4sum/description/ 
###解法
都可以通过，最终转变为2sum的问题来处理，时间复杂度为O(n^(k-1))
2 sum
```java
int i = index, j = len - 1;
            	while(i < j) {
                    //find a pair
            	    if(target - nums[i] == nums[j]) {
            	    	List<Integer> temp = new ArrayList<>();
                    	temp.add(nums[i]);
                    	temp.add(target-nums[i]);
                        res.add(temp);
                        //skip duplication  有没有重复很重要，要问清楚
                        while(i<j && nums[i]==nums[i+1]) i++;
                        while(i<j && nums[j-1]==nums[j]) j--;
                        i++;
                        j--;
                    //move left bound
            	    } else if (target - nums[i] > nums[j]) {
            	        i++;
                    //move right bound
            	    } else {
            	        j--;
            	    }
            	}
```

##kth的处理
```java
for (int i = index; i < len - k + 1; i++) {
                    //use current number to reduce ksum into k-1sum
                    ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1); //递归
                    if(temp != null){
                        //add previous results
                        for (List<Integer> t : temp) {
                            t.add(0, nums[i]);
                        }
                        res.addAll(temp);
                    }
                    while (i < len-1 && nums[i] == nums[i+1]) {
                        //skip duplicated numbers
                        i++;
                    }
                }
```



##rotated 2D array 旋转2维数组
###地址
https://leetcode.com/problems/rotate-image/description/ 
###解法
关键在于找到转换交换表达式
```java
B[i][j]=A[n-j][i]
         B[n-j][i]=A[n-i][n-j]
         B[n-i][n-j]=A[j][n-i]
         B[j][n-i]=A[i][j]
```
同时遍历的时候，只遍历一半i, 同时 j < m -i
```java
 for (int i = 0; i <= m / 2; i++) {
          for (int j = i; j < m - i; j++) {
```



