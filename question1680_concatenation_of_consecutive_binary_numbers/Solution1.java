package question1680_concatenation_of_consecutive_binary_numbers;

public class Solution1 {

  private static final int MOD = 1000000007;

  public int concatenatedBinary(int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      sb.append(Integer.toBinaryString(i));
    }
    return (int) calculate(sb.toString());
  }

  private long calculate(String s) {
    long result = 0;
    for (int i = 0; i < s.length(); i++) {
      result = result * 2 + s.charAt(i) - '0';
      result %= MOD;
    }
    return result;
  }

}