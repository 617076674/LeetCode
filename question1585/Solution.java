package question1585;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public boolean isTransformable(String s, String t) {
    int[] map1 = getMap(s), map2 = getMap(t);
    for (int i = 0; i < 10; i++) {
      if (map1[i] != map2[i]) {
        return false;
      }
    }
    List<int[]>[] lists1 = getLists(s), lists2 = getLists(t);
    for (int i = 0; i < 10; i++) {
      if (null == lists1[i]) {
        continue;
      }
      for (int j = 0; j < lists1[i].size(); j++) {
        int[] temp1 = lists1[i].get(j), temp2 = lists2[i].get(j);
        if (temp1[0] > temp2[0] || temp1[1] > temp2[1]) {
          return false;
        }
      }
    }
    return true;
  }

  private List<int[]>[] getLists(String s) {
    List<int[]>[] result = new ArrayList[10];
    int[][] lessMap = getLessMap(s), greaterMap = getGreaterMap(s);
    for (int i = 0; i < s.length(); i++) {
      int index = s.charAt(i) - '0';
      if (null == result[index]) {
        result[index] = new ArrayList<>();
      }
      result[index].add(new int[] {lessMap[index][i], greaterMap[index][i]});
    }
    return result;
  }

  private static int[] getMap(String s) {
    int[] result = new int[10];
    for (int i = 0; i < s.length(); i++) {
      result[s.charAt(i) - '0']++;
    }
    return result;
  }

  private static int[][] getLessMap(String s) {
    // result[i][j] 表示在 [0, j - 1] 范围内比 i 小的字符个数
    int[][] result = new int[10][s.length() + 1];
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < 10; j++) {
        result[j][i] = result[j][i - 1];
      }
      char c = s.charAt(i - 1);
      for (int j = c - '0' + 1; j < 10; j++) {
        result[j][i]++;
      }
    }
    return result;
  }

  private static int[][] getGreaterMap(String s) {
    // result[i][j] 表示在 [j, s.length - 1] 范围内比 i 大的字符个数
    int[][] result = new int[10][s.length() + 1];
    for (int i = s.length() - 1; i >= 0; i--) {
      for (int j = 0; j < 10; j++) {
        result[j][i] = result[j][i + 1];
      }
      char c = s.charAt(i);
      for (int j = 0; j < c - '0'; j++) {
        result[j][i]++;
      }
    }
    return result;
  }

}