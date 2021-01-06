package question1353_maximum_number_of_events_that_can_be_attended;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public int maxEvents(int[][] events) {
        List<Integer>[] map = new List[100001];
        for (int i = 0; i < events.length; i++) {
            List<Integer> indexes = map[events[i][0]];
            if (null == indexes) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map[events[i][0]] = tmp;
            } else {
                indexes.add(i);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;
        for (int i = 1; i <= 100000; i++) {
            List<Integer> indexes = map[i];
            if (null != indexes) {
                for (int index : indexes) {
                    pq.add(events[index][1]);
                }
            }
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                result++;
            }
        }
        return result;
    }

}