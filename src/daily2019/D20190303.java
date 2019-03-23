package daily2019;

import util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;

/*
Given a list of points, a central point, and an integer k, find the nearest k points from the central point.

For example, given the list of points [(0, 0), (5, 4), (3, 1)], the central point (1, 2), and k = 2, return [(0, 0), (3, 1)].

@Linkedin
@solved
@topK
https://my.oschina.net/leejun2005/blog/135085 topK

 */
public class D20190303 {
    public static void main(String[] args) {
        List<Integer[]> points = Arrays.asList(new Integer[]{0,0}, new Integer[]{5,4}, new Integer[]{3,1});
        ArrayUtil.printList(nearestPoints(points, new Integer[]{1,2}, 2));
    }


    // 1. using list calculate all, sort(O(nlogn)) get k
    // 2. using PriorityQueue, O(log(n)) -> O(n),  O(k) space, 这里几个问题怎么使用PriorityQueue(O(logn)插入删除 ), https://yikun.github.io/2015/04/07/Java-PriorityQueue%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86%E5%8F%8A%E5%AE%9E%E7%8E%B0/
        // 这里的queue 需要reverse, o2 - o1,  然后queue size不是固定的，需要自己删除
    public static List<Integer[]> nearestPoints(List<Integer[]> points, Integer[] point, int k) {
        //Math.sqrt(Math.pow(Math.abs(o[1] - point[1]), 2) + Math.pow(Math.abs(o[0] - point[0]), 2)))
        PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return (int) (Math.sqrt(Math.pow(Math.abs(o2[1] - point[1]), 2) + Math.pow(Math.abs(o2[0] - point[0]), 2)) - (Math.sqrt(Math.pow(Math.abs(o1[1] - point[1]), 2) + Math.pow(Math.abs(o1[0] - point[0]), 2))));
            }
        });

        for (Integer[] p : points) {
            queue.offer(p);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        return new ArrayList<>(queue);
    }
}
