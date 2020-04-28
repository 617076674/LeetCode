package lcof56_i_shu_zu_zhong_shu_zi_chu_xian_de_ci_shu;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        int num1XORNum2 = 0;
        for (int num : nums) {
            num1XORNum2 ^= num;
        }
        num1XORNum2 &= -num1XORNum2;    //取num1XORNum2最右边的1，其余位均置为0
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (0 == (nums[i] & num1XORNum2)) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }
        return result;
    }
}