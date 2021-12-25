package question0005_longest_palindromic_substring;

/**
 * 后缀数组：罗穗骞
 */
public class Solution6 {

  public String longestPalindrome(String s) {
    StringBuilder sb = new StringBuilder(s);
    sb.append("$");
    for (int i = s.length() - 1; i >= 0; i--) {
      sb.append(s.charAt(i));
    }
    String doubleS = sb.toString();
    int n = doubleS.length() + 1;
    int[] r = new int[n];
    int m = 0, i, j, p;
    for (i = 0; i < n - 1; i++) {
      r[i] = doubleS.charAt(i);
      m = Math.max(m, r[i]);
    }
    m++;
    int[] wv = new int[n], ws = new int[m], x = new int[n], y = new int[n], t, sa = new int[n];
    for (i = 0; i < n; i++) {
      x[i] = r[i];
      ws[x[i]]++;
    }
    for (i = 1; i < m; i++) {
      ws[i] += ws[i - 1];
    }
    for (i = n - 1; i >= 0; i--) {
      sa[--ws[x[i]]] = i;
    }
    for (j = 1, p = 1; p < n; j *= 2, m = p) {
      for (p = 0, i = n - j; i < n; i++) {
        y[p++] = i;
      }
      for (i = 0; i < n; i++) {
        if (sa[i] >= j) {
          y[p++] = sa[i] - j;
        }
      }
      for (i = 0; i < n; i++) {
        wv[i] = x[y[i]];
      }
      ws = new int[m];
      for (i = 0; i < n; i++) {
        ws[wv[i]]++;
      }
      for (i = 1; i < m; i++) {
        ws[i] += ws[i - 1];
      }
      for (i = n - 1; i >= 0; i--) {
        sa[--ws[wv[i]]] = y[i];
      }
      for (t = x, x = y, y = t, p = 1, x[sa[0]] = 0, i = 1; i < n; i++) {
        x[sa[i]] = cmp(y, sa[i - 1], sa[i], j) ? p - 1 : p++;
      }
    }
    int[] rankArray = new int[doubleS.length()];
    int index = 0;
    for (i = 0; i < x.length; i++) {
      if (x[i] == 0) {
        continue;
      }
      rankArray[index++] = x[i] - 1;
    }
    int[] sufArray = new int[rankArray.length];
    for (i = 0; i < sufArray.length; i++) {
      sufArray[rankArray[i]] = i;
    }
    int[] height = getHeight(doubleS, rankArray, sufArray);
    int[][] dp = getDP(height);
    String result = s.substring(0, 1);
    for (i = 0; i < s.length(); i++) {
      // 以 s.charAt(i) 为中心的奇数长度回文串的长度
      if (i + 1 < s.length() && i - 1 >= 0) {
        int rank1 = rankArray[i + 1], rank2 = rankArray[sb.length() - i];
        int temp = rmq(dp, Math.min(rank1, rank2) + 1, Math.max(rank1, rank2));
        if (temp * 2 + 1 > result.length()) {
          result = s.substring(i - temp, i + temp + 1);
        }
      }
      // 以 s.charAt(i - 1) 和 s.charAt(i) 为中心的偶数长度回文串的长度
      if (i - 1 >= 0 && s.charAt(i - 1) == s.charAt(i)) {
        if (result.length() < 2) {
          result = s.substring(i - 1, i + 1);
        }
        if (i - 2 >= 0 && i + 1 < s.length()) {
          int rank1 = rankArray[i + 1], rank2 = rankArray[sb.length() - i + 1];
          int temp = rmq(dp, Math.min(rank1, rank2) + 1, Math.max(rank1, rank2));
          if (temp * 2 + 2 > result.length()) {
            result = s.substring(i - 1 - temp, i + temp + 1);
          }
        }
      }
    }
    return result;
  }

  private static int[][] getDP(int[] height) {
    int[][] dp = new int[height.length][11];
    for (int i = 0; i < height.length; i++) {
      dp[i][0] = height[i];
    }
    for (int j = 1; (1 << j) <= height.length; j++) {
      for (int i = 0; i + (1 << j) - 1 < height.length; i++) {
        dp[i][j] = Math.min(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
      }
    }
    return dp;
  }

  private static int rmq(int[][] dp, int left, int right) {
    int k = (int) (Math.log(right - left + 1) / Math.log(2));
    return Math.min(dp[left][k], dp[right - (1 << k) + 1][k]);
  }

  private static boolean  cmp(int[] r, int a, int b, int l) {
    return r[a] == r[b] && r[a + l] == r[b + l];
  }

  private static int[] getHeight(String s, int[] rankArray, int[] sufArray) {
    int[] height = new int[rankArray.length];
    for (int i = 0; i < height.length; i++) {
      int rank = rankArray[i];
      if (rank > 0) {
        int index1 = sufArray[rank], index2 = sufArray[rank - 1];
        int j = i > 0 ? Math.max(0, height[rankArray[i - 1]] - 1) : 0;
        while (index1 + j < s.length() && index2 + j < s.length() && s.charAt(index1 + j) == s.charAt(index2 + j)) {
          j++;
        }
        height[rank] = j;
      }
    }
    return height;
  }

}