package lcof46_ba_shu_zi_fan_yi_cheng_zi_fu_chuan;

/**
 * 回溯。
 *
 * 时间复杂度是 O(num)。空间复杂度是 O(log(num))。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.5MB，击败27.32%。
 */
public class Solution {
    private int result;

    public int translateNum(int num) {
        dfs(String.valueOf(num), 0);
        return result;
    }

    private void dfs(String num, int index) {
        if (index == num.length()) {
            result++;
            return;
        }
        dfs(num, index + 1);
        char c1 = num.charAt(index);
        if (index + 1 < num.length()) {
            if (c1 == '2' || c1 == '1') {
                if (c1 == '1' || num.charAt(index + 1) <= '5') {
                    dfs(num, index + 2);
                }
            }
        }
    }
}