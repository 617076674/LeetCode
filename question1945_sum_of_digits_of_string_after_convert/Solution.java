package question1945_sum_of_digits_of_string_after_convert;

public class Solution {

  public int getLucky(String s, int k) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      sb.append(s.charAt(i) - 'a' + 1);
    }
    int num = 0;
    for (int j = 0; j < sb.length(); j++) {
      num += sb.charAt(j) - '0';
    }
    for (int i = 1; i < k; i++) {
      int temp = 0;
      while (num > 0) {
        temp += num % 10;
        num /= 10;
      }
      num = temp;
    }
    return num;
  }

}