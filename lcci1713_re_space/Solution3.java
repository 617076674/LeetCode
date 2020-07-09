package lcci1713_re_space;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用 Trie 对 Solution2 进行优化。
 *
 * 时间复杂度是 O(m + n ^ 2)，其中 m 是 dictionary 中的单词数量，n 是 sentence 的长度。空间复杂度是 O(m + n)。
 *
 * 执行用时：14ms，击败99.69%。消耗内存：62.8MB，击败100.00%。
 */
public class Solution3 {
    private class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root = new TrieNode();

    // 将单词倒序插入字典树
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int next = word.charAt(i) - 'a';
            if (cur.children[next] == null) {
                cur.children[next] = new TrieNode();
            }
            cur = cur.children[next];
        }
        cur.isWord = true;
    }

    // 找到 sentence 中以 start 为开头的单词，返回这些单词的结尾下标加 1。
    public List<Integer> search(String sentence, int start) {
        List<Integer> result = new ArrayList<>();
        TrieNode cur = root;
        for (int i = start; i < sentence.length(); i++) {
            int next = sentence.charAt(i) - 'a';
            if (cur.children[next] == null) {
                break;
            }
            cur = cur.children[next];
            if (cur.isWord) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public int respace(String[] dictionary, String sentence) {
        // 构建字典树
        for (String word : dictionary) {
            insert(word);
        }
        // 状态转移，dp[i] 表示字符串的前 i 个字符的最少未匹配数
        int[] dp = new int[sentence.length() + 1];
        for (int i = sentence.length() - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;
            for (int j : search(sentence, i)) {
                dp[i] = Math.min(dp[i], dp[j]);
            }
        }
        return dp[0];
    }
}