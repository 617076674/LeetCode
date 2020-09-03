package lcof20_biao_shi_shu_zhi_de_zi_fu_chuan;

/**
 * 时间复杂度是 O(n)，其中 n 为字符串 s 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：3ms，击败54.75%。消耗内存：39.7MB，击败58.10%。
 */
public class Solution {
    private int index;

    public boolean isNumber(String s) {
        int n;
        if (null == s) {
            return false;
        }
        s = s.trim();
        if ((n = s.length()) == 0) {
            return false;
        }
        boolean flag = scanInteger(s);
        if (index < n && s.charAt(index) == '.') {
            index++;
            //1.小数可以没有整数部分，如.123等于0.123
            //2.小数点后面可以没有数字，如233.等于233.0
            //3.小数点前面和后面可以都有数字，如233.666
            flag = scanUnsignedInteger(s) || flag;
        }
        if (index < n && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
            index++;
            //1.当e或E前面没有数字时，制衡个字符串不能表示数字，如.e1、e1
            //2.当e或E后面没有整数时，整个字符串不能表示数字，如12e、12e+5.4
            flag = flag && scanInteger(s);
        }
        return flag && index == s.length();
    }

    private boolean scanInteger(String s) {
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            index++;
        }
        return scanUnsignedInteger(s);
    }

    private boolean scanUnsignedInteger(String s) {
        int tmp = index;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            index++;
        }
        return index > tmp;
    }
}