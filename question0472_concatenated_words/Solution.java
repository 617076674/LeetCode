package question0472_concatenated_words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 执行用时：57ms，击败77.89%。消耗内存：56.4MB，击败17.39%。
 */
public class Solution {

  private TrieNode root = new TrieNode();

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Arrays.sort(words, Comparator.comparingInt(String::length));
    List<String> result = new ArrayList<>();
    for (String word : words) {
      if (word.length() > 0) {
        boolean[] visited = new boolean[word.length()];
        if (dfs(word, root, 0, visited)) {
          result.add(word);
        } else {
          TrieNode cur = root;
          for (int i = 0; i < word.length(); i++) {
            int num = word.charAt(i) - 'a';
            TrieNode trieNode = cur.next[num];
            if (null == trieNode) {
              cur.next[num] = new TrieNode();
            }
            cur = cur.next[num];
          }
          if (!cur.isWord) {
            cur.isWord = true;
          }
        }
      }
    }
    return result;
  }

  private boolean dfs(String word, TrieNode trieNode, int index, boolean[] visited) {
    if (index == word.length()) {
      return true;
    }
    if (visited[index]) {
      return false;
    }
    visited[index] = true;
    for (int i = index; i < word.length(); i++) {
      int num = word.charAt(i) - 'a';
      if (trieNode.next[num] == null) {
        return false;
      }
      trieNode = trieNode.next[num];
      if (trieNode.isWord && dfs(word, root, i + 1, visited)) {
        return true;
      }
    }
    return false;
  }

  private class TrieNode {
    private boolean isWord; //判断是否是一个单词

    private TrieNode[] next;  //指向next节点

    TrieNode() {
      this.next = new TrieNode[26];
    }
  }

}