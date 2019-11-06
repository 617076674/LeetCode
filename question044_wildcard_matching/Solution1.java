package question044_wildcard_matching;

/**
 * 递归实现。
 *
 * 递归终止条件：
 * （1）当字符串p的长度为0时，若字符串s的长度也为0，返回true。若字符串s的长度不为0，返回false。
 * （2）当字符串s的长度为0时，如果此时字符串p中的字符全是'*'，返回true，否则，返回false。
 *
 * 递归过程：
 *
 * （1）如果字符串s的最后一个字符能与字符串p的最后一个字符相匹配，我们递归地去判断字符串s去除最后一个字符后的字符串能否与字符串p去除最后
 * 一个字符后的字符串相匹配。
 * （2）如果字符串p的最后一个字符是'*'，我们需要去判断字符串s能否与字符串p去除最后一个字符后的字符串相匹配、字符串s去除最后一个字符后的
 * 字符串能否与字符串p去除最后一个字符后的字符串相匹配、字符串s去除最后两个字符后的字符串能否与字符串p去除最后一个字符后的字符串相匹配、……、
 * 空字符串能否与字符串p去除最后一个字符后的字符串相匹配。只要这其中有一个能匹配，就应该返回true。如果都不能匹配，返回false。
 * （3）如果不满足前面两种情况，说明字符串s的最后一个字符不能与字符串p的最后一个字符相匹配，直接返回false。
 *
 * 时间复杂度和空间复杂度均是(ns * np)，其中ns为字符串s的长度，np为字符串p的长度。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution1 {
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
            for (int i = 0; i <= ns; i++) {
                if (isMatch(s.substring(0, i), p.substring(0, np - 1))) {
                    return true;
                }
            }
        }
        return false;
    }
}