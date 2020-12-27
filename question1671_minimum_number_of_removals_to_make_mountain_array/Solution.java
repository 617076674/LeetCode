package question1671_minimum_number_of_removals_to_make_mountain_array;

public class Solution {

    private int[] rise;

    private int[] down;

    public int minimumMountainRemovals(int[] nums) {
        rise = new int[nums.length];
        rise[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            rise[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    rise[i] = Math.max(rise[i], 1 + rise[j]);
                }
            }
        }
        down = new int[nums.length];
        down[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            down[i] = 1;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    down[i] = Math.max(down[i], down[j] + 1);
                }
            }
        }
        int len = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (rise[i] != 1 && down[i] != 1) {
                len = Math.max(len, rise[i] + down[i] - 1);
            }
        }
        return nums.length - len;
    }

}