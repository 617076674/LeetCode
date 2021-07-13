package question1923_longest_common_subpath;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {

  private long[] rankArray, sufArray, height;

  private int[] map;

  private int pathsSize;

  public int longestCommonSubpath(int n, int[][] paths) {
    pathsSize = paths.length;
    int totalLen = 0;
    for (int i = 0; i < paths.length; i++) {
      totalLen += paths[i].length;
    }
    totalLen += paths.length - 1;
    map = new int[totalLen];
    int[] total = new int[totalLen];
    int index = 0;
    for (int i = 0; i < paths.length; i++) {
      for (int j = 0; j < paths[i].length; j++) {
        map[index] = i;
        total[index++] = paths[i][j];
      }
      if (i != paths.length - 1) {
        map[index] = -1;
        total[index++] = -1;
      }
    }
    rankArray = getRank(total);
    sufArray = new long[rankArray.length];
    for (int i = 0; i < sufArray.length; i++) {
      sufArray[(int) rankArray[i]] = i;
    }
    height = new long[total.length];
    for (int i = 0; i < total.length; i++) {
      long rank = rankArray[i];
      if (rank > 0) {
        long index1 = sufArray[(int) rank], index2 = sufArray[(int) (rank - 1)];
        long j = i > 0 ? height[(int) rankArray[i - 1]] - 1 : 0;
        j = Math.max(j, 0);
        while (index1 + j < total.length && index2 + j < total.length && total[(int) (index1 + j)] == total[(int) (index2 + j)]) {
          j++;
        }
        height[(int) rank] = j;
      }
    }
    int left = 0, right = paths[0].length;
    for (int i = 1; i < paths.length; i++) {
      right = Math.min(right, paths[i].length);
    }
    while (left < right) {
      if (left + 1 == right) {
        if (check(right)) {
          return right;
        }
        return left;
      }
      int mid = left + ((right - left) >> 1);
      if (check(mid)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  private boolean check(int len) {
    int i = 1;
    while (i < height.length) {
      int left = i;
      for (; i < height.length; i++) {
        if (height[i] >= len) {
          left = i;
          break;
        }
      }
      if (i >= height.length) {
        return false;
      }
      int right = left;
      for (; i < height.length; i++) {
        if (height[i] < len) {
          right = i - 1;
          break;
        }
      }
      if (i >= height.length) {
        right = height.length - 1;
      }
      // height[left], height[right] 范围内
      Set<Integer> set = new HashSet<>();
      for (int j = left - 1; j <= right; j++) {
        if (map[(int) sufArray[j]] != -1) {
          set.add(map[(int) sufArray[j]]);
        }
      }
      if (set.size() == pathsSize) {
        return true;
      }
    }
    return false;
  }

  private long[] getRank(int[] total) {
    long[] rank = new long[total.length];
    Integer[] indexes = new Integer[total.length];
    for (int j = 0; j < indexes.length; j++) {
      indexes[j] = j;
    }
    Arrays.sort(indexes, Comparator.comparingInt(index -> total[index]));
    int num = 1;
    for (int j = 0; j < rank.length; j++) {
      if (j > 0 && total[indexes[j]] != total[indexes[j - 1]]) {
        num++;
      }
      rank[indexes[j]] = num;
    }
    for (int i = 1; i < total.length; i *= 2) {
      long[] temp = new long[total.length];
      for (int j = 0; j < total.length; j++) {
        temp[j] = rank[j] * (total.length + 1);
        if (j + i < total.length) {
          temp[j] += rank[j + i];
        }
      }
      for (int j = 0; j < indexes.length; j++) {
        indexes[j] = j;
      }
      Arrays.sort(indexes, (index1, index2) -> {
        if (temp[index1] < temp[index2]) {
          return -1;
        }
        if (temp[index1] > temp[index2]) {
          return 1;
        }
        return 0;
      });
      num = 1;
      for (int j = 0; j < rank.length; j++) {
        if (j > 0 && temp[indexes[j]] != temp[indexes[j - 1]]) {
          num++;
        }
        rank[indexes[j]] = num;
      }
    }
    for (int i = 0; i < rank.length; i++) {
      rank[i]--;
    }
    return rank;
  }

}