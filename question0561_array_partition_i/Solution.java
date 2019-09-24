package question0561_array_partition_i;

import java.util.Arrays;

/**
 * 贪心算法。
 *
 * 对数组进行排序后，依次两两组队，返回其中的较小值即可。
 *
 * 对于数组nums = [x0, x1, x2, ..., x(2n - 1)]
 *
 * 如果数组是有序的，按上述方案得到的结果是：result1 = x0 + x2 + x4 + ... + x(2n - 2)。
 *
 * 反证法，假设数组有序情况下得到的result1不是最大的，即存在数组的一个无序排列的使得result2 > result1。
 * 假设x2和x0换位，那么两两组队得到的结果是：result2 = x1 + x0 + x4 + ... + x(2n - 2)，和数组有序的情况下相比，只有前两项不同。
 *
 * 而x1 <= x2，所以result2 <= result1，所以数组有序的情况下得到的结果是最大的。与假设相矛盾。
 *
 * 时间复杂度是O(nlogn)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：21ms，击败93.15%。消耗内存：39.2MB，击败97.89%。
 */
public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}
