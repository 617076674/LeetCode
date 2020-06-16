package question0818_race_car;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://www.youtube.com/watch?v=HzlEkUt2TYs
 *
 * 广搜求最短路径。
 *
 * 时间复杂度和空间复杂度均是 O(2 ^ step)，其中 step 为最短路径长度。
 *
 * 执行用时：787ms，击败5.21%。消耗内存：103.4MB，击败100.00%。
 */
public class Solution1 {
    public int racecar(int target) {
        int step = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Pair<>(0, 1));
        visited.add("0_1");
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Pair<Integer, Integer> now = queue.poll();
                int position = now.getKey(), speed = now.getValue();
                // A
                int positionA = position + speed, speedA = speed * 2;
                if (positionA == target) {
                    return step + 1;
                }
                // 剪枝：
                // 证明一：如果当前的位置的绝对值大于等于 2 * target，这条路径一定不会是最短路径。
                // 证明二：如果当前的速度的绝对值大于等于 2 * target，这条路径一定不会是最短路径。
                if (Math.abs(positionA) < 2 * target && Math.abs(speedA) < 2 * target) {
                    String keyA = positionA + "_" + speedA;
                    if (!visited.contains(keyA)) {
                        queue.add(new Pair<>(positionA, speedA));
                        visited.add(keyA);
                    }
                }
                // R
                int positionB = position, speedB = speed > 0 ? -1 : 1;
                String keyB = positionB + "_" + speedB;
                if (!visited.contains(keyB)) {
                    queue.add(new Pair<>(positionB, speedB));
                    visited.add(keyB);
                }
            }
            step++;
        }
        return -1;
    }
}