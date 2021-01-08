package question1340_jump_game_v;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O(d * n)，其中 n 为数组 arr 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：12ms，击败95.69%。消耗内存：39.8MB，击败59.32%。
 */
public class Solution {

    private int[] memo;

    private int n;

    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        memo = new int[n];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, maxJumps(arr, d, i));
        }
        return result;
    }

    private int maxJumps(int[] arr, int d, int now) {
        if (memo[now] != 0) {
            return memo[now];
        }
        memo[now] = 1;
        for (int i = now - 1; i >= 0 && now - i <= d && arr[now] > arr[i]; i--) {
            memo[now] = Math.max(memo[now], 1 + maxJumps(arr, d, i));
        }
        for (int i = now + 1; i < n && i - now <= d && arr[now] > arr[i]; i++) {
            memo[now] = Math.max(memo[now], 1 + maxJumps(arr, d, i));
        }
        return memo[now];
    }

}