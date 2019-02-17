import java.util.*;

/*
    m = [
            [2, 3, 6],
            [1, 3, 4, 5, 6, 8],
            [1, 3, 5, 6, 9, 10],
            [3, 5, 7, 11]
            ]
    k = 3
    Answer:
            [3, 5, 6]

    top k frequency for this double array(all sorted)


 */
public class IndeedJp {
    class Pair{
        int num;
        int count;
        public Pair(int num, int count){
            this.num=num;
            this.count=count;
        }
    }

    //use normal solution, map + priority queue + list
    /*
    what's the time cost?  O(n * m) in map, O(k*log(n*m)) in queue,
    what's the space cost? O(n * m)
    how to reduce space cost?
        using sorted? TODO
     */
    public List<Integer> topKFrequent(int[][] ns, int k) {
        //count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int[] nums: ns){
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
        }

        // create a min heap
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.count));

        //maintain a heap of size k.
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.offer(p);
            if(queue.size()>k){
                queue.poll();
            }
        }

        //get all elements from the heap
        List<Integer> result = new ArrayList<Integer>();
        while(queue.size()>0){
            result.add(queue.poll().num);
        }
        //reverse the order
        Collections.reverse(result);

        return result;
    }
}
