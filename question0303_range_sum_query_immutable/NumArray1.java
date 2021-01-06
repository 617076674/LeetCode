package question0303_range_sum_query_immutable;

/**
 * 前序和。
 *
 * 构造函数的时间复杂度是O(n)，其中n是nums数组的长度。sumRange()函数的时间复杂度是O(1)。
 *
 * 执行用时：75ms，击败84.99%。消耗内存：41.2MB，击败98.46%。
 */
public class NumArray1 {

    private int[] sums;

    public NumArray1(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

}
