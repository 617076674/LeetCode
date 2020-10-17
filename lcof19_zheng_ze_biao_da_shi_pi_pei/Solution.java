package lcof19_zheng_ze_biao_da_shi_pi_pei;

/**
 * 动态规划。
 *
 * 时间复杂度和空间复杂度均是 O(m * n)，其中 m 为字符串 s 的长度，n 为字符串 p 的长度。
 *
 * 执行用时：2ms，击败99.94%。消耗内存：38.4MB，击败38.43%。
 */
public class Solution {

    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, s.length(), p, p.length());
    }

    // s 中 [0, index1 - 1] 范围内的字符串和 p 中 [0, index2 - 1] 范围内的字符串能否匹配上
    private boolean isMatch(String s, int index1, String p, int index2) {
        if (index1 < 0 || index2 < 0) {
            return false;
        }
        if (index2 == 0) {
            return index1 == 0;
        }
        if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }
        boolean result = false;
        switch (p.charAt(index2 - 1)) {
            case '.':
                result = isMatch(s, index1 - 1, p, index2 - 1);
                break;
            case '*':
                result = isMatch(s, index1, p, index2 - 2);
                if (index1 - 1 >= 0 && (p.charAt(index2 - 2) == '.' || p.charAt(index2 - 2) == s.charAt(index1 - 1))) {
                    result |= isMatch(s, index1 - 1, p, index2) || isMatch(s, index1 - 1, p, index2 - 2);
                }
                break;
            default:
                if (index1 - 1 >= 0 && index2 - 1 >= 0 && p.charAt(index2 - 1) == s.charAt(index1 - 1)) {
                    result = isMatch(s, index1 - 1, p, index2 - 1);
                }
        }
        memo[index1][index2] = result;
        return result;
    }

}