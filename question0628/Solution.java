package question0628;

/**
 * @author qianyihui
 * @date 2019-08-19
 *
 * 遍历一次数组，记录前三个最大值和前三个最小值。
 *
 * 返回的结果肯定在下面3种情形中产生：
 * （1）三个最大的正数：max1 * max2 * max3
 * （2）二个最小的负数，一个最大的正数：min1 * min2 * max1
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：8ms，击败77.78%。消耗内存：49.8MB，击败36.98%。
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, min3 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //更新max1、max2和max3
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }
            //更新min1、min2和min3
            if (nums[i] < min1) {
                min3 = min2;
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min3 = min2;
                min2 = nums[i];
            } else if (nums[i] < min3) {
                min3 = nums[i];
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
