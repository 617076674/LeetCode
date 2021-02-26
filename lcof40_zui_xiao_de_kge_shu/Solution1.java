package lcof40_zui_xiao_de_kge_shu;

import java.util.PriorityQueue;

public class Solution1 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[] {};
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            if (pq.size() >= k) {
                if (num < pq.peek()) {
                    pq.poll();
                    pq.add(num);
                }
            } else {
                pq.add(num);
            }
        }
        int[] result = new int[pq.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }
        return result;
    }
}