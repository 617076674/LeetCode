package lcof48_zui_chang_bu_han_zhong_fu_zi_fu_de_zi_zi_fu_chuan;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = -1, result = 0;
        while (left < s.length()) {
            right++;
            if (right >= s.length()) {
                break;
            }
            Integer last = map.get(s.charAt(right));
            if (null != last) {
                left = Math.max(left, last + 1);
            }
            result = Math.max(result, right - left + 1);
            map.put(s.charAt(right), right);
        }
        return result;
    }

}