package question1383_maximum_performance_of_a_team;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 对员工按照效率由高到低排序。
 *
 * 对于第i个员工，如果要将其加入结果集，那么就需要在[0, i - 1]范围内寻找速度排名前k - 1的员工，这个过程可以用优先队列。
 *
 * 时间复杂度是O(nlogk)。空间复杂度是O(n)。
 *
 * 执行用时：56ms，击败100.00%。消耗内存：54.8MB，击败100.00%。
 */
public class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, (o1, o2) -> efficiency[o2] - efficiency[o1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long result = Long.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            if (pq.size() > k - 1) {
                sum -= pq.poll();
            }
            sum += speed[indexes[i]];
            result = Math.max(result, efficiency[indexes[i]] * sum);
            pq.add(speed[indexes[i]]);
        }
        return (int) (result % 1000000007);
    }
}