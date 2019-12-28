package question1066_campus_bikes_ii;

/**
 * 回溯。
 *
 * 时间复杂度是O(n!/m!)，其中n是bikes数组的长度，m是workers数组的长度。
 *
 * 执行用时：342ms，击败29.03%。消耗内存：34.6MB，击败100.00%。
 */
public class Solution {
    private boolean[] used;

    private int result = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {
        used = new boolean[bikes.length];
        assignBikes(workers, bikes, 0, 0);
        return result;
    }

    private void assignBikes(int[][] workers, int[][] bikes, int index, int sum) {
        if (index == workers.length) {
            result = Math.min(result, sum);
            return;
        }
        if (sum >= result) {
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                assignBikes(workers, bikes, index + 1, sum + manhattan(workers[index][0], workers[index][1], bikes[i][0], bikes[i][1]));
                used[i] = false;
            }
        }
    }

    private int manhattan(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}