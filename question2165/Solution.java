package question2165;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

  public long smallestNumber(long num) {
    if (num == 0) {
      return 0;
    }
    if (num < 0) {
      List<Long> digits = new ArrayList<>();
      long temp = -num;
      while (temp != 0) {
        digits.add(temp % 10L);
        temp /= 10;
      }
      Collections.sort(digits, new Comparator<Long>() {
        @Override
        public int compare(Long o1, Long o2) {
          return (int) (o2 - o1);
        }
      });
      long result = 0;
      for (long digit : digits) {
        result = result * 10 + digit;
      }
      return -result;
    }
    long temp = num;
    List<Long> digits = new ArrayList<>();
    long min = Integer.MAX_VALUE;
    while (temp != 0) {
      digits.add(temp % 10L);
      if (temp % 10 != 0) {
        min = Math.min(min, temp % 10L);
      }
      temp /= 10;
    }
    digits.remove(min);
    Collections.sort(digits);
    long result = min;
    for (long digit : digits) {
      result = result * 10 + digit;
    }
    return result;
  }

}