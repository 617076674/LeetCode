package question0005_longest_palindromic_substring;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution4 {

  public String longestPalindrome(String s) {
    StringBuilder sb = new StringBuilder(s);
    sb.append("$");
    for (int i = s.length() - 1; i >= 0; i--) {
      sb.append(s.charAt(i));
    }
    String doubleS = sb.toString();
    int[] rankArray = getRankArray(doubleS);
    int[] sufArray = getSufArray(rankArray);
    int[] height = getHeight(doubleS, rankArray, sufArray);
    int[][] dp = getDP(height);
    String result = s.substring(0, 1);
    for (int i = 0; i < s.length(); i++) {
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

  private static int[] getSufArray(int[] rankArray) {
    int[] sufArray = new int[rankArray.length];
    for (int i = 0; i < sufArray.length; i++) {
      sufArray[rankArray[i]] = i;
    }
    return sufArray;
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

  private static int[] getRankArray(String s) {
    Set<Integer> set = new TreeSet<>();
    for (int i = 0; i < s.length(); i++) {
      set.add((int) s.charAt(i));
    }
    int index = 1;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : set) {
      map.put(num, index++);
    }
    int[] rankArray = new int[s.length()];
    for (int i = 0; i < rankArray.length; i++) {
      rankArray[i] = map.get((int) s.charAt(i));
    }
    for (int len = 1; len < s.length(); len *= 2) {
      set = new TreeSet<>();
      map = new HashMap<>();
      int[] temp = new int[s.length()];
      for (int i = 0; i < s.length(); i++) {
        temp[i] = rankArray[i] * (s.length() + 1);
        if (i + len < s.length()) {
          temp[i] += rankArray[i + len];
        }
        set.add(temp[i]);
      }
      index = 1;
      for (int num : set) {
        map.put(num, index++);
      }
      for (int i = 0; i < temp.length; i++) {
        rankArray[i] = map.get(temp[i]);
      }
    }
    for (int i = 0; i < rankArray.length; i++) {
      rankArray[i]--;
    }
    return rankArray;
  }

}