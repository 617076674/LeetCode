package question1537_get_the_maximum_score;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp1[i] 表示以 nums1[i - 1] 结尾的合法路径的最大得分。
 * dp2[j] 表示以 nums2[j - 1] 结尾的合法路径的最大得分。
 *
 * 初始化条件：
 * dp1[0] = 0。
 * dp2[0] = 0。
 *
 * 状态转移方程：
 * 当 nums1[i - 1] < nums2[j - 1] 时，dp1[i] = dp1[i - 1] + nums1[i - 1]。
 * 当 nums1[i - 1] > nums2[j - 1] 时，dp2[j] = dp2[j - 1] + nums2[j - 1]。
 * 当 nums1[i - 1] == nums2[j - 1] 时，dp1[i] = dp2[j] = max(dp1[i - 1], dp2[j - 1]) + nums1[i - 1]。
 *
 * 时间复杂度和空间复杂度均是 O(n1 + n2)，其中 n1 为数组 nums1 的长度，n2 为数组 nums2 的长度。
 *
 * 执行用时：7ms，击败37.05%。消耗内存：47.3MB，击败89.50%。
 */
public class Solution {

    private static final int MOD = 1000000007;

    public int maxSum(int[] nums1, int[] nums2) {
        long[] dp1 = new long[nums1.length + 1];
        long[] dp2 = new long[nums2.length + 1];
        int i = 1, j = 1;
        while (i < nums1.length + 1 || j < nums2.length + 1) {
            if (i < nums1.length + 1 && j < nums2.length + 1) {
                if (nums1[i - 1] < nums2[j - 1]) {
                    dp1[i] = dp1[i - 1] + nums1[i - 1];
                    i++;
                } else if (nums1[i - 1] == nums2[j - 1]) {
                    dp1[i] = dp2[j] = Math.max(dp1[i - 1], dp2[j - 1]) + nums1[i - 1];
                    i++;
                    j++;
                } else {
                    dp2[j] = dp2[j - 1] + nums2[j - 1];
                    j++;
                }
            } else if (i < nums1.length + 1) {
                dp1[i] = dp1[i - 1] + nums1[i - 1];
                i++;
            } else if (j < nums2.length + 1){
                dp2[j] = dp2[j - 1] + nums2[j - 1];
                j++;
            }
        }
        return (int) (Math.max(dp1[nums1.length], dp2[nums2.length]) % MOD);
    }

}