package question0139_word_break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O(s.length() * wordDict.size())。空间复杂度是 O(s.length() + wordDict.size())。
 *
 * 执行用时：3ms，击败95.01%。消耗内存：39.5MB，击败8.00%。
 */
public class Solution1 {
    private int[] memo;

    private Set<String> wordSet;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        wordSet = new HashSet<>(wordDict);
        return wordBreak(s, 0);
    }
    
    private boolean wordBreak(String s, int index) {
        if (memo[index] == 1) {
            return true;
        } else if (memo[index] == -1) {
            return false;
        }
        if (wordSet.contains(s.substring(index))) {
            memo[index] = 1;
            return true;
        }
        for (String word : wordSet) {
            if (index + word.length() <= s.length() && word.equals(s.substring(index, index + word.length()))
                    && wordBreak(s, index + word.length())) {
                memo[index] = 1;
                return true;
            }
        }
        memo[index] = -1;
        return false;
    }
}