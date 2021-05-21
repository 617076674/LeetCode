package question1764_form_array_by_concatenating_subarrays_of_another_array;

public class Solution {

    public boolean canChoose(int[][] groups, int[] nums) {
        int begin = 0;
        for (int[] group : groups) {
            begin = canChooseHelper(group, nums, begin);
            if (begin == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 在 nums 数组 [begin, nums.length - 1] 中寻找数组 group。
     * 如果未找到，返回 -1。如果找到，返回 nums 数组中下一个开始寻找的索引。
     */
    private int canChooseHelper(int[] group, int[] nums, int begin) {
        for (int i = begin; i <= nums.length - group.length; i++) {
            // [i, i + group.length - 1] 内的值是否和 group 相同
            boolean flag = true;
            for (int j = 0; j < group.length; j++) {
                if (group[j] != nums[j + i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i + group.length;
            }
        }
        return -1;
    }

}