package question1220_count_vowels_permutation;

public class Solution {

  private static final int MOD = 1000000007;

  private Integer[][] memo;

  public int countVowelPermutation(int n) {
    memo = new Integer[n + 1][6];
    return countVowelPermutation(n, 5);
  }

  private int countVowelPermutation(int n, int pre) {
    if (n == 0) {
      return 1;
    }
    if (null != memo[n][pre]) {
      return memo[n][pre];
    }
    int result = 0;
    if (pre == 5) {
      for (int i = 0; i < 5; i++) {
        result += countVowelPermutation(n - 1, i);
        result %= MOD;
      }
    } else if (pre == 0) {
      result = countVowelPermutation(n - 1, 1);
    } else if (pre == 1) {
      result = (countVowelPermutation(n - 1, 0) + countVowelPermutation(n - 1, 2)) % MOD;
    } else if (pre == 2) {
      result = countVowelPermutation(n - 1, 0);
      result += countVowelPermutation(n - 1, 1);
      result %= MOD;
      result += countVowelPermutation(n - 1, 3);
      result %= MOD;
      result += countVowelPermutation(n - 1, 4);
      result %= MOD;
    } else if (pre == 3) {
      result = (countVowelPermutation(n - 1, 2) + countVowelPermutation(n - 1, 4)) % MOD;
    } else if (pre == 4) {
      result = countVowelPermutation(n - 1, 0);
    }
    memo[n][pre] = result;
    return result;
  }

}
