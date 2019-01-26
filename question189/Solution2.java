package question189;

public class Solution2 {
    public void rotate(int[] nums, int k) {
        if(0 == nums.length){
            return;
        }
        k %= nums.length;
        if(0 == k){
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int left, int right){
        int i = left, j = right;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
