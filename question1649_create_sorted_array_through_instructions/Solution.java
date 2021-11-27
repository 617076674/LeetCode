package question1649_create_sorted_array_through_instructions;

public class Solution {

  private static class SegmentTree {

    private int[] tree;

    private int[] data;

    public SegmentTree(int[] arr) {
      data = arr;
      tree = new int[arr.length << 2];
      buildSegmentTree(0, 0, data.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int left, int right) {
      if (left == right) {
        tree[treeIndex] = data[left];
        return;
      }
      int leftTreeIndex = leftChild(treeIndex), rightTreeIndex = rightChild(treeIndex);
      int mid = left + ((right - left) >> 1);
      buildSegmentTree(leftTreeIndex, left, mid);
      buildSegmentTree(rightTreeIndex, mid + 1, right);
      tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }

    public int query(int queryL, int queryR) {
      if (queryL > queryR) {
        return 0;
      }
      return query(0, 0, data.length - 1, queryL, queryR);
    }

    private int query(int treeIndex, int left, int right, int queryL, int queryR) {
      if (left == queryL && right == queryR) {
        return tree[treeIndex];
      }
      int leftTreeIndex = leftChild(treeIndex), rightTreeIndex = rightChild(treeIndex);
      int mid = left + ((right - left) >> 1);
      if (queryL >= mid + 1) {
        return query(rightTreeIndex, mid + 1, right, queryL, queryR);
      }
      if (queryR <= mid) {
        return query(leftTreeIndex, left, mid, queryL, queryR);
      }
      return query(leftTreeIndex, left, mid, queryL, mid) +
          query(rightTreeIndex, mid + 1, right, mid + 1, queryR);
    }

    public void update(int index, int val) {
      data[index] = val;
      update(0, 0, data.length - 1, index, val);
    }

    private void update(int treeIndex, int left, int right, int index, int val) {
      if (left == right) {
        tree[treeIndex] = val;
        return;
      }
      int leftTreeIndex = leftChild(treeIndex), rightTreeIndex = rightChild(treeIndex);
      int mid = left + ((right - left) >> 1);
      if (index >= mid + 1) {
        update(rightTreeIndex, mid + 1, right, index, val);
      } else {
        update(leftTreeIndex, left, mid, index, val);
      }
      tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }

    private static int leftChild(int treeIndex) {
      return 2 * treeIndex + 1;
    }

    private static int rightChild(int treeIndex) {
      return 2 * treeIndex + 2;
    }

  }

  private static final int MOD = 1000000007;

  public int createSortedArray(int[] instructions) {
    int[] data = new int[100001];
    SegmentTree segmentTree = new SegmentTree(data);
    int result = 0;
    for (int instruction : instructions) {
      result += Math.min(segmentTree.query(0, instruction - 1), segmentTree.query(instruction + 1, data.length - 1));
      result %= MOD;
      segmentTree.update(instruction, ++data[instruction]);
    }
    return result;
  }

}