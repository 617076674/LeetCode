package lcof39_shu_zu_zhong_chu_xian_ci_shu_chao_guo_yi_ban_de_shu_zi;

public class Solution {

    public int majorityElement(int[] nums) {
        int result = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (result == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    result = nums[i];
                    count = 1;
                }
            }
        }
        return result;
    }

}