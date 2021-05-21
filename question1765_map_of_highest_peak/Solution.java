package question1765_map_of_highest_peak;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int[][] highestPeak(int[][] isWater) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = isWater.length, n = isWater[0].length;
        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    result[i][j] = 0;
                }
            }
        }
        int height = 1;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = queue.poll();
                for (int[] direction : directions) {
                    int nextRow = direction[0] + cur[0], nextCol = direction[1] + cur[1];
                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && result[nextRow][nextCol] == -1) {
                        queue.add(new int[] {nextRow, nextCol});
                        result[nextRow][nextCol] = height;
                    }
                }
            }
            height++;
        }
        return result;
    }

}