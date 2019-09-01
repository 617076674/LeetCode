package question0368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp1[i]:nums数组中[0, i]范围内的数字所能构成的最大整除集合的大小。
 * dp2[i]:上一个能被自己整除的且整除子集长度最大的下标
 *
 * 状态转移：
 * dp1[i] = max(dp1[i], dp1[j] + 1),其中j∈[0, i - 1]且nums[i] % nums[j] == 0。
 * dp2[i] = j，其中j就是令dp1[i]取最大值的那个j。
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：41ms，击败69.57%。消耗内存：37.8MB，击败57.81%。
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return result;
        }
        Arrays.sort(nums);
        int[] dp1 = new int[n], dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, -1);
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp1[i] < dp1[j] + 1) {
                    dp1[i] = dp1[j] + 1;
                    dp2[i] = j;
                    if (dp1[i] > dp1[maxIndex]) {
                        maxIndex = i;
                    }
                }
            }
        }
        int cur = maxIndex;
        while (cur != -1) {
            result.add(nums[cur]);
            cur = dp2[cur];
        }
        return result;
    }
}
