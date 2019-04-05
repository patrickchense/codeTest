package dailyproblem;

import java.util.*;

/*
Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

@Snapshot
@slidewindow
@solved
@review

暴力法，有没有更好的解法?

找到最少，就是有多少重叠的，最大的intersect就是同时需要的
 */
public class Daily20181025 {

    public static void main(String[] args) {
        System.out.println(minimunIntersect(new int[][] {
                {30, 75},
                {0, 50},
                {60, 150}
        }));

        Interval i1 = new Interval();
        i1.start = 30;
        i1.end = 75;
        Interval i2 = new Interval();
        i2.start = 0;
        i2.end = 50;
        Interval i3 = new Interval();
        i3.start = 60;
        i3.end = 150;
        System.out.println(minMeetingRooms(new Interval[]{i1, i2, i3}));
    }

    public static int minimunIntersect(int[][] arr) {
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i][0];
            int max = arr[i][1];
            int count = 1;
            for (int j = 0; j < arr.length; j++) {
                boolean isOverlap = false;
                if (arr[j][1] > min && arr[j][1] < max) {
                    max = arr[j][1];
                    isOverlap = true;
                }
                if (arr[j][0] < max && arr[j][0] > min){
                    min = arr[j][0];
                    isOverlap = true;
                }
                if (isOverlap) count++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;

    }

    static class Interval {
        int start;
        int end;
    }
    // 还是用queue
    // O(nlogn), 先排序, 每次队列里放的之前的最小的结束时间
    public static int minMeetingRooms(Interval[] intervals) {
        if(intervals==null||intervals.length==0){
            return 0;
        }

        Comparator<Interval> comp = Comparator.comparing((Interval i)->i.start);
        Arrays.sort(intervals, comp);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(intervals[0].end);
        int count = 1;
        for(int i=1; i<intervals.length; i++){
            int head = queue.peek();
            if(intervals[i].start>=head){
                queue.poll();
            }else{
                count++;
            }
            queue.offer(intervals[i].end);
        }

        return count;
    }
}
