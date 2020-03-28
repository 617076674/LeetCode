package question0820_short_encoding_of_words;

/**
 * 前缀树。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为words数组中的字符个数。
 *
 * 执行用时：22ms，击败69.31%。消耗内存：44.1MB，击败6.06%。
 */
public class Solution {
    private class TrieNode {
        boolean isWord;

        TrieNode[] next = new TrieNode[26];
    }

    private int result;

    private int count;

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new TrieNode();
                }
                cur = cur.next[c - 'a'];
            }
            cur.isWord = true;
        }
        dfs(root, 0);
        return result + count;
    }

    private void dfs(TrieNode trieNode, int step) {
        boolean hasNext = false;
        for (int i = 0; i < 26; i++) {
            if (null != trieNode.next[i]) {
                hasNext = true;
                dfs(trieNode.next[i], step + 1);
            }
        }
        if (!hasNext && trieNode.isWord) {
            result += step;
            count++;
        }
    }
}