package question2227;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Encrypter {

  private Map<Character, String> c2Str = new HashMap<>();

  private Map<String, List<Character>> str2Cs = new HashMap<>();

  private Trie trie = new Trie();

  public Encrypter(char[] keys, String[] values, String[] dictionary) {
    for (String word : dictionary) {
      trie.insert(word);
    }
    for (int i = 0; i < keys.length; i++) {
      c2Str.put(keys[i], values[i]);
      List<Character> list = str2Cs.get(values[i]);
      if (null == list) {
        list = new ArrayList<>();
        list.add(keys[i]);
        str2Cs.put(values[i], list);
      } else {
        list.add(keys[i]);
      }
    }
  }

  public String encrypt(String word1) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < word1.length(); i++) {
      sb.append(c2Str.get(word1.charAt(i)));
    }
    return sb.toString();
  }

  private int cnt;

  public int decrypt(String word2) {
    cnt = 0;
    dfs(word2, 0, trie.root);
    return cnt;
  }

  private void dfs(String word, int index, TrieNode cur) {
    if (index == word.length()) {
      if (cur.word != null) {
        cnt++;
      }
      return;
    }
    List<Character> cList = str2Cs.get(word.substring(index, index + 2));
    if (null == cList || cList.size() == 0) {
      return;
    }
    for (char c : cList) {
      if (cur.next[c - 'a'] != null) {
        dfs(word, index + 2, cur.next[c - 'a']);
      }
    }
  }

  private static class TrieNode {

    String word;

    TrieNode[] next = new TrieNode[26];

  }

  private static class Trie {

    TrieNode root = new TrieNode();

    public void insert(String word) {
      TrieNode cur = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.next[c - 'a'] == null) {
          cur.next[c - 'a'] = new TrieNode();
        }
        cur = cur.next[c - 'a'];
      }
      cur.word = word;
    }

  }

}