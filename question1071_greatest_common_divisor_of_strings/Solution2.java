package question1071_greatest_common_divisor_of_strings;

/**
 * 如果存在一个符合要求的字符串X，那么也一定存在一个符合要求的字符串X'，它的长度为str1和str2长度的最大公约数。
 *
 * 时间复杂度和空间复杂度均是O(n1 + n2)，其中n1为字符串str1的长度，n2为字符串str2的长度。
 *
 * 执行用时：1ms，击败93.63%。消耗内存：38.7MB，击败8.80%。
 */
public class Solution2 {
    public String gcdOfStrings(String str1, String str2) {
        int gcd = gcd(str1.length(), str2.length());
        String tmp = str1.substring(0, gcd);
        if (check(str1, tmp) && check(str2, tmp)) {
            return tmp;
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

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}