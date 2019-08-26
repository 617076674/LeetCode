package question0567;

import java.util.Arrays;

/**
 * 滑动窗口法。
 *
 * 时间复杂度是O(n1 + n2)，其中n1为字符串s1的长度，n2为字符串s2的长度。空间复杂度是O(1)。
 *
 * 执行用时：22ms，击败37.54%。消耗内存：39.2MB，击败83.30%。
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 == 0) {
            return true;
        }
        if (n2 == 0) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < n1; i++) {
            map[s1.charAt(i) - 'a']++;
        }
        int left = 0, right = -1;
        int[] window = new int[26];
        while (right + 1 < n2) {
            right++;
            window[s2.charAt(right) - 'a']++;
            if (map[s2.charAt(right) - 'a'] == 0) {
                left = right + 1;
                if (left >= n2) {
                    break;
                }
                Arrays.fill(window, 0);
            } else if (map[s2.charAt(right) - 'a'] < window[s2.charAt(right) - 'a']) {
                while (map[s2.charAt(right) - 'a'] < window[s2.charAt(right) - 'a']) {
                    window[s2.charAt(left) - 'a']--;
                    left++;
                }
            }
            if (Arrays.equals(window, map)) {
                return true;
            }
        }
        return false;
    }
}
