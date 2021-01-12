package question1681_minimum_incompatibility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int minimumIncompatibility(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if (count > k) {
                return -1;
            }
            map.put(num, count);
        }
        if (k == nums.length) {
            return 0;
        }
        int groupSize = nums.length / k;
        int[][] dp = new int[1 << nums.length][nums.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < nums.length; i++) {
            dp[1 << i][i] = 0;
        }
        for (int status = 0; status < (1 << nums.length); status++) {
            for (int i = 0; i < nums.length; i++) {
                if ((status & (1 << i)) == 0) {
                    continue;
                }
                for (int j = 0; j < nums.length; j++) {
                    if ((status & (1 << j)) != 0) {
                        continue;
                    }
                    int nextStatus = status | (1 << j);
                    if (countOne(status) % groupSize == 0) {
                        dp[nextStatus][j] = Math.min(dp[nextStatus][j], dp[status][i]);
                    } else if (nums[j] > nums[i]) {
                        dp[nextStatus][j] = Math.min(dp[nextStatus][j], dp[status][i] + nums[j] - nums[i]);
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE / 2;
        for (int i = 0; i < nums.length; i++) {
            result = Math.min(result, dp[(1 << nums.length) - 1][i]);
        }
        return result;
    }

    private static int countOne(int status) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((status & (1 << i)) != 0) {
                result++;
            }
        }
        return result;
    }

}