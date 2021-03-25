package question0676_implement_magic_dictionary;

import java.util.HashMap;
import java.util.Map;

public class MagicDictionary {

  private class TrieNode {
    String word;

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
      cur.word = s;
    }

    boolean findWord(String s, TrieNode trieNode) {
      TrieNode cur = trieNode;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        cur = cur.next.get(c);
        if (null == cur) {
          return false;
        }
      }
      return cur.word != null;
    }
  }

  private Trie trie = new Trie();

  /**
   * Initialize your data structure here.
   */
  public MagicDictionary() {

  }

  public void buildDict(String[] dictionary) {
    for (String word : dictionary) {
      trie.insert(word);
    }
  }

  public boolean search(String searchWord) {
    return search(searchWord, 0, 1, trie.root);
  }

  private boolean search(String searchWord, int i, int num, TrieNode trieNode) {
    if (num < 0) {
      return false;
    }
    if (i == searchWord.length()) {
      return num == 0 && trieNode.word != null;
    }
    for (Map.Entry<Character, TrieNode> entry : trieNode.next.entrySet()) {
      if (entry.getKey() == searchWord.charAt(i)) {
        if (search(searchWord, i + 1, num, entry.getValue())) {
          return true;
        }
      } else if (search(searchWord, i + 1, num - 1, entry.getValue())) {
        return true;
      }
    }
    return false;
  }

}