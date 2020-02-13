package question1071_greatest_common_divisor_of_strings;

/**
 * 字符串str1和字符串str2存在最大公因子的充要条件是(str1 + str2).equals(str2 + str1)。
 *
 * 当确定有解的情况下，最优解是长度为gcd(str1.length, str2.length)的字符串。
 *
 * 执行用时：1ms，击败95.96%。消耗内存：42.8MB，击败5.26%。
 */
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}