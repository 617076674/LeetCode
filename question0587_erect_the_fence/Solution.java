package question0587_erect_the_fence;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int[][] outerTrees(int[][] trees) {
    if (trees.length < 4) {
      return trees;
    }
    Set<int[]> hull = new HashSet<>();
    int leftMost = 0;
    for (int i = 1; i < trees.length; i++) {
      if (trees[i][0] < trees[leftMost][0]) {
        leftMost = i;
      }
    }
    int p = leftMost;
    do {
      int q = (p + 1) % trees.length;
      for (int i = 0; i < trees.length; i++) {
        if (orientation(trees[p], trees[i], trees[q]) < 0) {
          q = i;
        }
      }
      for (int i = 0; i < trees.length; i++) {
        if (i != p && i != q && orientation(trees[p], trees[i], trees[q]) == 0
            && inBetween(trees[p], trees[i], trees[q])) {
          hull.add(trees[i]);
        }
      }
      hull.add(trees[q]);
      p = q;
    } while (p != leftMost);
    int[][] result = new int[hull.size()][2];
    int index = 0;
    for (int[] h : hull) {
      result[index] = h;
      index++;
    }
    return result;
  }

  public int orientation(int[] p, int[] q, int[] r) {
    return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
  }

  public boolean inBetween(int[] p, int[] i, int[] q) {
    boolean a = (i[0] >= p[0] && i[0] <= q[0]) || (i[0] <= p[0] && i[0] >= q[0]);
    boolean b = (i[1] >= p[1] && i[1] <= q[1]) || (i[1] <= p[1] && i[1] >= q[1]);
    return a && b;
  }
}