package question2179;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  private static class SegmentTree {

    private int[] tree;

    private int[] lazy;

    private int n;

    public SegmentTree(int n) {
      this.n = n;
      this.tree = new int[n << 2];
      this.lazy = new int[n << 2];
    }

    public int query(int i, int j) {
      if (i > j) {
        return 0;
      }
      return querySegmentTree(0, 0, n - 1, i, j);
    }

    private int querySegmentTree(int treeIndex, int left, int right, int i, int j) {
      if (i > right || j < left) {
        return 0;
      }
      if (lazy[treeIndex] != 0) {
        tree[treeIndex] = (int) ((right - left + 1L) * lazy[treeIndex] + tree[treeIndex]);
        if (left != right) {
          lazy[leftChild(treeIndex)] += lazy[treeIndex];
          lazy[rightChild(treeIndex)] += lazy[treeIndex];
        }
        lazy[treeIndex] = 0;
      }
      if (i <= left && j >= right) {
        return tree[treeIndex];
      }
      int mid = left + ((right - left) >> 1);
      if (i > mid) {
        return querySegmentTree(rightChild(treeIndex), mid + 1, right, i, j);
      }
      if (j <= mid) {
        return querySegmentTree(leftChild(treeIndex), left, mid, i, j);
      }
      int leftResult = querySegmentTree(leftChild(treeIndex), left, mid, i, mid);
      int rightResult = querySegmentTree(rightChild(treeIndex), mid + 1, right, mid + 1, j);
      return leftResult + rightResult;
    }

    public void update(int i, int j, int val) {
      update(0, 0, n - 1, i, j, val);
    }

    private void update(int treeIndex, int left, int right, int i, int j, int val) {
      if (lazy[treeIndex] != 0) {
        tree[treeIndex] = (int) ((right - left + 1L) * lazy[treeIndex] + tree[treeIndex]);
        if (left != right) {
          lazy[leftChild(treeIndex)] += lazy[treeIndex];
          lazy[rightChild(treeIndex)] += lazy[treeIndex];
        }
        lazy[treeIndex] = 0;
      }
      if (left > right || i > right || j < left) {
        return;
      }
      if (i <= left && j >= right) {
        tree[treeIndex] = (int) ((right - left + 1L) * val + tree[treeIndex]);
        if (left != right) {
          lazy[leftChild(treeIndex)] += val;
          lazy[rightChild(treeIndex)] += val;
        }
        return;
      }
      int mid = left + ((right - left) >> 1);
      update(leftChild(treeIndex), left, mid, i, j, val);
      update(rightChild(treeIndex), mid + 1, right, i, j, val);
      tree[treeIndex] = tree[leftChild(treeIndex)] + tree[rightChild(treeIndex)];
    }

    private static int leftChild(int index) {
      return 2 * index + 1;
    }

    private static int rightChild(int index) {
      return 2 * index + 2;
    }

  }

  public long goodTriplets(int[] nums1, int[] nums2) {
    Map<Integer, Integer> num2Pos2 = new HashMap<>();
    for (int i = 0; i < nums2.length; i++) {
      num2Pos2.put(nums2[i], i);
    }
    SegmentTree segmentTree = new SegmentTree(nums2.length);
    long result = 0;
    for (int i = 0; i < nums1.length; i++) {
      int pos2 = num2Pos2.get(nums1[i]);
      result += 1L * segmentTree.query(0, pos2 - 1) *
          (nums2.length - pos2 - 1 - segmentTree.query(pos2 + 1, nums2.length - 1));
      segmentTree.update(pos2, pos2, 1);
    }
    return result;
  }

}