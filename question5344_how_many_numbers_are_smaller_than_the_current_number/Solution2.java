package question5344_how_many_numbers_are_smaller_than_the_current_number;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为nums数组的长度。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：41.4MB，击败100.00%。
 */
public class Solution2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        //count[i]表示数字i在nums数组中出现的次数，lessCount[i] = count[0] + count[1] + ... + count[i - 1]
        int[] count = new int[101], lessCount = new int[101], result = new int[n];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i < 101; i++) {
            lessCount[i] = lessCount[i - 1] + count[i - 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = lessCount[nums[i]];
        }
        return result;
    }
}