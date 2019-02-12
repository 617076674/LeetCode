package question238;

public class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = 0; j < nums.length; j++) {
                if(j != i){
                    temp *= nums[j];
                }
            }
            result[i] = temp;
        }
        return result;
    }
}
