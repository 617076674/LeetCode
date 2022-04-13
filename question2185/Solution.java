package question2185;

public class Solution {

  public int prefixCount(String[] words, String pref) {
    int result = 0;
    for (String word : words) {
      if (word.startsWith(pref)) {
        result++;
      }
    }
    return result;
  }

}