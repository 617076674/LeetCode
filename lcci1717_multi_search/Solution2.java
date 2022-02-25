package lcci1717_multi_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Trie
 */
public class Solution2 {

  private static class Trie {

    private static class TrieNode {

      private String word;

      private TrieNode[] next = new TrieNode[26];

    }

    private TrieNode root = new TrieNode();

    private void insert(String s) {
      TrieNode cur = root;
      for (int i = 0; i < s.length(); i++) {
        int index = s.charAt(i) - 'a';
        if (cur.next[index] == null) {
          cur.next[index] = new TrieNode();
        }
        cur = cur.next[index];
      }
      cur.word = s;
    }

    private List<String> find(String s, int start) {
      List<String> result = new ArrayList<>();
      TrieNode cur = root;
      for (int i = start; i < s.length(); i++) {
        int index = s.charAt(i) - 'a';
        if (cur.next[index] == null) {
          return result;
        }
        cur = cur.next[index];
        if (cur.word != null) {
          result.add(cur.word);
        }
      }
      return result;
    }
  }

  public int[][] multiSearch(String big, String[] smalls) {
    Trie trie = new Trie();
    for (String small : smalls) {
      trie.insert(small);
    }
    Map<String, List<Integer>> str2Idxes = new HashMap<>();
    for (int i = 0; i < big.length(); i++) {
      List<String> list = trie.find(big, i);
      for (String s : list) {
        List<Integer> idxes = str2Idxes.get(s);
        if (null == idxes) {
          idxes = new ArrayList<>();
          idxes.add(i);
          str2Idxes.put(s, idxes);
        } else {
          idxes.add(i);
        }
      }
    }
    int[][] result = new int[smalls.length][];
    for (int i = 0; i < smalls.length; i++) {
      List<Integer> idxes = str2Idxes.getOrDefault(smalls[i], new ArrayList<>());
      result[i] = new int[idxes.size()];
      for (int j = 0; j < idxes.size(); j++) {
        result[i][j] = idxes.get(j);
      }
    }
    return result;
  }

}