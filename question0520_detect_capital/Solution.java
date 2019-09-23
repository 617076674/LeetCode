package question0520_detect_capital;

/**
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败96.48%。消耗内存：34.7MB，击败93.17%。
 */
public class Solution {
    public boolean detectCapitalUse(String word) {
        int n;
        if (null == word || (n = word.length()) == 0) {
            return true;
        }
        int count = 0;  //计算大写字母个数
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                count++;
            }
        }
        return count == n || count == 0 || (count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');
    }
}
