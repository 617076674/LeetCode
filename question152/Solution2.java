package question152;

public class Solution2 {
    public int maxProduct(int[] nums) {
        int[] maxdp = new int[nums.length];
        int[] mindp = new int[nums.length];
        maxdp[0] = mindp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= 0){
                maxdp[i] = Math.max(maxdp[i - 1] * nums[i], nums[i]);
                mindp[i] = Math.min(mindp[i - 1] * nums[i], nums[i]);
            }else{
                maxdp[i] = Math.max(mindp[i - 1] * nums[i], nums[i]);
                mindp[i] = Math.min(maxdp[i - 1] * nums[i], nums[i]);
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < maxdp.length ; i++){
            if(maxdp[i] > result){
                result = maxdp[i];
            }
        }
        return result;
    }
}
