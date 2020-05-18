package lcp09_zui_xiao_tiao_yue_ci_shu;

/**
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 jump 数组的长度。
 *
 * 执行用时：13ms，击败98.75%。消耗内存：120.9MB，击败100.00%。
 */
public class Solution {
    public int minJump(int[] jump) {
        int dp[] = new int[jump.length];
        dp[jump.length - 1] = 1;
        for (int i = jump.length - 2; i >= 0; i--) {
            dp[i] = jump[i] + i >= jump.length ? 1 : dp[jump[i] + i] + 1;   // 利用右跳更新 dp[i]
            for (int j = i + 1; j < jump.length && dp[j] >= dp[i] + 1; j++) {
                dp[j] = dp[i] + 1;  // 利用左跳更新 dp[j]
            }
        }
        return dp[0];
    }
}