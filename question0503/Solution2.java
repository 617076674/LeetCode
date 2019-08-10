package question0503;

import java.util.Arrays;

/**
 * @author qianyihui
 * @date 2019-08-10
 *
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：286ms，击败7.37%。消耗内存：62.9MB，击败13.51%。
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int index = (i + j) % n;
                if (nums[index] > nums[i]) {
                    result[i] = nums[index];
                    break;
                }
            }
        }
        return result;
    }
}
