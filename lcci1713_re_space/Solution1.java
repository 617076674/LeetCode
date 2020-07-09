package lcci1713_re_space;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为 sentence 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：1824ms，击败5.23%。消耗内存：41.1MB，击败100.00%。
 */
public class Solution1 {
    private Set<String> set = new HashSet<>();

    private int[] memo;

    public int respace(String[] dictionary, String sentence) {
        for (String s : dictionary) {
            set.add(s);
        }
        memo = new int[sentence.length()];
        Arrays.fill(memo, -1);
        return minUnrecognized(sentence, 0);
    }

    private int minUnrecognized(String sentence, int index) {
        if (index == sentence.length() || set.contains(sentence.substring(index))) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int result = Integer.MAX_VALUE;
        for (int i = index + 1; i <= sentence.length(); i++) {
            if (set.contains(sentence.substring(index, i))) {
                result = Math.min(result, minUnrecognized(sentence, i));
            } else {
                result = Math.min(result, minUnrecognized(sentence, i) + i - index);
            }
        }
        memo[index] = result;
        return result;
    }
}