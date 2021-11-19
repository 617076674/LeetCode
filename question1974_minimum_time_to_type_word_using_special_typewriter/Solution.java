package question1974_minimum_time_to_type_word_using_special_typewriter;

public class Solution {

  public int minTimeToType(String word) {
    char cur = 'a';
    int result = 0;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c > cur) {
        result += Math.min(c - cur, cur - c + 26) + 1;
      } else {
        result += Math.min(cur - c, c - cur + 26) + 1;
      }
      cur = c;
    }
    return result;
  }

}