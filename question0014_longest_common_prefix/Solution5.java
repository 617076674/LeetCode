package question0014_longest_common_prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典树。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为数组 strs 中的字符个数。
 *
 * 执行用时：3ms，击败23.61%。消耗内存：38MB，击败5.84%。
 */
public class Solution5 {
    private class TrieNode {
        boolean isWord;

        Map<Character, TrieNode> next = new HashMap<>();
    }

    private class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String s) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.next.get(c) == null) {
                    cur.next.put(c, new TrieNode());
                }
                cur = cur.next.get(c);
            }
            cur.isWord = true;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str);
        }
        TrieNode cur = trie.root;
        StringBuilder sb = new StringBuilder();
        while (!cur.isWord && cur.next.size() == 1) {
            char c = cur.next.keySet().iterator().next();
            sb.append(c);
            cur = cur.next.get(c);
        }
        return sb.toString();
    }
}