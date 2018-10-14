https://docs.google.com/document/d/1YHDry8wTHlywhZh3dShcusdfRB2lUWPRw0d30m0tQbk/edit

##easy,  找字符大小写切换的全部结果， DFS
###location
https://leetcode.com/problems/letter-case-permutation/description/ 
###solution
就是，根据index, 一层层处理, 递归
```java
if (index == array.length) {
            res.add(new String(array));
            return;
        }
        if (!Character.isDigit(array[index])) {
            array[index] = Character.toLowerCase(array[index]);
            dfs(array, res, index + 1);
            array[index] = Character.toUpperCase(array[index]);
            dfs(array, res, index + 1);
        } else {
            dfs(array, res, index + 1);
        }
```


##nums 数组，不同组合的子数组， DFS， 
###location
https://leetcode.com/problems/subsets-ii/description/ 
###solution
也是递归, 注意duplicate的数字
```java
result.add(path);
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]) continue;
            List<Integer> nPath= new ArrayList<>(path);
            nPath.add(nums[i]);
            dfs(nums,i+1,nPath,result);
        }
```
通过new ArrayList(list) 来创建新的， 然后在下次递归的时候加入到res中


##数字和， 全部不同， DFS
###location
https://leetcode.com/problems/combination-sum-iii/description/
###solution
```java
        if(k == 0 && n == 0){
            res.add(new ArrayList<Integer>(cur));
            return;
        }else if(n > 0 && k > 0){
            for(int i = index; i<9; i++){
                if(i+1 > n) break;
                cur.add(i+1);
                dfs(res, cur, k -1 , n - i -1, i+1);
                cur.remove(cur.size() -1);
            }
        }
``` 
规定了个数和和，然后最重要的我认为是，在每次dfs后删除元素，才能够重复的加入不同的结果，最后保证这个res的干净， 还有就是所有的递归的变化，是在调用的时候来选择的


##数字字母转换组合， 利用电话拨号来表现， DFS
###location
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/ 
###solution
```java
if (index == digits.length()) {
        result.add(combination);
        return;
    }
    for (char c : pad[digits.charAt(index) - 48].toCharArray()) {
        combinations(digits, result, pad, combination + c, index + 1);
    }
```
原理，递归1层，然后就会组合二层的所有选项，返回在递归1层的下一个，在递归2层的所有，不同的递归就可以了
关键在于，把字母数字的对应起来，然后digits.charAt(index) - 48 可以把数字转成对应的字符数组，而且string可以不用清除，因为每次+都是创建新的


##数字组合， DFS,  k个数字， 1...n
###location
https://leetcode.com/problems/combinations/description/ 
###solution
典型DFS，关键在于，下次循环从大于当前循环的数字开始
```java
if (index == k)  {
            ress.add(new ArrayList<Integer>(res));  //用新的，否则清空
            return;
        }
        for (int i = start; i <= n; i++) {
            res.add(i);
            dfs(ress, res, n, k, i +1, index+1);   // i 是当前循环， 下次从i+1 开始，
            res.remove(res.size()-1);  //利用一个数组，每次删除
        }
```

##Parentheses
n个括号(brackets)的所有组合方式
###@inclass
###solution
understand backtracking, classic
其实就是DFS的recursion的一种应用

##BinaryWatch
n个LED亮，给出时间
###@inclass
###solution
关键在于表达时间的组合数组的递归和记录位置



##总结
###题型
目前遇见的backtracking的题目，类似"n个什么，按什么方式组合，所有的的组合结果"，然后一般都是两个状态，任意可以组合
###解决
都是用DFS的recursion，然后利用每次回溯的时候，之前已经产生的结果被清除的后，可以继续添加新的可能




