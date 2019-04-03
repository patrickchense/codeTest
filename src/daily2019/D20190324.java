package daily2019;

import util.ArrayUtil;

import java.util.Arrays;

/*
You are given a list of data entries that represent entries and exits of groups of people into a building. An entry looks like this:

{"timestamp": 1526579928, count: 3, "type": "enter"}

This means 3 people entered the building. An exit looks like this:

{"timestamp": 1526580382, count: 2, "type": "exit"}

This means that 2 people exited the building. timestamp is in Unix time.

Find the busiest period in the building, that is, the time with the most people in the building. Return it as a pair of (start, end) timestamps.
 You can assume the building always starts off and ends up empty, i.e. with 0 people inside.

@Amazon
@easy
@solved
@10min


 */
public class D20190324 {

    public static void main(String[] args) {
        String[] strings = new String[] {
                "{\"timestamp\": 1526579928, count: 3, \"type\": \"enter\"}",
                "{\"timestamp\": 1526580382, count: 2, \"type\": \"exit\"}",
                "{\"timestamp\": 1526581928, count: 3, \"type\": \"enter\"}",
                "{\"timestamp\": 1526582928, count: 3, \"type\": \"enter\"}",
                "{\"timestamp\": 1526583382, count: 2, \"type\": \"exit\"}",
                "{\"timestamp\": 1526584382, count: 2, \"type\": \"exit\"}",
                "{\"timestamp\": 1526585382, count: 2, \"type\": \"exit\"}",
                "{\"timestamp\": 1526586382, count: 1, \"type\": \"exit\"}"
        };
        System.out.println(Arrays.toString(busiestHour(strings)));
    }

    /*
    很简单，只需要找到最大人数的i，然后i到i+1的时间段就是
     */
    public static long[] busiestHour(String[] strs) {
        int max = 0;
        int cur = 0;
        long time = 0;
        int i = 0;
        for (int j = 0; j < strs.length; j++) {
            String[] attris = strs[j].substring(1, strs[j].length() - 1).split(",");
            long t = Long.valueOf(attris[0].split(":")[1].trim());
            String type = attris[2].split(":")[1].trim().substring(1, attris[2].split(":")[1].trim().length()-1);
            int count = Integer.valueOf(attris[1].split(":")[1].trim());
            if (type.equals("enter")) {
                cur += count;
            } else {
                cur -= count;
            }
            if (max < cur) {
                max = cur;
                time = t;
                i = j;
            }
        }
        long t1 = Long.valueOf(strs[i+1].substring(1, strs[i+1].length() - 1).split(",")[0].split(":")[1].trim());
        return new long[]{time, t1};
    }
}
