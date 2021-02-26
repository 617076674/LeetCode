package question1437_check_if_all_1s_are_at_least_length_k_places_away;

public class Solution {

    public boolean kLengthApart(int[] nums, int k) {
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (pre != -1 && i - pre <= k) {
                    return false;
                }
                pre = i;
            }
        }
        return true;
    }

}