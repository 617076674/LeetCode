package question0300_longest_increasing_subsequence;

/**
 * 二分查找法。
 *
 * 扑克牌分堆放置，放置规则如下：
 * （1）只能把点数小的牌压到点数比它大的牌上。
 * （2）如果当前牌点数较大没有可以放置的堆，则新建一堆，把这张牌放进去。
 * （3）如果当前牌有多个堆可供选择， 则选择最左边的堆放置。
 *
 * 时间复杂度是O(nlogn)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：1ms，击败99.58%。消耗内存：36.2MB，击败34.62%。
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) == 0) {
            return 0;
        }
        int[] tops = new int[n];    // 每堆扑克牌堆顶的牌
        tops[0] = nums[0];  // 第一张牌显然只能新建一堆
        int piles = 1;  // 现在一共有piles堆扑克牌
        for (int i = 1; i < n; i++) {
            // 在[0, piles - 1]范围内寻找第一处比nums[i]大的位置，即ceil函数
            int left = 0, right = piles - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (tops[mid] == nums[i]) {
                    left = mid + 1;
                } else if (tops[mid] < nums[i]) {
                    left = mid + 1;
                } else if (tops[mid] > nums[i]) {
                    right = mid - 1;
                }
            }
            if (left - 1 >= 0 && tops[left - 1] == nums[i]) {
                continue;
            }
            if (left == piles) {
                piles++;
            }
            tops[left] = nums[i];
        }
        return piles;
    }
}