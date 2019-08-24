package question0487;

/**
 * 双指针。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：9ms，击败55.88%。消耗内存：50.6MB，击败100.00%。
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return 0;
        }
        int left = 0, right = -1, result = 0;
        boolean flag = false;   //标记我们的滑动窗口[left, right]范围内有没有0
        while (right + 1 < n) {
            right++;
            if (nums[right] == 0) {    //如果right位置处的值是0
                if (flag) { //如果[left, right - 1]处已经出现过了0
                    while (nums[left] != 0) {
                        left++;
                    }
                    left++;
                } else {    //如果[left, right - 1]处还没有出现过0
                    flag = true;
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
