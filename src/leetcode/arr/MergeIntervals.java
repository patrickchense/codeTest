package leetcode.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
leet code 56
https://leetcode.com/problems/merge-intervals/description/
@done

solution:
using sort(define compare)

others:
?

related
TODO
https://leetcode.com/problems/insert-interval/
TODO
https://leetcode.com/problems/range-module/description/
TODO
https://leetcode.com/problems/meeting-rooms-ii (can't see)
TODO
https://leetcode.com/problems/employee-free-time (can't see)
TODO
https://leetcode.com/problems/teemo-attacking/description/

 */
public class MergeIntervals {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (null == intervals || intervals.size() == 0) return intervals;
        //sort
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });
        List<Interval> res = new ArrayList<>();
        int j = 0;
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= res.get(j).end) {
                if (intervals.get(i).end <= res.get(j).end) continue;
                else {
                    res.get(j).end = intervals.get(i).end;
                }
            } else {
                j++;
                res.add(intervals.get(i));
            }
        }
        return res;
    }
}
