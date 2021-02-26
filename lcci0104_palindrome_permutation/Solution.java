package lcci0104_palindrome_permutation;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。
 *
 * 执行用时：1ms，击败70.73%。消耗内存：37.1MB，击败100.00%。
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int odd = 0;
        for (int num : map.values()) {
            if ((num & 1) == 1) {
                odd++;
            }
        }
        return odd <= 1;
    }
}