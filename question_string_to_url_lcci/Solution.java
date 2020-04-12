package question_string_to_url_lcci;

/**
 * 执行用时：19ms，击败63.58%。消耗内存：47.7MB，击败100.00%。
 */
public class Solution {
    public String replaceSpaces(String S, int length) {
        int space = 0;
        for (int i = 0; i < Math.min(S.length(), length); i++) {
            if (S.charAt(i) == ' ') {
                space++;
            }
        }
        char[] result = new char[Math.min(S.length(), length) + space * 2];
        int index = result.length - 1;
        for (int i = Math.min(S.length(), length) - 1; i >= 0; i--) {
            if (S.charAt(i) == ' ') {
                result[index--] = '0';
                result[index--] = '2';
                result[index--] = '%';
            } else {
                result[index--] = S.charAt(i);
            }
        }
        return String.valueOf(result);
    }
}