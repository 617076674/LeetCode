package question152;

public class Solution1 {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int temp = 1;
            for(int j = i; j < nums.length; j++){
                temp *= nums[j];
                if(temp > result){
                    result = temp;
                }
            }
        }
        return result;
    }
}
