package question0438_find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] window = new int[26], pMap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pMap[p.charAt(i) - 'a']++;
        }
        int left = 0, right = 0, need = p.length();
        List<Integer> result = new ArrayList<>();
        while (right < s.length()) {
            char cRight = s.charAt(right);
            right++;
            window[cRight - 'a']++;
            if (window[cRight - 'a'] <= pMap[cRight - 'a']) {
                need--;
            }
            while (right - left > p.length()) {
                char cLeft = s.charAt(left);
                left++;
                window[cLeft - 'a']--;
                if (window[cLeft - 'a'] < pMap[cLeft - 'a']) {
                    need++;
                }
            }
            if (right - left == p.length() && need == 0) {
                result.add(left);
            }
        }
        return result;
    }
}