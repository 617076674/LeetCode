package question0003_longest_substring_without_repeating_characters;

import java.util.Arrays;

/**
 * 对Solution2的优化。
 *
 * 执行用时：9ms，击败94.74%。消耗内存：39MB，击败84.02%。
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[256];  //记录某字符最近出现的索引
        Arrays.fill(last, -1);
        int left = 0, right = -1, result = 0;
        while (right + 1 < s.length()) {
            right++;
            if (last[s.charAt(right)] != -1) {  //如果说right处的字符重复了
                //将滑动窗口的左指针left指向重复字符的下一个位置，当然，left指针不能左移
                left = Math.max(left, last[s.charAt(right)] + 1);
            }
            result = Math.max(result, right - left + 1);
            last[s.charAt(right)] = right;
        }
        return result;
    }
}