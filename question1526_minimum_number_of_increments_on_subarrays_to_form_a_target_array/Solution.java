package question1526_minimum_number_of_increments_on_subarrays_to_form_a_target_array;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/solution/xing-cheng-mu-biao-shu-zu-de-zi-shu-zu-zui-shao-ze/
 */
public class Solution {

    public int minNumberOperations(int[] target) {
        int result = target[0];
        for (int i = 1; i < target.length; i++) {
            result += Math.max(target[i] - target[i - 1], 0);
        }
        return result;
    }

}