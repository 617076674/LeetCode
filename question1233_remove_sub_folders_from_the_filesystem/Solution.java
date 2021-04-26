package question1233_remove_sub_folders_from_the_filesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  private static class TrieNode {
    boolean isWord;

    Map<Character, TrieNode> next = new HashMap<>();
  }

  private static class Trie {
    TrieNode root;

    Trie() {
      root = new TrieNode();
    }

    boolean insert(String s) {
      TrieNode cur = root;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (cur.next.get(c) == null) {
          cur.next.put(c, new TrieNode());
        }
        cur = cur.next.get(c);
          if (cur.isWord && i + 1 < s.length() && s.charAt(i + 1) == '/') {
              return false;
          }
      }
      cur.isWord = true;
      return true;
    }
  }

  public List<String> removeSubfolders(String[] folder) {
    Arrays.sort(folder, Comparator.comparingInt(String::length));
    List<String> result = new ArrayList<>();
    Trie trie = new Trie();
    for (String s : folder) {
        if (trie.insert(s)) {
            result.add(s);
        }
    }
    return result;
  }

}