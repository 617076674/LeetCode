package question1405_longest_happy_string;

import java.util.PriorityQueue;

public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[] count = new int[] {a, b, c};
        char[] chars = new char[] {'a', 'b', 'c'};
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> count[o2] - count[o1]);
        pq.add(0);
        pq.add(1);
        pq.add(2);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int cur = pq.poll();
            if (count[cur] == 0) {
                break;
            }
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2) && sb.charAt(sb.length() - 1) == chars[cur]) {
                int second = pq.poll();
                if (count[second] == 0) {
                    break;
                }
                sb.append(chars[second]);
                count[second]--;
                pq.add(cur);
                pq.add(second);
            } else {
                sb.append(chars[cur]);
                count[cur]--;
                pq.add(cur);
            }
        }
        return sb.toString();
    }
}