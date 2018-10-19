package leetcode.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
leetcode 57
@hard
https://leetcode.com/problems/insert-interval/description/

solution
 List op, logical

 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) return Arrays.asList(newInterval);

        List<Interval> ans = new ArrayList<>();

        //step 1: add intervals before newInterval
        int index = 0;
        while (index < intervals.size() && newInterval.start > intervals.get(index).end) {
            ans.add(intervals.get(index++));
        }
        //we are now at a interval who might be :
        //1. overlapped with newInterval,
        //     [inS, newS, inE, (newE)] or  [newS, inS, inE] (newE could be any where after newS and in S)
        //2. non overlap
        //     [newS, newE, inS, inE]
        /**
         *   in 1st case, we add newInterval and merge its starting point as min one
         *   2nd case, we add newInterval. But it could be included in this step
         */
        Interval insert = new Interval(newInterval.start, newInterval.end);
        ans.add(insert);
        if (index >= 0 && index < intervals.size()) {
            insert.start = Math.min(insert.start, intervals.get(index).start);
        }

        //step 2: find the first non overlap interval
        while (index < intervals.size() && intervals.get(index).start <= insert.end) {
            index++;
        }
        //step 3: merge last overlapped interval by ending point
        if (index - 1 >= 0 && index - 1 < intervals.size()) {
            insert.end = Math.max(insert.end, intervals.get(index - 1).end);
        }

        //step 4: add others
        while (index < intervals.size()) {
            ans.add(intervals.get(index++));
        }

        return ans;
    }
}
