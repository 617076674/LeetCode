package question0373_find_k_pairs_with_smallest_sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i]：对于nums1[i]而言，其对应的未被使用的最小组合是nums2[dp[i]]。
 *
 * 状态转移：
 * （1）dp[i] = 0，i∈[0, n1]，此时结果集中尚未有任何数据，因此nums1中的每一个值显然与nums2中的0号元素构成的组合最小。
 * （2）dp[cur] = dp[cur] + 1，其中cur为当前新加入结果集的nums1中的索引
 *
 * 时间复杂度是O(k * n1)。空间复杂度是O(n1)。
 *
 * 执行用时：10ms，击败77.14%。消耗内存：39.6MB，击败81.84%。
 */
public class Solution2 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0) {
            return result;
        }
        int[] dp = new int[nums1.length];
        int startIndex = 0;
        while (result.size() < k) {
            int min = Integer.MAX_VALUE, cur = -1;
            for (int i = startIndex; i < nums1.length; i++) {
                if (dp[i] == nums2.length) {
                    startIndex = i + 1; // nums1[i]已经与nums2中所有元素结对入队列，之后的搜索从nums1[i + 1]开始
                    continue;
                }
                if (nums1[i] + nums2[dp[i]] < min) {
                    min = nums1[i] + nums2[dp[i]];
                    cur = i;
                }
            }
            if (cur == -1) {
                break;
            }
            result.add(Arrays.asList(nums1[cur], nums2[dp[cur]]));
            dp[cur]++;
        }
        return result;
    }
}