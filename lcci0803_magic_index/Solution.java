package lcci0803_magic_index;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：40.7MB，击败100.00%。
 */
public class Solution {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}