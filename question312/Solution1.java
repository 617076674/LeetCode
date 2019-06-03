package question312;

public class Solution1 {

    public int maxCoins(int[] nums) {
        if (0 == nums.length) {
            return 0;
        } else if (1 == nums.length) {
            return nums[0];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                int[] temp = new int[nums.length - 1];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = nums[j + 1];
                }
                result = Math.max(result, nums[0] * nums[1] + maxCoins(temp));
            } else if (i == nums.length - 1) {
                int[] temp = new int[nums.length - 1];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = nums[j];
                }
                result = Math.max(result, nums[nums.length - 1] * nums[nums.length - 2] + maxCoins(temp));
            } else {
                int[] temp = new int[nums.length - 1];
                for (int j = 0; j < i; j++) {
                    temp[j] = nums[j];
                }
                for (int j = i + 1; j < nums.length; j++) {
                    temp[j - 1] = nums[j];
                }
                result = Math.max(result, nums[i] * nums[i - 1] * nums[i + 1] + maxCoins(temp));
            }
        }
        return result;
    }

}
