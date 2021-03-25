package question0792_number_of_matching_subsequences;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private static class Node {
    String word;
    int index;

    public Node(String w, int i) {
      word = w;
      index = i;
    }
  }

  public int numMatchingSubseq(String S, String[] words) {
    int result = 0;
    List<Node>[] heads = new ArrayList[26];
    for (int i = 0; i < 26; ++i) {
      heads[i] = new ArrayList<>();
    }
    for (String word : words) {
      heads[word.charAt(0) - 'a'].add(new Node(word, 0));
    }
    for (char c : S.toCharArray()) {
      List<Node> oldBucket = heads[c - 'a'];
      heads[c - 'a'] = new ArrayList<>();
      for (Node node : oldBucket) {
        node.index++;
        if (node.index == node.word.length()) {
          result++;
        } else {
          heads[node.word.charAt(node.index) - 'a'].add(node);
        }
      }
    }
    return result;
  }

}

