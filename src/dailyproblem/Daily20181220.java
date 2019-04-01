package dailyproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Given a list of possibly overlapping intervals, return a new list of intervals where all overlapping intervals have been merged.

The input list is not necessarily ordered in any way.

For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].

@snapshot
@solved
@range
@array

 */
public class Daily20181220 {

    public static List<List<Integer>> overlapping(List<List<Integer>> intervals) {
        List<List<Integer>> results = new ArrayList<>();
        //sort by index 0
        intervals.sort(Comparator.comparingInt(o -> o.get(0)));
        results.add(intervals.get(0));
        int len = 1;
        for (int i = 1; i < intervals.size(); i++) {
            List<Integer> tmp = intervals.get(i);
            if (tmp.get(0) > results.get(len - 1).get(1)) {
                results.add(tmp);
                len ++;
            } else {
                if (tmp.get(1) > results.get(len - 1).get(1)) {
                    results.get(len - 1).remove(1);
                    results.get(len - 1).add(tmp.get(1));
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<Integer> tmp1 = Stream.of(1, 3).collect(Collectors.toList());
        List<Integer> tmp2 = Stream.of(5, 8).collect(Collectors.toList());
        List<Integer> tmp3 = Stream.of(4, 10).collect(Collectors.toList());
        List<Integer> tmp4 = Stream.of(20, 25).collect(Collectors.toList());
        List<List<Integer>> tmp = Stream.of(tmp1, tmp2, tmp3, tmp4).collect(Collectors.toList());
        List<List<Integer>> res = overlapping(tmp);
        System.out.println(res);
        List<Integer> tmp5 = Stream.of(20, 22).collect(Collectors.toList());
        tmp.add(0, tmp5);
        res = overlapping(tmp);
        System.out.println(res);
        List<Integer> tmp6 = Stream.of(10, 15).collect(Collectors.toList());
        tmp.add(0, tmp6);
        res = overlapping(tmp);
        System.out.println(res);
    }
}
