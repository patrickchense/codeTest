package LINE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SlideWindow {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int w = Integer.valueOf(input);
        Scanner streamNumbers = new Scanner(System.in);

        List<Integer> vals = new ArrayList<>();
        while(streamNumbers.hasNextLine()) {
            int n = streamNumbers.nextInt();
            vals.add(n);
        }
        // using queue to keep the index of the val
        Deque<Integer> queue = new LinkedList<>();
        int i = 0;
        for (; i < w; i++) {
            while(!queue.isEmpty() && vals.get(i) >= vals.get(queue.peekLast())) {
                // previous smaller is useless
                queue.removeLast();
            }
            queue.addLast(i);
        }
        for (; i < vals.size(); i++) {
            System.out.println(vals.get(queue.peek()));
            while(!queue.isEmpty() && queue.peek() <= i - w) {
                queue.removeFirst(); // slide window
            }
            while(!queue.isEmpty() && vals.get(i) >= vals.get(queue.peekLast())) {
                queue.removeLast(); // remove element smaller than current
            }
            queue.addLast(i);
        }
        System.out.println(vals.get(queue.peek()));// print the last one
    }

}
