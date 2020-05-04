package question0076_minimum_window_substring;

/**
 * 滑动窗口法。
 *
 * 时间复杂度是O(n1 + n2)，其中n1为字符串s的长度，n2为字符串t的长度。空间复杂度是O(1)。
 *
 * 执行用时：8ms，击败77.99%。消耗内存：40.1MB，击败13.33%。
 */
public class Solution {
    public String minWindow(String s, String t) {
        int[] window = new int[256], tMap = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tMap[t.charAt(i)]++;
        }
        String result = s + "a";
        int left = 0, right = 0, need = t.length();
        while (right < s.length()) {
            char cRight = s.charAt(right);
            window[cRight]++;
            if (window[cRight] <= tMap[cRight]) {
                need--;
            }
            right++;
            while (need == 0) {
                if (right - left < result.length()) {
                    result = s.substring(left, right);
                }
                char cLeft = s.charAt(left);
                window[cLeft] = window[cLeft] - 1;
                if (window[cLeft] < tMap[cLeft]) {
                    need++;
                }
                left++;
            }
        }
        return result.length() == s.length() + 1 ? "" : result;
    }
}