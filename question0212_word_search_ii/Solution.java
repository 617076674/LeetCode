package question0212_word_search_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 构建前缀树，再回溯法。
 */
public class Solution {

  private List<String> result = new ArrayList<>();

  private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public List<String> findWords(char[][] board, String[] words) {
    TrieNode trieNode = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, trieNode);
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
    for (int[] direction : directions) {
        int nextI = i + direction[0], nextJ = j + direction[1];
        if (nextI >= 0 && nextI < board.length && nextJ >= 0 && nextJ < board[0].length) {
            dfs(board, nextI, nextJ, trieNode);
        }
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