package question1991_find_the_middle_index_in_array;

public class Solution {

    public int findMiddleIndex(int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            int left = sums[i], right = sums[sums.length - 1] - sums[i + 1];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }

}