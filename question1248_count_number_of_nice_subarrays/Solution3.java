package question1248_count_number_of_nice_subarrays;

/**
 * 前缀和+哈希表
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为nums数组的长度。
 *
 * 执行用时：6ms，击败85.47%。消耗内存：48.1MB，击败100.00%。
 */
public class Solution3 {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0, countOdd = 0;
        int[] map = new int[nums.length + 1];
        map[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                countOdd++;
            }
            if (countOdd >= k) {
                result += map[countOdd - k];
            }
            map[countOdd] += 1;
        }
        return result;
    }
}
