package question1960;

public class Solution {

  public long maxProduct(String s) {
    int[] p = new int[s.length()];
    int maxRight = 0, center = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i < maxRight) {
        int mirror = 2 * center - i;
        // 这一行代码是 Manacher 算法的关键所在，要结合图形来理解
        p[i] = Math.min(maxRight - i, p[mirror]);
      }
      // 下一次尝试扩散的左右起点，能扩散的步数直接加到 p[i] 中
      int left = i - (1 + p[i]);
      int right = i + (1 + p[i]);
      // left >= 0 && right < sLen 保证不越界
      // str.charAt(left) == str.charAt(right) 表示可以扩散 1 次
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        p[i]++;
        left--;
        right++;
      }
      // 根据 maxRight 的定义，它是遍历过的 i 的 i + p[i] 的最大者
      // 如果 maxRight 的值越大，进入上面 i < maxRight 的判断的可能性就越大，这样就可以重复利用之前判断过的回文信息了
      if (i + p[i] > maxRight) {
        // maxRight 和 center 需要同时更新
        maxRight = i + p[i];
        center = i;
      }
    }
    int[] left = new int[s.length()];   // left[i] 表示 [0, i] 范围内的奇数长度回文串的最长长度
    left[0] = 1;
    for (int i = 1, x = 0; i < left.length; i++) {
      while (x + p[x] < i) {
        x++;
      }
      left[i] = Math.max(left[i - 1], (i - x) * 2 + 1);
    }
    int[] right = new int[s.length()];  // right[i] 表示 [j, n - 1] 范围内的奇数回文串的最长长度
    right[right.length - 1] = 1;
    for (int i = right.length - 2, x = right.length - 1; i >= 0; i--) {
      while (x - p[x] > i) {
        x--;
      }
      right[i] = Math.max(right[i + 1], (x - i) * 2 + 1);
    }
    long result = 0L;
    for (int i = 0; i < s.length() - 1; i++) {
      result = Math.max(result, 1L * left[i] * right[i + 1]);
    }
    return result;
  }

}