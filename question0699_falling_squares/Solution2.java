package question0699_falling_squares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 懒更新的线段树。
 */
public class Solution2 {

  private static class SegmentTree {

    private int[] tree;

    private int[] lazy;

    private int size;

    public SegmentTree(int size) {
      this.size = size;
      this.tree = new int[size << 2];
      this.lazy = new int[size << 2];
    }

    public int query(int i, int j) {
      return query(0, 0, size - 1, i, j);
    }

    private int query(int treeIndex, int left, int right, int i, int j) {
      if (i > right || j < left) {
        return 0;
      }
      if (lazy[treeIndex] != 0) {
        tree[treeIndex] = lazy[treeIndex];
        if (left != right) {
          lazy[leftChild(treeIndex)] = lazy[treeIndex];
          lazy[rightChild(treeIndex)] = lazy[treeIndex];
        }
        lazy[treeIndex] = 0;
      }
      if (i <= left && j >= right) {
        return tree[treeIndex];
      }
      int mid = left + ((right - left) >> 1);
      if (i > mid) {
        return query(rightChild(treeIndex), mid + 1, right, i, j);
      }
      if (j <= mid) {
        return query(leftChild(treeIndex), left, mid, i, j);
      }
      int leftResult = query(leftChild(treeIndex), left, mid, i, mid);
      int rightResult = query(rightChild(treeIndex), mid + 1, right, mid + 1, j);
      return Math.max(leftResult, rightResult);
    }

    public void update(int i, int j, int val) {
      update(0, 0, size - 1, i, j, val);
    }

    private void update(int treeIndex, int left, int right, int i, int j, int val) {
      if (left > right || i > right || j < left) {
        return;
      }
      if (lazy[treeIndex] != 0) {
        tree[treeIndex] = lazy[treeIndex];
        if (left != right) {
          lazy[leftChild(treeIndex)] = lazy[treeIndex];
          lazy[rightChild(treeIndex)] = lazy[treeIndex];
        }
        lazy[treeIndex] = 0;
      }
      if (i <= left && j >= right) {
        tree[treeIndex] = val;
        if (left != right) {
          lazy[leftChild(treeIndex)] = val;
          lazy[rightChild(treeIndex)] = val;
        }
        return;
      }
      int mid = left + ((right - left) >> 1);
      update(leftChild(treeIndex), left, mid, i, j, val);
      update(rightChild(treeIndex), mid + 1, right, i, j, val);
      tree[treeIndex] = Math.max(tree[leftChild(treeIndex)], tree[rightChild(treeIndex)]);
    }

    private static int leftChild(int index) {
      return 2 * index + 1;
    }

    private static int rightChild(int index) {
      return 2 * index + 2;
    }

  }

  public List<Integer> fallingSquares(int[][] positions) {
    Set<Integer> set = new HashSet<>();
    for (int[] position : positions) {
      set.add(position[0]);
      set.add(position[0] + position[1] - 1);
    }
    List<Integer> list = new ArrayList<>(set);
    Collections.sort(list);
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
    for (int coordinate : list) {
      map.put(coordinate, index++);
    }
    SegmentTree tree = new SegmentTree(list.size());
    int best = 0;
    List<Integer> result = new ArrayList<>();
    for (int[] position : positions) {
      int left = map.get(position[0]), right = map.get(position[0] + position[1] - 1),
          height = tree.query(left, right) + position[1];
      tree.update(left, right, height);
      best = Math.max(best, height);
      result.add(best);
    }
    return result;
  }

}