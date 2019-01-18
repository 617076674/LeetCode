package question162;

public class Solution1 {
    public int findPeakElement(int[] nums) {
        if(1 == nums.length){
            return 0;
        }
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                if(nums[0] > nums[1]){
                    return 0;
                }
            }else if(i == nums.length - 1){
                if(nums[nums.length - 1] > nums[nums.length - 2]){
                    return nums.length - 1;
                }
            }else{
                if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
                    return i;
                }
            }
        }
        return -1;
    }
}
