package question1632_rank_transform_of_a_matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  private static class UnionFind {

    private int[] parent;

    public UnionFind(int n) {
      this.parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    public int findParent(int x) {
      int a = x;
      while (x != parent[x]) {
        x = parent[x];
      }
      while (a != parent[a]) {
        int z = parent[a];
        parent[a] = x;
        a = z;
      }
      return x;
    }

    public void union(int a, int b) {
      int aParent = findParent(a), bParent = findParent(b);
      if (aParent != bParent) {
        parent[aParent] = bParent;
      }
    }

  }

  public int[][] matrixRankTransform(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    List<Integer> positionList = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        positionList.add(i * n + j);
      }
    }
    Map<Integer, Map<Integer, List<Integer>>> num2Row2Cols = new HashMap<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        Map<Integer, List<Integer>> row2Cols = num2Row2Cols.get(matrix[i][j]);
        if (null == row2Cols) {
          row2Cols = new HashMap<>();
          List<Integer> cols = new ArrayList<>();
          cols.add(j);
          row2Cols.put(i, cols);
          num2Row2Cols.put(matrix[i][j], row2Cols);
        } else {
          List<Integer> list = row2Cols.get(i);
          if (null == list) {
            list = new ArrayList<>();
            list.add(j);
            row2Cols.put(i, list);
          } else {
            list.add(j);
          }
        }
      }
    }
    Map<Integer, Map<Integer, List<Integer>>> num2Col2Rows = new HashMap<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        Map<Integer, List<Integer>> col2Rows = num2Col2Rows.get(matrix[i][j]);
        if (null == col2Rows) {
          col2Rows = new HashMap<>();
          List<Integer> cols = new ArrayList<>();
          cols.add(i);
          col2Rows.put(j, cols);
          num2Col2Rows.put(matrix[i][j], col2Rows);
        } else {
          List<Integer> list = col2Rows.get(j);
          if (null == list) {
            list = new ArrayList<>();
            list.add(i);
            col2Rows.put(j, list);
          } else {
            list.add(i);
          }
        }
      }
    }
    UnionFind unionFind = new UnionFind(m * n);
    for (Map<Integer, List<Integer>> row2Cols : num2Row2Cols.values()) {
      for (Map.Entry<Integer, List<Integer>> entry : row2Cols.entrySet()) {
        for (int i = 1; i < entry.getValue().size(); i++) {
          unionFind.union(entry.getKey() * n + entry.getValue().get(0), entry.getKey() * n + entry.getValue().get(i));
        }
      }
    }

    for (Map<Integer, List<Integer>> col2Rows : num2Col2Rows.values()) {
      for (Map.Entry<Integer, List<Integer>> entry : col2Rows.entrySet()) {
        for (int i = 1; i < entry.getValue().size(); i++) {
          unionFind.union(entry.getValue().get(0) * n + entry.getKey(), entry.getValue().get(i) * n + entry.getKey());
        }
      }
    }
    Set<Integer>[] parent2Children = new HashSet[m * n];
    for (int i = 0; i < m * n; i++) {
      int parent = unionFind.findParent(i);
      if (null == parent2Children[parent]) {
        parent2Children[parent] = new HashSet<>();
      }
      parent2Children[parent].add(i);
    }
    Collections.sort(positionList, Comparator.comparingInt(p -> matrix[p / n][p % n]));
    int[][] result = new int[m][n];
    int[] rowMin = new int[m], colMin = new int[n];
    for (int i = 0; i < positionList.size(); i++) {
      int p = positionList.get(i), row = p / n, col = p % n;
      if (result[row][col] != 0) {
        continue;
      }
      Set<Integer> sameRankSet = parent2Children[unionFind.findParent(p)];
      int rank = 0;
      for (int sameRankP : sameRankSet) {
        rank = Math.max(rank, Math.max(rowMin[sameRankP / n], colMin[sameRankP % n]) + 1);
      }
      for (int sameRankP : sameRankSet) {
        int sameRankRow = sameRankP / n, sameRankCol = sameRankP % n;
        result[sameRankRow][sameRankCol] = rank;
        rowMin[sameRankRow] = rank;
        colMin[sameRankCol] = rank;
      }
    }
    return result;
  }

}