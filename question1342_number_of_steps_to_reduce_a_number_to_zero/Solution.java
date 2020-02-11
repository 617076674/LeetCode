package question1342_number_of_steps_to_reduce_a_number_to_zero;

/**
 * 时间复杂度和空间复杂度均是O(log(num))。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.6MB，击败100.00%。
 */
public class Solution {
    public int numberOfSteps (int num) {
        if (num == 0) {
            return 0;
        }
        if ((num & 1) == 0) {
            return 1 + numberOfSteps(num >> 1);
        }
        return 1 + numberOfSteps(num - 1);
    }
}