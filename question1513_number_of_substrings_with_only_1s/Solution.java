package question1513_number_of_substrings_with_only_1s;

public class Solution {

  private static final int MOD = 1000000007;

  public int numSub(String s) {
    s = "0" + s + "0";
    long result = 0;
    for (long i = 0; i < s.length(); ) {
      long j = i;
      while (s.charAt((int) j) == '1') {
        j++;
      }
      // [i, j - 1]
      result += ((1 + j - i) * (j - i) / 2) % MOD;
      i = j + 1;
    }
    return (int) result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().numSub("111111"));
  }

}