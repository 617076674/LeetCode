package question0354;

import java.util.Arrays;

/**
 * 带记忆化搜索的深搜。
 *
 * 时间复杂度是O(n ^ 2)，其中n为envelopes数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：483ms，击败39.13%。消耗内存：62.8MB，击败13.07%。
 */
public class Solution1 {
    private int n;

    private int[] dp;

    private int result;

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (envelope1, envelope2) -> {
            if (envelope1[0] == envelope2[0]) {
                return envelope1[1] - envelope2[1];
            }
            return envelope1[0] - envelope2[0];
        });
        n = envelopes.length;
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            result = Math.max(result, getDepth(i, envelopes));
        }
        return result;
    }

    private int getDepth(int now, int[][] envelopes) {
        if (dp[now] != 0) {
            return dp[now];
        }
        int depth = 1;
        for (int i = 0; i < now; i++) {
            if (envelopes[now][0] > envelopes[i][0] && envelopes[now][1] > envelopes[i][1]) {
                depth = Math.max(depth, getDepth(i, envelopes) + 1);
            }
        }
        dp[now] = depth;
        return depth;
    }
}
