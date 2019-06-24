package leetcode.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.

Example:

Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).

@solved
@array
@range
@greedy
@optimize

我自己的解法非常慢，而且空间消耗大

 */
public class LT_452_MinimumNumber {
    //self，find intersections and mim it, return uniq size of intersections
    public int findMinArrowShots(int[][] points) {
        List<Integer[]> intersecs = new ArrayList<>();
        Arrays.sort(points, Comparator.comparingInt(a -> a[1])); // if not sort, will cause problems
        for (int[] p : points) {
            boolean isMatch = false;
            int i = 0;
            for (;i < intersecs.size(); i++) {
                if (p[1] <= intersecs.get(i)[1] && p[1] >= intersecs.get(i)[0]) {
                    isMatch = true;
                    break;
                }
                else if (p[0] >= intersecs.get(i)[0] && p[0] <= intersecs.get(i)[1]) {
                    isMatch = true;
                    break;
                }
                else if (p[0] <= intersecs.get(i)[0] && p[1] >= intersecs.get(i)[1]) {
                    isMatch = true;
                    break;
                }
            }
            if (isMatch) {
                // handle inter change
                Integer[] inter = intersecs.get(i);
                if (p[1] <= intersecs.get(i)[1] && p[1] >= intersecs.get(i)[0]) {
                    inter[1] = p[1];
                }
                if (p[0] >= intersecs.get(i)[0] && p[0] <= intersecs.get(i)[1]) {
                    inter[0] = p[0];
                }
                intersecs.set(i, inter);
                System.out.println("match=" + Arrays.toString(inter));
            }
            else {
                Integer[] inter = new Integer[]{p[0], p[1]};
                intersecs.add(inter);
                System.out.println(Arrays.toString(inter));
            }
        }

        return intersecs.size();
    }

    // greedy, 好一点，空间，但是没有很好
    public int findMinArrowShots2(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int s = 0;
        int c = 0;
        while(s < points.length)
        {
            c++;
            int e = points[s][1];
            while(points[s][0] <= e)
            {
                s++;
                if (s < points.length)
                {
                    e = points[s][1] < e ? points[s][1] : e;
                }
                else
                {
                    break;
                }
            }
        }

        return c;
    }

    // faster, because using the comparator instead of Comparator.comparingInt, I don't know why?
    // 按end排列，比按start排序更快，只有一个for，上面的greedy, while中有while
    public int findMinArrowShots3(int[][] points) {
        int n= points.length;
        if(n<1) return 0;
        Arrays.sort(points,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b)
            {
                return a[1]-b[1];
            }
        });

        int ans=1,currEnd=points[0][1];
        for(int i=1;i<n;i++)
        {
            if(points[i][0]<=currEnd)
                continue;
            else
            {
                ans++;
                currEnd=points[i][1];
            }
        }
        return ans;
    }
}
