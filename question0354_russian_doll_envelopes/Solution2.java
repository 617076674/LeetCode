package question0354_russian_doll_envelopes;

import java.util.Arrays;

/**
 * 最长上升子序列问题。
 *
 * 对envelopes数组中的元素先按宽度升序排序，若宽度相同则按高度降序排列。
 *
 * 原问题就转变为求解高度序列的最长上升子序列问题。参见LeetCode300。
 *
 * 时间复杂度是O(nlogn)，其中n为envelopes数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：13ms，击败86.44%。消耗内存：40.7MB，击败100.00%。
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
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    private int lengthOfLIS(int[] nums) {
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