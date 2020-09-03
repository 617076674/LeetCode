package question0841_keys_and_rooms;

import java.util.List;

/**
 * 深搜。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为房间总数。
 *
 * 执行用时：1ms，击败96.80%。消耗内存：39.6MB，击败80.65%。
 */
public class Solution {
    private boolean[] canVisit;

    private int count;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        canVisit = new boolean[rooms.size()];
        dfs(rooms, 0);
        return count == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int now) {
        canVisit[now] = true;
        count++;
        for (int next : rooms.get(now)) {
            if (!canVisit[next]) {
                dfs(rooms, next);
            }
        }
    }
}