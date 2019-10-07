package question1184_distance_between_bus_stops;

/**
 * 时间复杂度是O(n)，其中n是distance数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：38.2MB，击败100.00%。
 */
public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int gap1 = 0, sum = 0;
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                gap1 += distance[i];
            }
            sum += distance[i];
        }
        return Math.min(gap1, sum - gap1);
    }
}
