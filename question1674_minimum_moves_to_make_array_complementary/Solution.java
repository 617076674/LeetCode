package question1674_minimum_moves_to_make_array_complementary;

public class Solution {

    public int minMoves(int[] nums, int limit) {
        // diff[i] = res[i] - res[i - 1]
        int[] diff = new int[2 * limit + 2];
        for (int i = 0; i < nums.length / 2; i++) {
            int left = 2, right = 2 * limit;
            // [left, right] 范围内均加 2
            diff[left] += 2;
            diff[right + 1] -= 2;
            left = 1 + Math.min(nums[i], nums[nums.length - i - 1]);
            right = limit + Math.max(nums[i], nums[nums.length - i - 1]);
            // [left, right] 范围内均减 1
            diff[left] += -1;
            diff[right + 1] -= -1;
            left = right = nums[i] + nums[nums.length - i - 1];
            // [left, right] 范围内均减 1
            diff[left] += -1;
            diff[right + 1] -= -1;
        }
        int result = Integer.MAX_VALUE, sum = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            sum += diff[i];
            result = Math.min(result, sum);
        }
        return result;
    }

}