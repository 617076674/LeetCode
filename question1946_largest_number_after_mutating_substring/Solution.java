package question1946_largest_number_after_mutating_substring;

public class Solution {

  public String maximumNumber(String num, int[] change) {
    StringBuilder sb = new StringBuilder();
    boolean findFirst = true, findLast = false;
    for (int i = 0; i < num.length(); i++) {
      char c = num.charAt(i);
      if (findFirst) {
        if (change[c - '0'] > c - '0') {
          sb.append(change[c - '0']);
          findFirst = false;
          findLast = true;
        } else {
          sb.append(c);
        }
      } else if (findLast) {
        if (change[c - '0'] < c - '0') {
          sb.append(c);
          findLast = false;
        } else {
          sb.append(change[c - '0']);
        }
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

}