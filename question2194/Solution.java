package question2194;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<String> cellsInRange(String s) {
    int col1 = s.charAt(0) - 'A';
    int col2 = s.charAt(3) - 'A';
    int row1 = s.charAt(1) - '1';
    int row2 = s.charAt(4) - '1';
    List<String> result = new ArrayList<>();
    for (int col = col1; col <= col2; col++) {
      for (int row = row1; row <= row2; row++) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) ('A' + col));
        sb.append((char) ('1' + row));
        result.add(sb.toString());
      }
    }
    return result;
  }

}