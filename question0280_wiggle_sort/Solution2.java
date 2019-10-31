package question0280_wiggle_sort;

/**
 * @author qianyihui
 * @date 2019-08-07
 *
 * 一次遍历解决。
 *
 * 时间复杂度是O(n)，其中n是nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败58.60%。消耗内存：47.4MB，击败100.00%。
 */
public class Solution2 {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            //1-如果i是偶数，需要满足nums[i] <= nums[i + 1]
            //2-如果i是奇数，需要满足nums[i] >= nums[i + 1]
            if ((((i & 1) == 0) && nums[i] > nums[i + 1]) || (((i & 1) == 1) && nums[i] < nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}