package question1071_greatest_common_divisor_of_strings;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(max(n1, n2) * σ(gcd(n1, n2)))，其中n1为字符串str1的长度，n2为字符串str2的长度，gcd(n1, n2)为n1和n2的最大公约数，
 * σ(gcd(n1, n2))为n1和n2的最大公约数的约数个数。空间复杂度是O(n1 + n2)。
 *
 * 执行用时：1ms，击败93.63%。消耗内存：38.3MB，击败12.00%。
 */
public class Solution1 {
    public String gcdOfStrings(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        for (int i = Math.max(n1, n2); i >= 1; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                String tmp = str1.substring(0, i);
                if (check(str1, tmp) && check(str2, tmp)) {
                    return tmp;
                }
            }
        }
        return "";
    }

    private boolean check(String str, String tmp) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < str.length()) {
            sb.append(tmp);
        }
        return str.equals(sb.toString());
    }
}