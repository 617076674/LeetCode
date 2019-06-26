package question0014;

/**
 * 暴力破解法。
 * <p>
 * 执行用时：3ms，击败71.31%。消耗内存：36MB，击败87.70%。
 */
public class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
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
                stringBuilder.append(temp);
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
