package question1473_paint_house_iii;

import java.util.Arrays;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O(m * n * target * n)。空间复杂度是 O(m * n * target)。
 *
 * 执行用时：36ms，击败47.22%。消耗内存：40.5MB，击败53.57%。
 */
public class Solution {
    private int[][][] memo;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        memo = new int[m + 1][n + 1][target + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        if (houses[m - 1] == 0) {
            int result = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                result = Math.min(result, minCostHelper(houses, cost, m - 1, i, target));
            }
            return result == Integer.MAX_VALUE ? -1 : result;
        }
        int result = minCostHelper(houses, cost, m - 1, houses[m - 1], target);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * 第 houseIndex 号房子的颜色是 color，[0, houseIndex] 内的房子形成 target 个街区的最小花费
     */
    private int minCostHelper(int[] houses, int[][] cost, int houseIndex, int color, int target) {
        if (houseIndex == 0) {
            if (houses[houseIndex] == 0 && target == 1) {
                return cost[houseIndex][color - 1];
            }
            if (houses[houseIndex] == color && target == 1) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if (target <= 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[houseIndex][color][target] != -1) {
            return memo[houseIndex][color][target];
        }
        int result = Integer.MAX_VALUE;
        if (houses[houseIndex] == 0) {
            // houseIndex 处的颜色和 houseIndex - 1 处的颜色都可以自由选择
            if (houses[houseIndex - 1] == 0) {
                for (int i = 0; i < cost[0].length; i++) {
                    if (i + 1 == color) {
                        int tmp = minCostHelper(houses, cost, houseIndex - 1, i + 1, target);
                        if (tmp != Integer.MAX_VALUE) {
                            result = Math.min(result, cost[houseIndex][color - 1] + tmp);
                        }
                    } else {
                        int tmp = minCostHelper(houses, cost, houseIndex - 1, i + 1, target - 1);
                        if (tmp != Integer.MAX_VALUE) {
                            result = Math.min(result, cost[houseIndex][color - 1] + tmp);
                        }
                    }
                }
            } else {
                if (color == houses[houseIndex - 1]) {
                    int tmp = minCostHelper(houses, cost, houseIndex - 1, houses[houseIndex - 1], target);
                    if (tmp != Integer.MAX_VALUE) {
                        result = Math.min(result, cost[houseIndex][color - 1] + tmp);
                    }
                } else {
                    int tmp = minCostHelper(houses, cost, houseIndex - 1, houses[houseIndex - 1], target - 1);
                    if (tmp != Integer.MAX_VALUE) {
                        result = Math.min(result, cost[houseIndex][color - 1] + tmp);
                    }
                }
            }
        } else {
            if (houses[houseIndex - 1] == 0) {
                for (int i = 0; i < cost[0].length; i++) {
                    if (i + 1 == color) {
                        int tmp = minCostHelper(houses, cost, houseIndex - 1, i + 1, target);
                        if (tmp != Integer.MAX_VALUE) {
                            result = Math.min(result, tmp);
                        }
                    } else {
                        int tmp = minCostHelper(houses, cost, houseIndex - 1, i + 1, target - 1);
                        if (tmp != Integer.MAX_VALUE) {
                            result = Math.min(result, tmp);
                        }
                    }
                }
            } else {
                if (color == houses[houseIndex - 1]) {
                    int tmp = minCostHelper(houses, cost, houseIndex - 1, color, target);
                    if (tmp != Integer.MAX_VALUE) {
                        result = Math.min(result, tmp);
                    }
                } else {
                    int tmp = minCostHelper(houses, cost, houseIndex - 1, houses[houseIndex - 1], target - 1);
                    if (tmp != Integer.MAX_VALUE) {
                        result = Math.min(result, tmp);
                    }
                }
            }
        }
        memo[houseIndex][color][target] = result;
        return result;
    }
}