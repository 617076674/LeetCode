package question0055;

/**
 * @author qianyihui
 * @date 2019-08-08
 *
 * 递归。
 *
 * 时间复杂度是O(2 ^ n)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution1 {
    public boolean canJump(int[] nums) {
        return canJump(0, nums);
    }

    /**
     * 能否从index处跳到数组末
     */
    private boolean canJump(int index, int[] nums) {
        int n = nums.length;
        if (index == n - 1) {
            return true;
        }
        for (int i = index + 1; i <= Math.min(index + nums[index], n - 1); i++) {
            if (canJump(i, nums)) {
                return true;
            }
        }
        return false;
    }
}
