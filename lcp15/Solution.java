package lcp15;

import java.util.Arrays;

public class Solution {

  private static int[] getVector(int[] from, int[] to) {
    return new int[] {to[0] - from[0], to[1] - from[1]};
  }

  // vector1 × vector2
  private static int crossProduct(int[] vector1, int[] vector2) {
    return vector1[0] * vector2[1] - vector2[0] * vector1[1];
  }

  public static void main(String[] args) {
    int[][] points = {{1,3},{2,4},{3,3},{2,1}};
    String direction = "LR";
    System.out.println(Arrays.toString(new Solution().visitOrder(points, direction)));
  }

  public int[] visitOrder(int[][] points, String direction) {
    int begin = 0;
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] < points[begin][0]) {
        begin = i;
      }
    }
    int[] result = new int[points.length];
    boolean[] visited = new boolean[points.length];
    int index = 0;
    result[index++] = begin;
    visited[begin] = true;
    int cur = begin;
    for (int i = 0; i < direction.length(); i++) {
      char c = direction.charAt(i);
      if (c == 'L') {
        int next = -1;
        for (int j = 0; j < points.length; j++) {
          if (visited[j]) {
            continue;
          }
          if (next == -1 || crossProduct(getVector(points[cur], points[j]), getVector(points[cur], points[next])) > 0) {
            next = j;
          }
        }
        visited[next] = true;
        cur = next;
        result[index++] = next;
      } else {
        int next = -1;
        for (int j = 0; j < points.length; j++) {
          if (visited[j]) {
            continue;
          }
          if (next == -1 || crossProduct(getVector(points[cur], points[j]), getVector(points[cur], points[next])) < 0) {
            next = j;
          }
        }
        visited[next] = true;
        cur = next;
        result[index++] = next;
      }
    }
    for (int i = 0; i < visited.length; i++) {
      if (!visited[i]) {
        result[index] = i;
      }
    }
    return result;
  }

}