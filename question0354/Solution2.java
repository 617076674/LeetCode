package question0354;

import java.util.Arrays;

/**
 * 最长上升子序列问题。
 *
 * 时间复杂度是O(nlogn)，其中n为envelopes数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：89ms，击败71.02%。消耗内存：53.8MB，击败57.95%。
 */
public class Solution2 {
    public int maxEnvelopes(int[][] envelopes) {
        int n;
        if (null == envelopes || (n = envelopes.length) == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (envelope1, envelope2) -> {
            if (envelope1[0] == envelope2[0]) {
                return envelope2[1] - envelope1[1];
            }
            return envelope1[0] - envelope2[0];
        });
        int[] dp = new int[n];
        int index = 0;
        dp[index++] = envelopes[0][1];
        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > dp[index - 1]) {
                dp[index++] = envelopes[i][1];
            } else {
                int ceilIndex = ceil(dp, index, envelopes[i][1]);
                dp[ceilIndex] = envelopes[i][1];
            }
        }
        return index;
    }

    private int ceil(int[] dp, int index, int target) {
        int left = 0, right = index;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (target >= dp[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left - 1 >= 0 && dp[left - 1] == target) {
            return left - 1;
        }
        return left;
    }
}
