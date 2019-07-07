package question0334;

/**
 * @author qianyihui
 * @date 2019-07-07
 *
 * 从左到右遍历一次数组解决。
 *
 * 时间复杂度是O(n)，其中n是nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.72%。消耗内存：38.9MB，击败71.05%。
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (num1 >= nums[i]) {
                //在从左到右的遍历过程中num1必然是一直减小的
                num1 = nums[i];
            } else {
                if (num2 >= nums[i]) {
                    //此时有num1 < nums[i]
                    //在从左到右的遍历过程中num2必然是一直减小的
                    num2 = nums[i]; //必然有num1 < num2
                } else {
                    //已经有了num1 < num2，此时又有num1 < nums[i]，且num2 < nums[i]
                    //故有num1 < num2 < nums[i]，找到了一组三元序列。
                    return true;
                }
            }
        }
        return false;
    }
}
