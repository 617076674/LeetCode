package question189;

public class Solution1 {
    public void rotate(int[] nums, int k) {
        if(0 == nums.length){
            return;
        }
        k %= nums.length;
        for(int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}
