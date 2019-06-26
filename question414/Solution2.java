package question414;

/**
 * @author qianyihui
 * @date 2019-06-15
 * <p>
 * 用3个指针first、second和third分别保存最大值、第二大值、第三大值。
 * <p>
 * 为什么要用long型数据呢？
 * <p>
 * 如果用int型数据，那么一旦数组中有了Integer.MIN_VALUE值，会出错。
 * <p>
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 * <p>
 * 执行用时：1ms，击败99.76%。消耗内存37.3MB，击败79.84%。
 */
public class Solution2 {

    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
                count++;
            } else if (nums[i] < first && nums[i] > second) {
                third = second;
                second = nums[i];
                count++;
            } else if (nums[i] < second && nums[i] > third) {
                third = nums[i];
                count++;
            }
        }
        if (count >= 3) {
            return (int) third;
        }
        return (int) first;
    }

}
