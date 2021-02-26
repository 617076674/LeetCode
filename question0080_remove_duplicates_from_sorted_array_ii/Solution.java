package question0080_remove_duplicates_from_sorted_array_ii;

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