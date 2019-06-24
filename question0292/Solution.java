package question0292;

/**
 * @author qianyihui
 * @date 2019-06-23
 *
 * 找规律。
 *
 * 时间复杂度和空间复杂度均为O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：34MB，击败11.50%。
 */
public class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
