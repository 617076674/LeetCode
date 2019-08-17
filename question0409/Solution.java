package question0409;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianyihui
 * @date 2019-08-17
 *
 * 统计每个字符出现的次数。
 *
 * 对于偶数个数的字符，全部都可加入回文串中。对于奇数个数的字符，其减1后的个数的字符可以加入回文串中。
 *
 * 最后，如果有出现奇数个数的字符，则将结果加1。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串s的长度。
 *
 * 执行用时：18ms，击败14.49%。消耗内存：35.3MB，击败80.56%。
 */
public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int result = 0, max = 0;
        boolean hasOdd = false;
        for (Integer tmp : map.values()) {
            if ((tmp & 1) == 0) {
                result += tmp;
            } else {
                hasOdd = true;
                result += tmp - 1;
            }
        }
        if (hasOdd) {
            result++;
        }
        return result;
    }
}