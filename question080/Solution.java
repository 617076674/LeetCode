package question080;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82948816
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (i < 2 || nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
