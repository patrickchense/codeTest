https://docs.google.com/document/d/1Q27QkRBOTNQXbBzkKVxV96_mcxnfEKQatonsJFpqw-o/edit

##DP hard:
```
动态规划
适用于，重叠子结构或最优子结构的问题，动态规划只能应用于有最优子结构的问题。最优子结构的意思是局部最优解能决定全局最优解（对有些问题这个要求并不能完全满足，故有时需要引入一定的近似）。简单地说，问题能够分解成子问题来解决

最优子结构性质。如果问题的最优解所包含的子问题的解也是最优的，我们就称该问题具有最优子结构性质（即满足最优化原理）。最优子结构性质为动态规划算法解决问题提供了重要线索。
无后效性。即子问题的解一旦确定，就不再改变，不受在这之后、包含它的更大的问题的求解决策影响。
子问题重叠性质。子问题重叠性质是指在用递归算法自顶向下对问题进行求解时，每次产生的子问题并不总是新问题，有些子问题会被重复计算多次。动态规划算法正是利用了这种子问题的重叠性质，对每一个子问题只计算一次，然后将其计算结果保存在一个表格中，当再次需要计算已经计算过的子问题时，只是在表格中简单地查看一下结果，从而获得较高的效率
动态规划的本质，是对问题状态的定义和状态转移方程的定义
在对状态和状态转移方程的定义过程中，满足“最优子结构”是一个隐含的条件（否则根本定义不出来）。对状态和“最优子结构”的关系的进一步解释
每个阶段只有一个状态->递推；
每个阶段的最优状态都是由上一个阶段的最优状态得到的->贪心；
每个阶段的最优状态是由之前所有阶段的状态的组合得到的->搜索；
每个阶段的最优状态可以从之前某个阶段的某个或某些状态直接得到而不管之前这个状态是如何得到的->动态规划。
每个阶段的最优状态可以从之前某个阶段的某个或某些状态直接得到, 这个性质叫做最优子结构；
而不管之前这个状态是如何得到的, 这个性质叫做无后效性。
```

##典型问题，最长公共子列
```
function LCSLength(X[1..m], Y[1..n])
    C = array(0..m, 0..n)
    for i := 0..m
       C[i,0] = 0
    for j := 0..n
       C[0,j] = 0
    for i := 1..m
        for j := 1..n
            if X[i] = Y[j]
                C[i,j] := C[i-1,j-1] + 1
            else
                C[i,j] := max(C[i,j-1], C[i-1,j])
    return C[m,n]
```

##类型
我们将动态规划的常见类型分为如下几种：
* 矩阵型
* 序列型
* 双序列型
* 划分型
* 区间型
* 背包型
* 状态压缩型
* 树型
```
矩阵，序列，双序列，经常面试出现， 划分，区间，背包偶尔出现，状态压缩，树形基本不出现
每种类型的特点
矩阵： https://www.lintcode.com/problem/unique-paths/description
使用坐标作为状态，如f[i][j], 这个位置，一共有多少方案。状态转移，考虑从哪里走到f[i][j]
序列：一般告诉你一个序列，
双序列：一般告诉你两个序列或两个字符串
要总结所有遇到的DP问题，分类，总结他们的状态方式方法和状态转移方程的类似之处
适用DP的题目：
问法：
求最大最小值
问可行不可行
求方案总数
如果是求出所有的方案和结果，肯定不是DP
步骤：
状态是什么
状态转移方程是什么
状态初始值是什么
问题最后求的答案是什么
```

##如何优化DP：
* 通过变换状态优化
* 通过决策单调优化， 一般只适用于划分型
* 优化DP空间:
* 用滚动数组优化
比如，状态转移方程: f[i][j] = f[i-1][j]+f[i][j-1] 与i-2无关了, 那么i-2可以重复利用，就对i用2取模, f[i%2][j]=f[(i-1)%2][j]+f[i%2][j-1]

###非常好的教程 https://blog.csdn.net/mmc2015/article/details/73558346 


##Egg Drop
###	https://leetcode.com/problems/super-egg-drop/description/
### 解法, 
* DP 二分的,  O(K * NlogN), Space O(K*N)
* DP 最优判断， 没理解呢
* 纯数学,  也没理解


##括号匹配, 最长匹配
###https://leetcode.com/problems/longest-valid-parentheses/description/
###stack 解法
自己解了大半，一个关键点没想通，缺点，需要O(n) space
这种括号匹配的stack解法，总是在(的时候push，)的时候pop，然后把中间的计算结果push，然后比较peak的值在push，最后就是最好的结果
###DP解法 

##回文最长,(字符串操作), 二维数组存储dp中间结果
###https://leetcode.com/problems/longest-palindromic-substring/description/
###更快的解法，是
 ```java
 if(isPalindrome(ca, i - max - 1, i)) {
            rs = i - max - 1; re = i;
            max += 2;
        } else if(isPalindrome(ca, i - max, i)) {
            rs = i - max; re = i;
            max += 1;
        }
每次记录max, 然后下次遍历从i-max-1 开始
```

##多个数字和（bit位记录状态）配合hashmap
###https://leetcode.com/problems/can-i-win/description/ 


###https://leetcode.com/problems/coin-change/description/ 

##正则匹配，DP问题，关键在于保存二维数组
###https://www.lintcode.com/problem/regular-expression-matching/description

##字符串 经典回文计算, 矩阵型？？？
###https://leetcode.com/problems/palindromic-substrings/description/ 
```
二维数组保存状态，DP[ i ][ j ] 存储 index 从 i ~ j 是不是回文
状态转移公式: dp[i]=dp[i-1]+tmpNum
```
###第一种解法，判断是不是回文，是tmpNum就是加上len, 否则+1
###第二种数学思路：
```
思路是 考虑不同的回文中心，然后从中心扩大，求以某个中心来获得的回文个数。
有两种情况：子串 s[ i - j , ...,  i + j ] 中, i 是回文中心（这是奇数串的情形）。子串 s[ i - 1 - j , ...,  i + j ] 中，( i - 1 , i ) 是回文中心（这是偶数串的情形）
 第三种DP：
第一种其实不好，因为回文判断的时候做了很多重复计算，应该用二维数组来保存状态
DP[i][j] = 子字符串[i, j]是否是回文串就行了
i从n-1往0遍历，j从i往n-1遍历，然后我们看s[i]和s[j]是否相等
有了s[i]和s[j]相等这个条件后，i和j的位置关系很重要，如果i和j相等了，那么dp[i][j]肯定是true；如果i和j是相邻的，那么dp[i][j]也是true；如果i和j中间只有一个字符，那么dp[i][j]还是true；如果中间有多余一个字符存在，那么我们需要看dp[i+1][j-1]是否为true，若为true，那么dp[i][j]就是true。赋值dp[i][j]后，如果其为true，结果res自增1
if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])){ 
                    dp[i][j] = true;                   
                    res++;               
                }
```
回文问题，一般都是通过2指针或者DP来解决！！！！

##最长子串回文，失败
###https://leetcode.com/problems/longest-palindromic-subsequence/description/ 
```
找不到状态转移方程
差点就找到了，画图的时候判断要更仔细，画图有错
dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
Initialization: dp[i][i] = 1
```

##回文3
###https://leetcode.com/problems/palindrome-partitioning-ii/description/
```最小cut，分割s
状态: cut[i]
cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome
If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i]
难点在于需要有个array 保存cut，而矩阵只是保存状态
          if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                pal[j][i] = true;  
                min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
            }
```

##回文4
###https://leetcode.com/problems/count-different-palindromic-subsequences/description/


##例题4:最长递增子序列:  d[i] = max{ d[j] | j < i && a[j] < a[i] } + 1
一个状态演变到另一个状态，往往是通过“决策”来进行的。有了“决策”，就会有状态转移。而
无后效性，就是一旦某个状态确定后，它之前的状态无法对它之后的状态产生“效应”

##例题5:
```
老王想在未来的n年内每年都持有电脑，m(y, z)表示第y年到第z年的电脑维护费用，其中y的范围为[1, n]，z的范围为[y, n]，c表示买一台新的电脑的固定费用。 给定矩阵m，固定费用c，求在未来n年都有电脑的最少花费
二元组(a, b)，其中 a < b，它表示了第a年和第b年都要换电脑（第a年和第b年之间不再换电脑）
```
```
d[i]表示在第i年买了一台电脑的最小花费, 如果上一次更换电脑的时间在第j年，那么第j年更换电脑到第i年之前的总开销就是c + m(j, i-1)
d[i] = min{ d[j] + m(j, i-1) |  1 <=  j < i  } + c
这里的d[i]并不是最后问题的解，因为它漏算了第i年到第n年的维护费用，所以最后问题的答案
ans  = min{ d[i] + m(i, n)  | 1 <= i < n }
我们发现两个方程看起来很类似，其实是可以合并的，我们可以假设第n+1年必须换电脑，并且第n+1年换电脑的费用为0，那么整个阶段的状态转移方程就是
d[i] = min{ d[j] + m(j, i-1) | 1 <= j < i } + w(i)    其中w(i) = (i==n+1)?0:c;

```


##经典模型:
###线性
###最长子序列
```
有n（n <= 50）个小朋友在桥的这边，现在他们需要过桥，但是由于桥很窄，每次只允许不大于两人通过，他们只有一个手电筒，所以每次过桥的两个人需要把手电筒带回来，i号小朋友过桥的时间为T[i]，两个人过桥的总时间为二者中时间长者。问所有小朋友过桥的总时间最短是多少

某次的过桥总时间opt[i] 
只有1个人
opt[i] = opt[i-1] + a[1] + a[i]
有2个人
opt[i] = opt[i-2] + a[1] + a[i] + 2*a[2] 
总结: opt[i] = min{opt[i-1] + a[1] + a[i] , opt[i-2] + a[1] + a[i] + 2*a[2] }

区间
就是矩阵, d[i][j]形式,表示区间[i, j]上的最优解，然后通过状态转移计算出[i+1, j]或者[i, j+1]上的最优解，逐步扩大区间的范围，最终求得[1, len]的最优解

回味5：
给定一个长度为n（n <= 1000）的字符串A，求插入最少多少个字符使得它变成一个回文串
d[i][j]来表示A[i...j]这个子串变成回文串所需要添加的最少的字符数
A[i] == A[j] d[i][j] = d[i+1][j-1] 
A[i] != A[j] 两种决策
	在A[j]后面添加一个字符A[i]
	在A[i]前面添加一个字符A[j]
两种决策列出状态转移方程为
 d[i][j] = min{ d[i+1][j], d[i][j-1] } + 1;                (每次状态转移，区间长度增加1)
 空间复杂度O(n^2)，时间复杂度O(n^2)

动态规划算法三要素（摘自黑书，总结的很好，很有概括性）：
              ①所有不同的子问题组成的表
              ②解决问题的依赖关系可以看成是一个图
              ③填充子问题的顺序（即对②的图进行拓扑排序，填充的过程称为状态转移）
则如果子问题的数目为O(nt)，每个子问题需要用到O(ne)个子问题的结果，那么我们称它为tD/eD的问题，于是可以总结出四类常用的动态规划方程
（下面会把opt作为取最优值的函数（一般取min或max）, w(j, i)为一个实函数，其它变量都可以在常数时间计算出来)
1D/1D
d[i] = opt{ d[j] + w(j, i) | 0 <= i < j } (1 <= i <= n)
例题4, 例题5 都是
2D/0D
 d[i][j] = opt{ d[i-1][j] + xi, d[i][j-1] + yj, d[i-1][j-1] + zij }     (1<= i, j <= n)
最典型的见最长公共子序列问题

2D/1D
 d[i][j] = w(i, j) + opt{ d[i][k-1] + d[k][j] }, (1 <= i < j <= n)  区间模型常用
另一种:
 d[i][j] = opt{ d[i-1][k] + w(i, j, k) | k < j }    (1<= i <= n, 1 <= j <= m)
2D/2D
d[i][j] = opt{ d[i'][j'] + w(i', j', i, j) |  0 <= i' < i, 0 <= j' < j}
常见于二维的迷宫问题，由于复杂度比较大，所以一般配合数据结构优化，如线段树、树状数组

tD/eD 的动态规划问题，在不经过任何优化的情况下，可以粗略得到一个时间复杂度是O(nt+e)，空间复杂度是O(nt)
```


##动态规划和数据结构结合的常用优化
###滚动数组
	回文那题
	d[i][j]理解成一个二维的矩阵，i表示行，j表示列，那么第i行的结果只取决于第i+1和第i行的情况，对于第i+2行它表示并不关心，那么我们只要用一个d[2][N]的数组就能保存状态了，其中d[0][N]为奇数行的状态值，d[1][N]为偶数行的状态值，当前需要计算的状态行数为奇数时，会利用到d[1][N]的部分状态，奇数行计算完毕，d[1][N]整行状态都没用了，可以用于下一行状态的保存，类似“传送带”的滚动来循环利用空间资源，美其名曰 - 滚动数组。
       这是个2D/0D问题，理论的空间复杂度是O(n2)，利用滚动数组可以将空间降掉一维，变成O(n)。
       背包问题的几个状态转移方程同样可以用滚动数组进行空间优化

###最长单调子序列
对于例题4
d[i] = max{ d[j] | j < i && a[j] < a[i] } + 1;
采用二分枚举，维护一个值 (这里的值指的是a[i]) 递增的决策序列，不断扩大决策序列，最后决策的数目就是最长递增子序列的长度。具体做法是：
       枚举i，如果a[i]比决策序列中最大的元素的值还大，则将i插入到决策序列的尾部；否则二分枚举决策序列，找出其中值最小的一个决策k，并且满足a[k] > a[i]，然后用决策i替换决策k
这是个1D/1D问题，理论的时间复杂度是O(n2)，利用单调性优化后可以将复杂度将至O(nlogn)

###矩阵优化


###斜率优化

##数组，连接最长，升序
###https://leetcode.com/problems/maximum-length-of-pair-chain/description/
###solution
貌似DP矩阵，但是可以用sort(O(nlogn))，然后就不用DP解决，很快


##序列
###https://leetcode.com/problems/integer-break/description/ 
###solution
d[i] = 最大乘积
d[i] = Math.max(j*(i-j),Math.max(j*dp[i-j],max)) // 重点是这里的j从 (i+1)/2 开始往下遍历

##序列
###https://leetcode.com/problems/2-keys-keyboard/description/ 
```
copy 字符串 最小次数
i %j ==0
if (j % 2 != 0 && (i / j) % 2 == 0) {
 d[i] = Math.min(d[i/j] + j, d[j] + (i/j));
}
else {
d[i] = d[j] + (i/j) ;
}
else 
d[i] = i;  //子数
```

##矩阵
###https://leetcode.com/problems/predict-the-winner/description/ 
###solution
```
数组，轮流挑选，最大和
状态: d[i][j]
dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
优化，用滚动数组一维来处理
j = i+ 1 .. n-1
dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
```

##序列, 数学，推理
###https://leetcode.com/problems/count-numbers-with-unique-digits/description/ 
```
没有重复数字的数量， 10^n 
然后当n>10的时候，将不可能有不重复数字的数
uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
```

##序列
###https://leetcode.com/problems/is-subsequence/description/ 
###子序列匹配
```
if (s[i] == t[d[i-1]]) d[i] = d[i-1] +1  else d[i] = d[i-1] 
```

##序列 target sum
###https://leetcode.com/problems/target-sum/description/
###solution
```数组数字，每次+/-, 最终的结果==target
高级用法，滚动更新，然后长度不再是n, 而是 2*total + 1 (total = Sum(an))
解法2， 理解 2* Sum(p) = (target + sum) >>>1， 然后就变成了部分和
dp = new int[s + 1]  // s = (target + sum) >>>1
dp[i] += dp[i - n]  
```


##序列, BST 的总数
###https://leetcode.com/problems/unique-binary-search-trees/description/ 
###solution
```
通过推导得到公式: 每个n作为root
G(n) = F(1, n) + F(2, n) + ... + F(n, n)
F(i, n) = G(n-i)*G(i-1) 
G(n) = G(0) * G(n-1) + G(1) * G(n-2) .... + G(n-1) * G(0) 
        for (int i = 1; i <= n; i++) {
            for(int j=1; j<=i; ++j) {
    		    d[i] += d[j-1] * d[i-j];
    	    }
        }
通过一个序列d[n+1] 
```

##序列, SUM 求和的总数
###https://leetcode.com/problems/combination-sum-iv/description/ 
###solution
```
序列的大小 d[target] 
d[i] += i - nums[j] < 0 ? 0 : d[i - nums[j]];
```

##矩阵
###https://leetcode.com/problems/minimum-path-sum/description/ 
###solution
```
二维数组，求和最小，最上左到最右下
d[m-1, n-1] = min{d[m-2,n-1], d[m-1, n-2]} + grid[m-1][n-1]
```

##矩阵
###https://leetcode.com/problems/largest-sum-of-averages/description/ 
###solution
```
计算，数组切分K个sub之后最大平均值，还是很复杂的
状态f[i][j], 第i个元素，第j刀的时候最平均值
 f[i][j] = Max{f[p][j-1] + (A[p+1] + ... + A[i])/(i-p)} p = 0....i-1
实现的时候还是很复杂的，因为有3个元素，必定有着3重循环，而且使用了额外的数组来保存a[0]...a[i]的sum值
        for (int i = 1; i <= l; i++) {
            s[i] = s[i - 1] + A[i - 1];
            f[i - 1][1] =  s[i] / i;
        }
        for (int j = 2; j <= K; j++) {
            for (int i = 0; i < l; i++) {
                double max = Double.MIN_VALUE;
                for (int p = 0; p < i; p++) {
                    double sum = f[p][j - 1] + (s[i + 1] - s[p + 1]) / (i - p);
                    max = Double.max(sum, max);
                }
                f[i][j] = max;
            }
        }
        return f[l - 1][K];
```

##矩阵 (hard)
###https://leetcode.com/problems/k-inverse-pairs-array/description/ 
###solution
```
n 个数字， k个反向组合( i < j, a[i]>a[j])
状态: d[i][j],  i = 数字个数， j是需要的k个组合，结果可有的数量
方程: dp[n][k+1] = dp[n][k]+dp[n-1][k+1]-dp[n-1][k+1-n]
解释，
n放在最后，d[n][k] = d[n-1][k]
n放在倒数第二, d[n][k] = 1 + d[n-1][k-1]
….  n放在第一, d[n][k] = n-1 + d[n-1][k-n+1] 
dp[n][k] = dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]+dp[n-1][k-n+1]
dp[n][k+1] = dp[n-1][k+1]+dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]
第二个和第一个，结合得到上面的方程
if (k > n*(n-1)/2 || k < 0) return 0;
        if (k == 0 || k == n*(n-1)/2) return 1;
        long[][] dp = new long[n+1][k+1];
        dp[2][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(k, i*(i-1)/2); j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
                if (j >= i) dp[i][j] -= dp[i-1][j-i];
                dp[i][j] = (dp[i][j]+mod) % mod;
            }
        }
```

##连续子数组和
###https://leetcode.com/problems/continuous-subarray-sum/description/ 
