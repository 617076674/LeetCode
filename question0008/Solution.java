package question0008;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81937330
 * <p>
 * 时间复杂度是O(n)，其中n为字符串str的长度。空间复杂度是O(1)。
 * <p>
 * 执行用时：13ms，击败42.67%。消耗内存：36.8MB，击败83.10%。
 */
public class Solution {
    public int myAtoi(String str) {
        int n = str.length(), i = 0;
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        //如果str就是一个只含有空格的串
        //或者str除去前缀空格后的第一个字符不是 '+' 或 '-' 或 数字
        if (i == n || !((str.charAt(i) == '+') || (str.charAt(i) == '-')
                || (str.charAt(i) >= '0' && str.charAt(i) <= '9'))) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (str.charAt(i) == '-') {
            stringBuilder.append('-');
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        //如果str除去空格之后只包含 '+' 或 '-'
        //或者str除去空格以及'+'或'-'后的第一个字符不是一个数字
        if (i == n || !(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
            return 0;
        }
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            stringBuilder.append(str.charAt(i));
            i++;
        }
        //利用异常来处理溢出问题
        try {
            return Integer.valueOf(stringBuilder.toString());
        } catch (Exception e) {
            if (stringBuilder.substring(0, 1).equals("-")) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
    }
}
