package question0564_find_the_closest_palindrome;

public class Solution {

  private String n;

  private long result;

  private long target;

  private int[] cur;

  public String nearestPalindromic(String n) {
    this.n = n;
    this.target = Long.parseLong(n);
    cur = new int[n.length()];
    for (int i = 0; i < n.length() - 1; i++) {
      result = result * 10 + 9;
    }
    long temp = (long) Math.pow(10, n.length()) + 1;
    if (Math.abs(temp - target) < Math.abs(result - target)) {
      result = temp;
    }
    dfs(0, 0);
    return String.valueOf(result);
  }

  private void dfs(int index, int status) {
    if (index == (cur.length + 1) / 2) {
      long temp = 0L;
      for (int i = 0; i < cur.length; i++) {
        temp = temp * 10 + cur[i];
      }
      if (temp == target) {
        return;
      }
      if (Math.abs(temp - target) < Math.abs(result - target)
          || (Math.abs(temp - target) == Math.abs(result - target) && temp < result)) {
        result = temp;
      }
      return;
    }
    if (status == 1) {
      // 第 index 位置应该取得尽量小，即都取为 0
      cur[index] = cur[cur.length - index - 1] = 0;
      dfs(index + 1, 1);
    } else if (status == -1) {
      // 第 index 位置应该取得尽量大，即都取为 9
      cur[index] = cur[cur.length - index - 1] = 9;
      dfs(index + 1, -1);
    } else {
      cur[index] = cur[cur.length - index - 1] = n.charAt(index) - '0';
      dfs(index + 1, 0);
      if (n.charAt(index) != '9') {
        cur[index] = cur[cur.length - index - 1] = n.charAt(index) - '0' + 1;
        dfs(index + 1, 1);
      }
      if (n.charAt(index) != '0' && !(index == 0 && n.charAt(index) == '1')) {
        cur[index] = cur[cur.length - index - 1] = n.charAt(index) - '0' - 1;
        dfs(index + 1, -1);
      }
    }
  }

}