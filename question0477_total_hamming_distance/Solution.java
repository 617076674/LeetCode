package question0477_total_hamming_distance;

/**
 * 时间复杂度是O(n)，其中n为数组nums的长度。空间复杂度是O(1)。
 *
 * 执行用时：20ms，击败51.33%。消耗内存：42.2MB，击败5.00%。
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int countOne = 0, countZero = 0;
            for (int j = 0; j < n; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    countOne++;
                } else {
                    countZero++;
                }
            }
            result += countOne * countZero;
        }
        return result;
    }
}