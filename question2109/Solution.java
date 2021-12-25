package question2109;

import java.util.Arrays;

public class Solution {

  public String addSpaces(String s, int[] spaces) {
    StringBuilder sb = new StringBuilder();
    Arrays.sort(spaces);
    int spaceIndex = 0;
    for (int i = 0; i < s.length(); i++) {
      if (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
        sb.append(" ");
        spaceIndex++;
      }
      sb.append(s.charAt(i));
    }
    return sb.toString();
  }

}