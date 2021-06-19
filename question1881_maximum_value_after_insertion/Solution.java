package question1881_maximum_value_after_insertion;

public class Solution {

  public String maxValue(String n, int x) {
    if (n.charAt(0) == '-') {
      for (int i = 1; i < n.length(); i++) {
        if (n.charAt(i) - '0' > x) {
          return n.substring(0, i) + x + n.substring(i);
        }
      }
      return n + x;
    }
    for (int i = 0; i < n.length(); i++) {
      if (n.charAt(i) - '0' < x) {
        return n.substring(0, i) + x + n.substring(i);
      }
    }
    return n + x;
  }

}