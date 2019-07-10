package question0189;

/**
 * 暴力法。向右移动k次，每次移动1位。
 *
 * 时间复杂度是O(nk)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：136ms，击败24.79%。消耗内存：39MB，击败29.36%。
 */
public class Solution1 {

    public void rotate(int[] nums, int k) {
        if (0 == nums.length) {
            return;
        }
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

}
