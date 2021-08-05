package lcof42_lian_xu_zi_shu_zu_de_zui_da_he;

/**
 * 时间复杂度是 O(n)，其中 n 为 nums 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败98.71%。消耗内存：46.7MB，击败100.00%。
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            result = Math.max(result, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

}