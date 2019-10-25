package question0010_regular_expression_matching;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82010888
 *
 * 递归实现。
 *
 * 执行用时：312ms，击败8.95%。消耗内存：111.6MB，击败5.03%。
 */
public class Solution1 {
    public boolean isMatch(String s, String p) {
        int ns = s.length(), np = p.length();
        if (ns == 0 && np == 0) {
            return true;
        }
        if (ns != 0 && np == 0) {
            return false;
        }
        //当s为空串时，只有当p是"a*b*c*"的形式时，才有可能匹配
        if (ns == 0) {
            if ((np & 1) == 1) {
                return false;
            }
            int i = 1;
            while (i < p.length() && p.charAt(i) == '*') {
                i += 2;
            }
            return i == p.length() + 1;
        }
        //当s中最后一个字符和p中最后一个字符相匹配（有两种情形：1-s中最后一个字符和p中最后一个字符相等；2-p中最后一个字符是'.'）时，
        //去看s中除去最后一个字符的子串能否和p中除去最后一个字符的子串相匹配
        if (s.charAt(ns - 1) == p.charAt(np - 1) || p.charAt(np - 1) == '.') {
            return isMatch(s.substring(0, ns - 1), p.substring(0, np - 1));
        }
        //如果p中最后一个字符是'*'
        if (p.charAt(np - 1) == '*') {
            //如果s中最后一个字符无法与p中最后第二个字符相匹配（即s中最后一个字符和p中最后第二个字符不相等，且p中最后第二个字符不是'.'），
            //去看s能否和p中除去最后两个字符的子串相匹配
            if (s.charAt(ns - 1) != p.charAt(np - 2) && p.charAt(np - 2) != '.') {
                return isMatch(s, p.substring(0, np - 2));
            }
            //1-s除去最后一个字符的子串能否和p相匹配，即s中最后一个字符与p中最后的'*'相匹配
            //2-s除去最后一个字符的子串能否和p除去最后两个字符的子串相匹配，即s中最后一个字符与p中倒数第二个字符相匹配
            //3-s能否和p除去最后两个字符的子串相匹配，即s中最后一个字符既不与p中最后的'*'相匹配，也不与p中倒数第二个字符相匹配
            return isMatch(s.substring(0, ns - 1), p) || isMatch(s.substring(0, ns - 1), p.substring(0, np - 2)) || isMatch(s, p.substring(0, np - 2));
        }
        return false;
    }
}
