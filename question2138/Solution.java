package question2138;

import java.util.Arrays;

public class Solution {

  public String[] divideString(String s, int k, char fill) {
    int size = s.length() / k;
    if (s.length() % k != 0) {
      size++;
    }
    String[] result = new String[size];
    for (int i = 0; i < result.length; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = i * k; j < (i + 1) * k; j++) {
        if (j < s.length()) {
          sb.append(s.charAt(j));
        } else {
          sb.append(fill);
        }
      }
      result[i] = sb.toString();
    }
    return result;
  }

}