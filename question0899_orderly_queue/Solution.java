package question0899_orderly_queue;

import java.util.Arrays;

public class Solution {

  public String orderlyQueue(String s, int k) {
    if (k == 1) {
      String result = s;
      for (int i = 0; i < s.length(); i++) {
        String temp = s.substring(i) + s.substring(0, i);
        if (temp.compareTo(result) < 0) {
          result = temp;
        }
      }
      return result;
    }
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

}