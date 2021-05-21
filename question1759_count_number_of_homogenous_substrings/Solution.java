package question1759_count_number_of_homogenous_substrings;

public class Solution {

  private static final int MOD = 1000000007;

  public int countHomogenous(String s) {
    long result = 0;
    for (long i = 0; i < s.length(); ) {
      long j = i;
      while (j + 1 < s.length() && s.charAt((int) (j + 1)) == s.charAt((int) i)) {
        j++;
      }
      // [i, j]
      result += (j - i + 1) * (2 + j - i) / 2;
      result %= MOD;
      i = j + 1;
    }
    return (int) result;
  }

}