package question1247_minimum_swaps_to_make_strings_equal;

public class Solution {

  public int minimumSwap(String s1, String s2) {
    int countX = 0, countY = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (s1.charAt(i) == 'x') {
          countX++;
        } else {
          countY++;
        }
      }
    }
    if (((countX + countY) & 1) == 1) {
      return -1;
    }
    int result = countX / 2 + countY / 2;
    if ((countX & 1) == 1) {
      result += 2;
    }
    return result;
  }

}