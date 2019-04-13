package daily2019;

import java.util.*;

/*
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Intervals can "touch", such as [0, 1] and [1, 2], but they won't be considered overlapping.

For example, given the intervals (7, 9), (2, 4), (5, 8), return 1 as the last interval can be removed and the first two won't overlap.

The intervals are not necessarily sorted in any order.

@Stripe
@easy
@array
@interval
@20min
@solved
   用了最笨的办法吧, O(n),  O(n^2) 时间

更好的办法？
https://leetcode.com/problems/non-overlapping-intervals/

 */
public class D20190412 {

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{7,9});
        list.add(new int[]{2,4});
        list.add(new int[]{5,8});
        System.out.println(countOverlap(list));
    }

    // 找到那个interact 最多的删除，然后所有没有交集就行
    public static int countOverlap(List<int[]> intervals) {
        int res = 0;
        Map<Integer, String> maps = new HashMap<>();
        int[] counts = new int[intervals.size()];
        int max_i = 0;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < intervals.size(); i++) {
            String c = "";
            int start = intervals.get(i)[0];
            int end = intervals.get(i)[1];
            int count = 0;
            for (int j = 0; j < intervals.size(); j++) {
                int start_j = intervals.get(j)[0];
                int end_j = intervals.get(j)[1];
                if ((start_j > start && start_j < end) || (end_j < end && end_j > start)) {
                    c += j + ";";
                    count++;
                }
            }
            maps.put(i, c);
            counts[i] = count;
            if (count > max) {
                max_i = i;
                max = count;
            }
            sum += count;
        }
        // 找到max 一个个删
        if (max == 0) return 0;
        while(true) {
            String map = maps.get(max_i);
            String[] indexes = map.substring(0, map.length() - 1).split(";");
            // 处理
            sum -= max;
            counts[max_i] = 0;
            for (String index : indexes) {
                counts[Integer.valueOf(index)]--;
                sum --;
            }
            res ++;
            if (sum ==0) break;
            // 找到下一个
            max = -1;
            max_i = -1;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > max) {
                    max_i = i;
                    max = counts[i];
                }
            }
        }
        return res;
    }

    // O(nlogn) 排序
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length <= 1){
            return 0;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int removedCnt = 0;
        Interval comp = intervals[0];
        for(int i = 1; i < intervals.length; ++i) {
            Interval cur = intervals[i];
            if (cur.start < comp.end) {
                if (cur.end < comp.end){
                    comp = cur;
                }

                ++removedCnt;
            }
            else{
                comp = cur;
            }
        }

        return removedCnt;
    }

    public int eraseOverlapIntervals1(Interval[] intervals)
    {
        int count = 0;
        int lastEnd = Integer.MIN_VALUE;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));

        for(Interval curInterval : intervals)
        {
            if(lastEnd <= curInterval.start)
            {
                lastEnd = curInterval.end;
            }
            else
            {
                lastEnd = Math.min(lastEnd, curInterval.end);
                count++;
            }
        }
        return count;
    }
}
