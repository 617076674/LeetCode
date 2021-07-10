package question1622_fancy_sequence;

import java.util.Arrays;

/**
 * 懒更新的线段树。
 */
public class Fancy1 {

  private static final int MOD = 1000000007;

  private static class SegmentTree {

    private long[] tree;

    private long[] lazya;

    private long[] lazym;

    private int n;

    public SegmentTree(int n) {
      this.n = n;
      tree = new long[n << 2];
      lazya = new long[n << 2];
      lazym = new long[n << 2];
      Arrays.fill(lazym, 1);
    }

    public void add(int index, int val) {
      update(0, 0, n - 1, index, index, val, 1);
    }

    public void updateAdd(int left, int right, int inc) {
      update(0, 0, n - 1, left, right, inc, 1);
    }

    public void updateMul(int left, int right, int mul) {
      update(0, 0, n - 1, left, right, 0, mul);
    }

    public long query(int index) {
      return query(0, 0, n - 1, index);
    }

    private void update(int treeIndex, int left, int right, int updateLeft, int updateRight,
                        int inc, int m) {
      int leftTreeIndex = leftChild(treeIndex), rightTreeIndex = rightChild(treeIndex);
      if (lazya[treeIndex] != 0 || lazym[treeIndex] != 1) {
        // 区间更新
        tree[treeIndex] = ((right - left + 1) * lazya[treeIndex] +
            lazym[treeIndex] * tree[treeIndex]) % MOD;
        // 懒更新
        lazym[leftTreeIndex] = lazym[treeIndex] * lazym[leftTreeIndex] % MOD;
        lazya[leftTreeIndex] = (lazym[treeIndex] * lazya[leftTreeIndex] + lazya[treeIndex]) % MOD;
        lazym[rightTreeIndex] = lazym[treeIndex] * lazym[rightTreeIndex] % MOD;
        lazya[rightTreeIndex] = (lazym[treeIndex] * lazya[rightTreeIndex] + lazya[treeIndex]) % MOD;
        lazya[treeIndex] = 0;
        lazym[treeIndex] = 1;
      }
      if (updateLeft > right || updateRight < left) {
        return;
      }
      if (updateLeft <= left && updateRight >= right) {
        // 区间更新
        tree[treeIndex] = ((right - left + 1) * inc + m * tree[treeIndex]) % MOD;
        // 懒更新
        lazym[leftTreeIndex] = m * lazym[leftTreeIndex] % MOD;
        lazya[leftTreeIndex] = (m * lazya[leftTreeIndex] + inc) % MOD;
        lazym[rightTreeIndex] = m * lazym[rightTreeIndex] % MOD;
        lazya[rightTreeIndex] = (m * lazya[rightTreeIndex] + inc) % MOD;
        return;
      }
      int mid = left + ((right - left) >> 1);
      update(leftTreeIndex, left, mid, updateLeft, updateRight, inc, m);
      update(rightTreeIndex, mid + 1, right, updateLeft, updateRight, inc, m);
      tree[treeIndex] = (tree[leftTreeIndex] + tree[rightTreeIndex]) % MOD;
    }

    private long query(int treeIndex, int left, int right, int queryIndex) {
      int leftTreeIndex = leftChild(treeIndex), rightTreeIndex = rightChild(treeIndex);
      if (lazya[treeIndex] != 0 || lazym[treeIndex] != 1) {
        // 区间更新
        tree[treeIndex] = ((right - left + 1) * lazya[treeIndex] +
            lazym[treeIndex] * tree[treeIndex]) % MOD;
        // 懒更新
        lazym[leftTreeIndex] = lazym[treeIndex] * lazym[leftTreeIndex] % MOD;
        lazya[leftTreeIndex] = (lazym[treeIndex] * lazya[leftTreeIndex] + lazya[treeIndex]) % MOD;
        lazym[rightTreeIndex] = (lazym[treeIndex] * lazym[rightTreeIndex]) % MOD;
        lazya[rightTreeIndex] = (lazym[treeIndex] * lazya[rightTreeIndex] + lazya[treeIndex]) % MOD;
        lazya[treeIndex] = 0;
        lazym[treeIndex] = 1;
      }
      if (left == right) {
        return tree[treeIndex];
      }
      int mid = left + ((right - left) >> 1);
      return queryIndex <= mid ? query(leftTreeIndex, left, mid, queryIndex) :
          query(rightTreeIndex, mid + 1, right, queryIndex);
    }

    private static int leftChild(int treeIndex) {
      return 2 * treeIndex + 1;
    }

    private static int rightChild(int treeIndex) {
      return 2 * treeIndex + 2;
    }

  }

  private SegmentTree segmentTree = new SegmentTree(100000);

  private int index;

  public Fancy1() {

  }

  public void append(int val) {
    segmentTree.add(index++, val);
  }

  public void addAll(int inc) {
    segmentTree.updateAdd(0, index - 1, inc);
  }

  public void multAll(int m) {
    segmentTree.updateMul(0, index - 1, m);
  }

  public int getIndex(int idx) {
    return idx >= 0 && idx < index ? (int) segmentTree.query(idx) : -1;
  }

}