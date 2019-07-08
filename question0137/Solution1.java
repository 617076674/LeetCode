package question0137;

/**
 * 分位计算。
 *
 * 对于int数，其由32位组成，对于某一位，如果nums数组中所有的该位值加起来除以3余1，
 * 说明那个只出现1次的数的该位为1，否则那个只出现1次的数该位为0。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败72.89%。消耗内存：37.2MB，击败95.51%。
 */
public class Solution1 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += (nums[j] >> i) & 1;
            }
            if (count % 3 == 1) {
                result |= 1 << i;
            }
        }
        return result;
    }
}
