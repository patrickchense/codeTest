package daily2019;

import java.util.Map;

/*
You have a large array with most of the elements as zero.

Use a more space-efficient data structure, SparseArray, that implements the same interface:

init(arr, size): initialize with the original large array and size.
set(i, val): updates index at i with val.
get(i): gets the value at index i.

@Facebook
@design

大数组，大部分0， 能想到的事，用类似 index + val + split 的方式，一旦找不到index，那么0

https://github.com/deepak-malik/Data-Structures-In-Java/blob/master/src/com/deepak/data/structures/Arrays/SparseArray.java  存在这个数据结构

@review

 */
public class D20190215 {

    public static void main(String[] args) {

    }

    // array的特点, index find O(1),
    class SparseArray {
        Map<Integer, Integer> indexes; //记录非0值的 真正Index和值

    }

}
