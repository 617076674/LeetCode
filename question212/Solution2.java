package question212;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trieNode = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, trieNode);
            }
        }
        return result;
    }
    public void dfs(char[][] board, int i, int j, TrieNode trieNode) {
        char c = board[i][j];
        if ('#' == c || null == trieNode.next[c - 'a']) return;
        trieNode = trieNode.next[c - 'a'];
        if (null != trieNode.word) {
            result.add(trieNode.word);
            trieNode.word = null;     //去重
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,trieNode);
        if (j > 0) dfs(board, i, j - 1, trieNode);
        if (i < board.length - 1) dfs(board, i + 1, j, trieNode);
        if (j < board[0].length - 1) dfs(board, i, j + 1, trieNode);
        board[i][j] = c;
    }
    private class TrieNode {
        private TrieNode[] next = new TrieNode[26];
        private String word;
    }
    public TrieNode buildTrie(String[] words) {
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
