package question075;

public class Solution2 {

    public void sortColors(int[] nums) {
        int lessThan = -1;                   //[0, lessThan] restore 0
        int greaterThan = nums.length;      //[greaterThan, nums.length - 1] restore 2
        int i = 0;                          //[lessThan + 1, i) restore 1
        while(i < greaterThan){
            if(nums[i] == 0){
                swap(nums, i, lessThan + 1);
                lessThan++;
                i++;
            }else if(nums[i] == 1){
                i++;
            }else{
                swap(nums, i, greaterThan - 1);
                greaterThan--;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
