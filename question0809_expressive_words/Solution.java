package question0809_expressive_words;

public class Solution {

  public int expressiveWords(String S, String[] words) {
    int result = 0;
    for (String word : words) {
      if (judge(S, word)) {
        result++;
      }
    }
    return result;
  }

  private boolean judge(String s, String word) {
    int index1 = 0, index2 = 0;
    while (index1 < s.length() && index2 < word.length()) {
      if (s.charAt(index1) != word.charAt(index2)) {
        return false;
      }
      int len1 = 1;
      while (index1 + 1 < s.length() && s.charAt(index1) == s.charAt(index1 + 1)) {
        index1++;
        len1++;
      }
      index1++;
      int len2 = 1;
      while (index2 + 1 < word.length() && word.charAt(index2) == word.charAt(index2 + 1)) {
        index2++;
        len2++;
      }
      index2++;
      if (len1 < len2 || (len1 < 3 && len1 != len2)) {
        return false;
      }
    }
    return index1 == s.length() && index2 == word.length();
  }

}