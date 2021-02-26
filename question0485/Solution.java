package question0485;

/**
 * 用pre指针记录前一个0出现的位置。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：6ms，击败47.49%。消耗内存：51.1MB，击败37.07%。
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int pre = -1, result = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (pre == -1) {
                    result = Math.max(result, i);
                } else {
                    result = Math.max(result, i - pre - 1);
                }
                pre = i;
            } else if (nums[i] == 1 && i == n - 1) {
                if (pre == -1) {
                    return n;
                } else {
                    result = Math.max(result, n - pre - 1);
                }
            }
        }
        return result;
    }

}