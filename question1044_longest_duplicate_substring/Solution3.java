package question1044_longest_duplicate_substring;

/**
 * 后缀数组：罗穗骞
 */
public class Solution3 {

  public String longestDupSubstring(String s) {
    int n = s.length() + 1;
    int[] r = new int[n];
    int m = 0, i, j, p;
    for (i = 0; i < n - 1; i++) {
      r[i] = s.charAt(i);
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
    int[] height = getHeight(r, x, sa);
    int maxIndex = 0;
    for (i = 1; i < height.length; i++) {
      if (height[i] > height[maxIndex]) {
        maxIndex = i;
      }
    }
    return s.substring(sa[maxIndex], Math.min(s.length(), sa[maxIndex] + height[maxIndex]));
  }

  private static boolean  cmp(int[] r, int a, int b, int l) {
    return r[a] == r[b] && r[a + l] == r[b + l];
  }

  private static int[] getHeight(int[] r, int[] rankArray, int[] sufArray) {
    int[] height = new int[rankArray.length];
    for (int i = 0; i < height.length; i++) {
      int rank = rankArray[i];
      if (rank > 0) {
        int index1 = sufArray[rank], index2 = sufArray[rank - 1];
        int j = i > 0 ? Math.max(0, height[rankArray[i - 1]] - 1) : 0;
        while (index1 + j < r.length && index2 + j < r.length && r[index1 + j] == r[index2 + j]) {
          j++;
        }
        height[rank] = j;
      }
    }
    return height;
  }

}