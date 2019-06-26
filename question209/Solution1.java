package question209;

public class Solution1 {
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < i + result && j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    result = Math.min(result, j - i + 1);
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) {
            return 0;
        }
        return result;
    }
}
