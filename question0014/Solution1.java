package question0014;

/**
 * 暴力破解法一：们从前往后枚举字符串的每一列，比较每个字符串相同列上的字符是否相同。
 *
 * 时间复杂度是O(n * m)，其中n为strs数组的大小，m为结果的长度。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败71.31%。消耗内存：36MB，击败87.70%。
 */
public class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);
            boolean same = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != temp) {
                    same = false;
                    break;
                }
            }
            if (same) {
                sb.append(temp);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
