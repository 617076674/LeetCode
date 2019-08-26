package question0567;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口法。
 *
 * 时间复杂度是O(n1 + n2)，其中n1为字符串s1的长度，n2为字符串s2的长度。空间复杂度是O(n1)。
 *
 * 执行用时：157ms，击败15.35%。消耗内存：42.9MB，击败37.86%。
 */
public class Solution1 {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 == 0) {
            return true;
        }
        if (n2 == 0) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            char c = s1.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int left = 0, right = -1;
        Map<Character, Integer> window = new HashMap<>();
        while (right + 1 < n2) {
            right++;
            char c = s2.charAt(right);
            if (window.containsKey(c)) {
                window.put(c, window.get(c) + 1);
            } else {
                window.put(c, 1);
            }
            if (!map.containsKey(c)) {
                left = right + 1;
                if (left >= n2) {
                    break;
                }
                window.clear();
            } else if (map.get(c) < window.get(c)) {
                while (map.get(c) < window.get(c)) {
                    window.put(s2.charAt(left), window.get(s2.charAt(left)) - 1);
                    if (window.get(s2.charAt(left)) == 0) {
                        window.remove(s2.charAt(left));
                    }
                    left++;
                }
            }
            if (window.equals(map)) {
                return true;
            }
        }
        return false;
    }
}
