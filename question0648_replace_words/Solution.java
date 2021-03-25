package question0648_replace_words;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

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
  }

  public String replaceWords(List<String> dictionary, String sentence) {
    Trie trie = new Trie();
    for (String word : dictionary) {
      trie.insert(word);
    }
    String[] words = sentence.split("\\s+");
    StringBuilder sb = new StringBuilder();
    for (String word : words) {
      TrieNode cur = trie.root;
      boolean replaced = false;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (null == cur.next.get(c)) {
          break;
        }
        cur = cur.next.get(c);
        if (cur.word != null) {
          sb.append(" ").append(cur.word);
          replaced = true;
          break;
        }
      }
      if (!replaced) {
        sb.append(" ").append(word);
      }
    }
    return sb.substring(1);
  }

}