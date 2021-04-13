package question0816_ambiguous_coordinates;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<String> ambiguousCoordinates(String S) {
    List<String> result = new ArrayList<>();
    for (int i = 2; i < S.length() - 1; i++) {
      for (String left : make(S, 1, i)) {
        for (String right : make(S, i, S.length() - 1)) {
          result.add("(" + left + ", " + right + ")");
        }
      }
    }
    return result;
  }

  private List<String> make(String S, int i, int j) {
    List<String> result = new ArrayList<>();
    for (int d = 1; d <= j - i; d++) {
      String left = S.substring(i, i + d), right = S.substring(i + d, j);
      if ((!left.startsWith("0") || left.equals("0")) && !right.endsWith("0")) {
        result.add(left + (d < j - i ? "." : "") + right);
      }
    }
    return result;
  }

}