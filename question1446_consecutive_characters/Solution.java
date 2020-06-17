package question1446_consecutive_characters;

/**
 * 时间复杂度是 O(s.length())。空间复杂度是 O(1)。
 *
 * 执行用时：2ms，击败45.32%。消耗内存：38.3MB，击败100.00%。
 */
public class Solution {
    public int maxPower(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j + 1 < s.length() && s.charAt(j + 1) == s.charAt(i)) {
                j++;
            }
            result = Math.max(result, j - i + 1);
            i = j;
        }
        return result;
    }
}