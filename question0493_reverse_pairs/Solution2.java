package question0493_reverse_pairs;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution2 {

  public int reversePairs(int[] nums) {
    TreeSet<Long> treeSet = new TreeSet<>();
    for (int num : nums) {
      treeSet.add((long) num);
    }
    Map<Long, Integer> num2Index = new HashMap<>();
    int index = 0;
    for (long num : treeSet) {
      num2Index.put(num, index++);
    }
    SegmentTree segmentTree = new SegmentTree(nums.length);
    int result = 0;
    for (int num : nums) {
      Long another = treeSet.ceiling(2L * num);
      if (null != another) {
        int anotherIdx = num2Index.get(another);
        if (another == 2 * num) {
          anotherIdx++;
        }
        result += segmentTree.query(anotherIdx, nums.length - 1);
      }
      int curIdx = num2Index.get(num * 1L);
      segmentTree.update(curIdx, curIdx, 1);
    }
    return result;
  }

  private static class SegmentTree {
    int[] tree;
    int[] lazy;
    int n;
    SegmentTree(int n) {
      this.n = n;
      tree = new int[n * 4];
      lazy = new int[n * 4];
    }
    private static int leftChild(int i) {
      return 2 * i + 1;
    }
    private static int rightChild(int i) {
      return 2 * i + 2;
    }
    public void update(int i, int j, int delta) {
      update(0, 0, n - 1, i, j, delta);
    }
    private void update(int treeIndex, int left, int right, int i, int j, int delta) {
      if (left > right || i > j || i > right || j < left) {
        return;
      }
      if (lazy[treeIndex] != 0) {
        tree[treeIndex] += (right - left + 1) * lazy[treeIndex];
        if (left != right) {
          lazy[leftChild(treeIndex)] += lazy[treeIndex];
          lazy[rightChild(treeIndex)] += lazy[treeIndex];
        }
        lazy[treeIndex] = 0;
      }
      if (i <= left && right <= j) {
        tree[treeIndex] += (right - left + 1) * delta;
        if (left != right) {
          lazy[leftChild(treeIndex)] += delta;
          lazy[rightChild(treeIndex)] += delta;
        }
        return;
      }
      int mid = (left + right) / 2;
      if (j <= mid) {
        update(leftChild(treeIndex), left, mid, i, j, delta);
      } else if (i >= mid + 1) {
        update(rightChild(treeIndex), mid + 1, right, i, j, delta);
      } else {
        update(leftChild(treeIndex), left, mid, i, mid, delta);
        update(rightChild(treeIndex), mid + 1, right, mid + 1, j, delta);
      }
      tree[treeIndex] = tree[leftChild(treeIndex)] + tree[rightChild(treeIndex)];
    }
    public int query(int i, int j) {
      return query(0, 0, n - 1, i, j);
    }
    private int query(int treeIndex, int left, int right, int i, int j) {
      if (left > right || i > j || i > right || j < left) {
        return 0;
      }
      if (lazy[treeIndex] != 0) {
        tree[treeIndex] += (right - left + 1) * lazy[treeIndex];
        if (left != right) {
          lazy[leftChild(treeIndex)] += lazy[treeIndex];
          lazy[rightChild(treeIndex)] += lazy[treeIndex];
        }
        lazy[treeIndex] = 0;
      }
      if (i <= left && right <= j) {
        return tree[treeIndex];
      }
      int mid = (left + right) / 2;
      if (j <= mid) {
        return query(leftChild(treeIndex), left, mid, i, j);
      }
      if (i >= mid + 1) {
        return query(rightChild(treeIndex), mid + 1, right, i, j);
      }
      return query(leftChild(treeIndex), left, mid, i, mid) + query(rightChild(treeIndex), mid + 1, right, mid + 1, j);
    }
  }

}
