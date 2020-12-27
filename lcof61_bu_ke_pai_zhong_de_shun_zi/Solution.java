package lcof61_bu_ke_pai_zhong_de_shun_zi;

import java.util.Arrays;

public class Solution {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length && nums[index] == 0) {
            index++;
        }
        int gap = 0;
        for (int i = index; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                return false;
            }
            gap += nums[i + 1] - nums[i] - 1;
        }
        return gap <= index;
    }

}