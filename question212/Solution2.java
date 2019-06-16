package question212;

import java.util.ArrayList;
import java.util.List;

/**
 * 构建前缀树，再回溯法。
 *
 * 时间复杂度是O(mnk)，其中m为board的行数，n为board的列数，k是words数组中最长字符串的长度。
 * 空间复杂度是O(p)，其中p是words中的字符数量。
 *
 * 执行用时：33ms，击败80.53%。消耗内存：56.6MB，击败58.11%。
 */
public class Solution2 {

    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trieNode = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, trieNode);
            }
        }
        return result;
    }

    /**
     * 现在位置在(i, j)，考虑该位置是否可以遍历
     */
    public void dfs(char[][] board, int i, int j, TrieNode trieNode) {
        char c = board[i][j];
        //如果该点已经被访问过，或者该点对应的字符无法在前缀树中找到下一个节点
        if ('#' == c || null == trieNode.next[c - 'a']) {
            return;
        }
        trieNode = trieNode.next[c - 'a'];
        if (null != trieNode.word) {
            result.add(trieNode.word);
            trieNode.word = null;     //去重
        }
        board[i][j] = '#';
        if (i > 0) {
            dfs(board, i - 1, j ,trieNode);
        }
        if (j > 0) {
            dfs(board, i, j - 1, trieNode);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, trieNode);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, trieNode);
        }
        board[i][j] = c;
    }

    /**
     * 定义前缀树节点
     */
    private class TrieNode {

        private String word;

        private TrieNode[] next = new TrieNode[26];

    }

    /**
     * 将words数组构建成一棵前缀树
     */
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode trieNode = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (null == trieNode.next[i]) {
                    trieNode.next[i] = new TrieNode();
                }
                trieNode = trieNode.next[i];
            }
            trieNode.word = word;
        }
        return root;
    }

}
