package lcci1708_circus_tower;

import java.util.Arrays;

/**
 * 最长上升子序列问题。
 *
 * 扑克牌分堆放置，放置规则如下：
 * （1）只能把点数小的牌压到点数比它大的牌上。
 * （2）如果当前牌点数较大没有可以放置的堆，则新建一个堆，把这张牌放进去。
 * （3）如果当前牌有多个堆可供选择， 则选择最左边的堆放置。
 *
 * 时间复杂度是 O(nlogn)，其中 n 为 height 数组的长度。空间复杂度是 O(n)。
 *
 * 执行用时：97ms，击败20.13%。消耗内存：41.8MB，击败100.00%。
 */
public class Solution {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int n = height.length;
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, (num1, num2) -> {
            if (height[num1] == height[num2]) {
                return weight[num2] - weight[num1];
            }
            return height[num1] - height[num2];
        });
        int[] tops = new int[n];    // 每堆扑克牌堆顶的牌
        tops[0] = weight[indexes[0]];  // 第一张牌显然只能新建一堆
        int piles = 1;  // 现在一共有piles堆扑克牌
        for (int i = 1; i < n; i++) {
            // 在[0, piles - 1]范围内寻找第一处比nums[i]大的位置，即ceil函数
            int left = 0, right = piles - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (tops[mid] == weight[indexes[i]]) {
                    left = mid + 1;
                } else if (tops[mid] < weight[indexes[i]]) {
                    left = mid + 1;
                } else if (tops[mid] > weight[indexes[i]]) {
                    right = mid - 1;
                }
            }
            if (left - 1 >= 0 && tops[left - 1] == weight[indexes[i]]) {
                continue;
            }
            if (left == piles) {
                piles++;
            }
            tops[left] = weight[indexes[i]];
        }
        return piles;
    }
}