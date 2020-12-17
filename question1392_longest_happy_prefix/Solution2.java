package question1392_longest_happy_prefix;

/**
 * 动态规划。
 * <p>
 * 状态定义：
 * dp[i] 表示字符串 s 中 [0, i] 范围内的子串，其对应的最长相同前后缀的长度（该最长相同前后缀不能是该子串本身）。
 * <p>
 * 初始化条件：
 * dp[0] = 0。
 * <p>
 * 状态转移方程：
 * 如果说 s.charAt(i) == s.charAt(dp[i - 1])，那么 dp[i] = dp[i - 1] + 1。
 * 否则，需要进入下述循环：
 * 令 j = dp[i - 1]，去寻找 j，使得 s.charAt(i) == s.charAt(j)，如果不满足该条件，令 j = dp[j - 1] 继续判断。
 * 直到寻找到一个 j，使得 s.charAt(i) == s.charAt(j)，此时 dp[i] = j + 1。
 * <p>
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串s的长度。
 * <p>
 * 执行用时：97ms，击败14.16%。消耗内存：67MB，击败100.00%。
 */
public class Solution2 implements Cloneable {

  public Object object = new Object();

  public String longestPrefix(String s) {
    int[] dp = new int[s.length()];
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(dp[i - 1])) {
        dp[i] = dp[i - 1] + 1;
      } else {
        int j = dp[i - 1];
        while (j > 0) {
          j = dp[j - 1];
          if (s.charAt(i) == s.charAt(j)) {
            dp[i] = j + 1;
            break;
          }
        }
      }
    }
    return s.substring(0, dp[s.length() - 1]);
  }

  public static void main(String[] args) {
    System.out.println(KMPUtils.isMatch("mississippi", "issip"));
  }
}

class KMPUtils {
  public static boolean isMatch(String s, String p) {
    int[] dp = new int[p.length()];
    for (int i = 1; i < p.length(); i++) {
      if (p.charAt(i) == p.charAt(dp[i - 1])) {
        dp[i] = dp[i - 1] + 1;
      } else {
        int j = dp[i - 1];
        while (j > 0) {
          j = dp[j - 1];
          if (p.charAt(i) == p.charAt(j)) {
            dp[i] = j + 1;
            break;
          }
        }
      }
    }
    int i = 0, j = 0;
    while (i < s.length()) {
      if (s.charAt(i) == p.charAt(j)) {
        j++;
        i++;
      } else {
        if (j == 0) {
          i++;
        } else {
          while (j > 0) {
            j = dp[j - 1];
            if (s.charAt(i) == p.charAt(j)) {
              i++;
              j++;
              break;
            }
          }
        }
      }
      if (j == p.length()) {
        return true;
      }
    }
    return false;
  }
}