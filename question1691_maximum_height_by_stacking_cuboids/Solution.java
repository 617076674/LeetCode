package question1691_maximum_height_by_stacking_cuboids;

import java.util.Arrays;

public class Solution {

    private int[][] memo;

    public int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids, (cuboid1, cuboid2) -> {
            if (cuboid1[0] == cuboid2[0]) {
                if (cuboid1[1] == cuboid2[1]) {
                    return cuboid2[2] - cuboid1[2];
                }
                return cuboid2[1] - cuboid1[1];
            }
            return cuboid2[0] - cuboid1[0];
        });
        memo = new int[cuboids.length + 1][cuboids.length + 1];
        return maxHeight(cuboids, cuboids.length - 1, cuboids.length);
    }

    // 考虑 [0, index] 范围内的长方体能够构成的最大高度
    private int maxHeight(int[][] cuboids, int index, int pre) {
        if (index < 0) {
            return 0;
        }
        if (memo[index][pre] != 0) {
            return memo[index][pre];
        }
        // 不使用第 index 个长方体
        memo[index][pre] = maxHeight(cuboids, index - 1, pre);
        // 使用第 index 个长方体
        if (pre == cuboids.length || cuboids[index][0] >= cuboids[pre][0]
            && cuboids[index][1] >= cuboids[pre][1] && cuboids[index][2] >= cuboids[pre][2]) {
            memo[index][pre] = Math.max(memo[index][pre], cuboids[index][2] +
                maxHeight(cuboids, index - 1, index));
        }
        return memo[index][pre];
    }

}