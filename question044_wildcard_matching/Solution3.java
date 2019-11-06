package question044_wildcard_matching;

/**
 * 递归。对Solution1的改进。
 *
 * 在递归过程中，如果字符串p的最后一个字符是'*'，我们只需要去判断字符串s能否与字符串p去除最后一个字符后的字符串相匹配或者字符串s去除最
 * 后一个字符后的字符串能否与字符串p相匹配。这里的分类方法变成了不使用该最后一个字符'*'去匹配或者使用该最后一个字符'*'去匹配。
 */
public class Solution3 {
    public boolean isMatch(String s, String p) {
        int ns = s.length(), np = p.length();
        if (np == 0) {
            return ns == 0;
        }
        if (ns == 0) {
            for (int i = 0; i < np; i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (p.charAt(np - 1) == '?' || s.charAt(ns - 1) == p.charAt(np - 1)) {
            return isMatch(s.substring(0, ns - 1), p.substring(0, np - 1));
        }
        if (p.charAt(np - 1) == '*') {
            return isMatch(s.substring(0, ns - 1), p.substring(0, np)) || isMatch(s.substring(0, ns), p.substring(0, np - 1));
        }
        return false;
    }
}