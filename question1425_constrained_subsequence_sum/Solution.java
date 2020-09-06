package question1425_constrained_subsequence_sum;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 动态规划 + 双端队列。
 *
 * 状态定义：
 * dp[i] 表示以数组中 nums[i] 结尾的，相邻元素原下标差不超过 k 子序列最大和。
 *
 * 初始化条件：
 * dp[0] = nums[0]。
 *
 * 状态转移方程：
 * dp[i] = nums[i] + max(0, dp[j]), l ∈ [i - k, i - 1]。滑动窗口中的最大值用双端队列来求得。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为数组 nums 的长度。
 *
 * 执行用时：30ms，击败12.50%。消耗内存：48.5MB，击败59.65%。
 */
public class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int result = nums[0];
        dp[0] = nums[0];
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(0);
        // 当窗口大小没有达到 k - 1 时
        for (int i = 1; i < k; i++) {
            dp[i] = Math.max(dp[deque.getFirst()] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
            while (!deque.isEmpty() && dp[deque.getLast()] < dp[i]) {
                deque.removeLast();
            }
            deque.add(i);
        }
        // 当窗口大小达到 k - 1 时
        for (int i = k; i < n; i++) {
            dp[i] = Math.max(dp[deque.getFirst()] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
            while (!deque.isEmpty() && dp[deque.getLast()] < dp[i]) {
                deque.removeLast();
            }
            deque.add(i);
            if (deque.getFirst() == i - k) {
                deque.removeFirst();
            }
        }
        return result;
    }
}