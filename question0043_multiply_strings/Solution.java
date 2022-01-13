package question0043_multiply_strings;

public class Solution {

  public String multiply(String num1, String num2) {
    if ("0".equals(num1) || "0".equals(num2)) {
      return "0";
    }
    int[] nums = new int[num1.length() + num2.length() - 1];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < num1.length(); i++) {
      for (int j = 0; j < num2.length(); j++) {
        nums[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
      }
    }
    int num = 0;
    for (int i = num1.length() + num2.length() - 2; i >= 0; i--) {
      num += nums[i];
      sb.append(num % 10);
      num = num / 10;
    }
    while (num > 0) {
      sb.append(num % 10);
      num /= 10;
    }
    return sb.reverse().toString();
  }

}