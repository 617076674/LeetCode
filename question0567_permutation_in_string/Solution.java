package question0567_permutation_in_string;

/**
 * 滑动窗口法。
 *
 * 时间复杂度是O(n1 + n2)，其中n1为字符串s1的长度，n2为字符串s2的长度。空间复杂度是O(1)。
 *
 * 执行用时：10ms，击败57.67%。消耗内存：39.6MB，击败18.75%。
 */
public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int[] window = new int[26], s1Map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
        }
        int left = 0, right = 0, need = s1.length();
        while (right < s2.length()) {
            char cRight = s2.charAt(right);
            window[cRight - 'a']++;
            if (window[cRight - 'a'] <= s1Map[cRight - 'a']) {
                need--;
            }
            right++;
            while (right - left > s1.length()) {
                char cLeft = s2.charAt(left);
                left++;
                window[cLeft - 'a']--;
                if (window[cLeft - 'a'] < s1Map[cLeft - 'a']) {
                    need++;
                }
            }
            if (right - left == s1.length() && need == 0) {
                return true;
            }
        }
        return false;
    }

}