package question0280;

import java.util.Arrays;

/**
 * @author qianyihui
 * @date 2019-08-07
 *
 * 排序后交换。
 *
 * 时间复杂度是O(nlogn)，其中n是nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：10ms，击败6.45%。消耗内存：47.6MB，击败100.00%。
 */
public class Solution1 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
