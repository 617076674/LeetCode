package question0259;

import java.util.Arrays;

/**
 * @author qianyihui
 * @date 2019-08-06
 *
 * 内层循环用左右双指针遍历。
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：8ms，击败76.74%。消耗内存：36.1MB，击败100.00%。
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        if (nums == null) {
            return result;
        }
        int n = nums.length;
        if (n < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] >= target) {
                break;
            }
            int left = i + 1, right = n - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] >= target) {
                    right--;
                } else {
                    result += right - left; //这里有right - left个结果
                    left++;
                }
            }
        }
        return result;
    }
}
