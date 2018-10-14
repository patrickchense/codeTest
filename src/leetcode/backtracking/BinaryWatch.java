package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
@backtracking
leetcode 401
https://leetcode.com/problems/binary-watch/description/

four hour LEDs, 6 min LEDs
give number n (LED on), give all the possible hour
Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

 */
public class BinaryWatch {

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        help(num, 0, 0, res, "", 0);
        return res;
    }

    /*
    难点在于，如何表达需要回溯的状态
    比如这题
        这里的是一个时刻的数组， hour(1,2,4,8), min(1,2,4,8,16,32)
        然后需要一个记录当前数组所在位置的指针，遍历的时候可以回溯
        分组，一个Hour，一个min
     */
    public void help(int num, int hour, int minite, List<String> res, String tmp, int pos) {
        if (hour > 11 || minite > 59) {
            return;
        }
        if (num == 0) {
            String m = minite < 10 ? "0" + String.valueOf(minite) : String.valueOf(minite);
            tmp = String.valueOf(hour) + ":" + m;
            res.add(tmp);
            return;
        }
        int[] time = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        for (int i = pos; i < time.length; i++) {
            if (i < 4) {
                help(num - 1, hour + time[i], minite, res, tmp, i + 1);
            } else {
                help(num - 1, hour, minite + time[i], res, tmp, i + 1);
            }
        }
    }
}
