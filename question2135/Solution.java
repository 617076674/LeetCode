package question2135;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int wordCount(String[] startWords, String[] targetWords) {
    Set<Integer> set = new HashSet<>();
    for (String word : startWords) {
      int num = 0;
      for (int i = 0; i < word.length(); i++) {
        num |= (1 << (word.charAt(i) - 'a'));
      }
      set.add(num);
    }
    int result = 0;
    for (String word : targetWords) {
      Set<Integer> indexSet = new HashSet<>();
      int num = 0;
      for (int i = 0; i < word.length(); i++) {
        int index = word.charAt(i) - 'a';
        indexSet.add(index);
        num |= (1 << index);
      }
      for (int index : indexSet) {
        if (set.contains(num ^ (1 << index))) {
          result++;
          break;
        }
      }
    }
    return result;
  }

}