package question209;

public class Solution3 {
    public int minSubArrayLen(int s, int[] nums) {
        if(0 == nums.length){
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int[] sums = new int[nums.length + 1];
        for(int i = 1; i < sums.length; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for(int i = 1; i < sums.length; i++){
            int temp = lowerBound(sums, 0, sums.length - 1, s + sums[i - 1]);
            if(-1 != temp){
                result = Math.min(result, temp - i + 1);
            }
        }
        if(result == Integer.MAX_VALUE){
            return 0;
        }
        return result;
    }
    private int lowerBound(int[] nums, int left, int right, int target){
        if(left > right){
            return -1;
        }
        if(left == right){
            return nums[left] >= target ? left : -1;
        }
        int mid = left + (right - left) / 2;
        if(nums[mid] >= target){
            return lowerBound(nums, left, mid, target);
        }else{
            return lowerBound(nums, mid + 1, right, target);
        }
    }
}
