package leetcode.locked;

/*
leetcode 755
We are given an elevation map, heights[i] representing the height of the terrain at that index. The width at each index is 1. After V units of water fall at index K,
how much water is at each index?

Water first drops at index K and rests on top of the highest terrain or water at that index. Then, it flows according to the following rules:

If the droplet would eventually fall by moving left, then move left.
Otherwise, if the droplet would eventually fall by moving right, then move right.
Otherwise, rise at it's current position.
Here, "eventually fall" means that the droplet will eventually be at a lower level if it moves in that direction. Also, "level" means the height of the terrain
plus any water in that column.

We can assume there's infinitely high terrain on the two sides out of bounds of the array. Also, there could not be partial water being spread out evenly
on more than 1 grid block - each unit of water has to be in exactly one block.

Example 1:

Input: heights = [2,1,1,2,1,2,2], V = 4, K = 3
Output: [2,2,2,3,2,2,2]


 */
public class PourWater {


    // K index, V drops
    /*
    向左流有三个条件，分别说明一下：

1）T >= 0：T不能越界；

2）heights[T] + waters[T] < heights[K] + waters[K]：这样可以保证K位置高于T位置，所以水才可以从K流动到T（否则就保留在了K这个slot上面了）；

3）heights[T] + waters[T] <= heights[T + 1] + waters[T + 1]：这样保证水可以顺利的从T+1位置流向T位置，否则即使T左边还有更低的位置，水也无法越过T位置。

     */

    public int[] pourWater(int[] heights, int V, int K) {
        while (V-- > 0) {
            dropWater(heights, K);
        }
        return heights;
    }

    private void dropWater(int[] heights, int K) {
        int best = K;
        for (int d = -1; d <= 1; d += 2) {
            int i = K + d;
            while (i >= 0 && i < heights.length && heights[i] <= heights[i - d]) {
                if (heights[i] < heights[best]) best = i;
                i += d;
            }
            if (best != K) break;
        }
        ++heights[best];
    }
}
