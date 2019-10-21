package question0303_range_sum_query_immutable;

/**
 * 前序和。
 *
 * 构造函数的时间复杂度是O(n)，其中n是nums数组的长度。sumRange()函数的时间复杂度是O(1)。
 *
 * 执行用时：75ms，击败84.99%。消耗内存：41.2MB，击败98.46%。
 */
public class NumArray1 {
    //sum{i]中存储[0, i - 1]的值
    private int[] sum;

    public NumArray1(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    //[i, j] = [0, j] - [0, i - 1]
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
