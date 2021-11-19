package question2027_minimum_moves_to_convert_string;

public class Solution {

  public int minimumMoves(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'X') {
        result++;
        i += 2;
      }
    }
    return result;
  }

}