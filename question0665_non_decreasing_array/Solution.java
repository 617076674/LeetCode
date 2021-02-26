package question0665_non_decreasing_array;

/**
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败92.22%。消耗内存：45.8MB，击败79.34%。
 */
public class Solution {

    public boolean checkPossibility(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return true;
        }
        int index = -1; //寻找下降沿的开始索引位置
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1 || index == n - 2) {    //如果没有找到下降沿，或者下降沿的开始处是倒数第二个位置
            return true;
        }
        //忽略第index个元素或第index + 1元素的情况下，判断nums数组是否是一个非递减数组
        return isNonDecreasingArray(nums, index) || (isNonDecreasingArray(nums, index + 1));
    }

    /**
     * 在忽略第index位置元素的情况下，nums数组是否是一个非递减数组。
     */
    private boolean isNonDecreasingArray(int[] nums ,int index) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == index) {
                continue;
            }
            int num1 = nums[i], num2 = i + 1 == index ? nums[i + 2] : nums[i + 1];
            if (num1 > num2) {
                return false;
            }
        }
        return true;
    }

}