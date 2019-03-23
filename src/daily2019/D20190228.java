package daily2019;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/*
Given a list, sort it using this method: reverse(lst, i, j), which reverses lst from i to j`.

@solved
 */
public class D20190228 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(6);
        list.add(9);
        list.add(10);
        list.add(3);
        list.add(7);
        list.add(5);
        list.add(51);
        list.add(14);
        ArrayUtil.printList(list);
        reverse(list, 3,7);
        ArrayUtil.printList(list);
        reverse(list, 3,6);
        ArrayUtil.printList(list);
    }

    // O(n) 逻辑思考list操作
    public static void reverse(List<Integer> list, int i, int j) {
        for (int x = i, y = j; x < y; x++, y--) {
            int a = list.get(x);
            int b = list.get(y);
            list.remove(x);
            list.add(x, b);
            list.remove(y);
            list.add(y, a);
        }
    }
}
