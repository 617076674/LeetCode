package question260;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int num1XORNum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            num1XORNum2 ^= nums[i];
        }
        num1XORNum2 &= -num1XORNum2;
        int[] result = new int[2];
        result[0] = result[1] = 0;
        for (int i = 0; i < nums.length; i++) {
            if(0 == (nums[i] & num1XORNum2)){
                result[0] ^= nums[i];
            }else{
                result[1] ^= nums[i];
            }
        }
        return result;
    }
}
