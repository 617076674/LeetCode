package question031;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82491091
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        for (; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }
        if (i >= 1) {
            int j = n - 1;
            for (; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    break;
                }
            }
            swap(i - 1, j, nums);
            reverse(nums, i);
        } else {
            reverse(nums, 0);
        }
    }

    private void reverse(int[] nums, int index) {
        int i = index;
        int j = nums.length - 1;
        while (i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
