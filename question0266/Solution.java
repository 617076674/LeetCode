package question0266;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。
 *
 * 可以排列成回文串的条件是：字符串s中要么没有出现次数为奇数的字符，要么出现次数为奇数的字符只有1个。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串s的长度。
 *
 * 执行用时：3ms，击败61.90%。消耗内存：35MB，击败100.00%。
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int oddCount = 0;
        for (Character c : map.keySet()) {
            if ((map.get(c) & 1) == 1) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
}
