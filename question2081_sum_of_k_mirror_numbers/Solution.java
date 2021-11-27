package question2081_sum_of_k_mirror_numbers;

public class Solution {

  private long result;

  private int count;

  private int k;

  private int n;

  public long kMirror(int k, int n) {
    this.k = k;
    this.n = n;
    int digitCount = 1;
    while (count < n) {
      char[] data = new char[digitCount];
      dfs(data, digitCount++, 0);
    }
    return result;
  }

  private void dfs(char[] data, int digitCount, int index) {
    if (count >= n) {
      return;
    }
    if (index == (digitCount  + 1) / 2) {
      long num = Long.parseLong(new String(data));
      long tempNum = num;
      StringBuilder temp = new StringBuilder();
      while (num > 0) {
        temp.append(num % k);
        num /= k;
      }
      if (isPalindrome(temp)) {
        result += tempNum;
        count++;
      }
      return;
    }
    int left = 0, right = 9;
    if (index == 0) {
      left++;
    }
    if (index == digitCount / 2) {
      for (int i = left; i <= right; i++) {
        char c = (char) ('0' + i);
        data[index] = c;
        dfs(data, digitCount, index + 1);
      }
      return;
    }
    for (int i = left; i <= right; i++) {
      char c = (char) ('0' + i);
      data[index] = data[data.length - 1 - index] = c;
      dfs(data, digitCount, index + 1);
    }
  }

  private static boolean isPalindrome(StringBuilder s) {
    for (int i = 0; i <= s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

}