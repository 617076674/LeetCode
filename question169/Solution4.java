package question169;

public class Solution4 {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (0 == count) {
                count = 1;
                result = nums[i];
            } else if (nums[i] == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
