package question0691_stickers_to_spell_word;

/**
 * 动态规划。
 *
 * 时间复杂度是 O(m * n * 2 ^ n)，其中 m 为 stickers 数组的长度，n 为字符串 target 的长度。空间复杂度是 O(2 ^ n)。
 *
 * 执行用时：342ms，击败23.23%。消耗内存：40MB，击败25.00%。
 */
public class Solution2 {
    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        int[] dp = new int[1 << n];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == -1) {
                continue;
            }
            for (String sticker : stickers) {
                int now = i;
                for (int j = 0; j < sticker.length(); j++) {
                    for (int k = 0; k < n; k++) {
                        if (((now >> k) & 1) == 1) {
                            continue;
                        }
                        if (target.charAt(k) == sticker.charAt(j)) {
                            now |= 1 << k;
                            break;
                        }
                    }
                }
                if (dp[now] == -1 || dp[now] > dp[i] + 1) {
                    dp[now] = dp[i] + 1;
                }
            }
        }
        return dp[dp.length - 1];
    }
}