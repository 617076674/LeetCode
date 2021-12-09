package lcp05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  private static class TreeNode {
    int index;
    int minTimeStamp = Integer.MAX_VALUE;
    int maxTimeStamp = Integer.MIN_VALUE;
    List<TreeNode> children = new ArrayList<>();

    public TreeNode(int index) {
      this.index = index;
    }
  }

  private Map<Integer, TreeNode> index2TreeNode = new HashMap<>();

  private Map<Integer, Integer> index2TimeStamp = new HashMap<>();

  private int timeStamp;

  private static final int MOD = 1000000007;

  public int[] bonus(int n, int[][] leadership, int[][] operations) {
    for (int i = 1; i <= n; i++) {
      index2TreeNode.put(i, new TreeNode(i));
    }
    for (int[] relation : leadership) {
      index2TreeNode.get(relation[0]).children.add(index2TreeNode.get(relation[1]));
    }
    dfs(index2TreeNode.get(1));
    SegmentTree segmentTree = new SegmentTree(n);
    List<Integer> resultList = new ArrayList<>();
    for (int[] operation : operations) {
      if (operation[0] == 1) {
        segmentTree.update(index2TimeStamp.get(operation[1]), index2TimeStamp.get(operation[1]), operation[2]);
      } else if (operation[0] == 2) {
        TreeNode treeNode = index2TreeNode.get(operation[1]);
        segmentTree.update(treeNode.minTimeStamp, treeNode.maxTimeStamp, operation[2]);
      } else {
        TreeNode treeNode = index2TreeNode.get(operation[1]);
        resultList.add(segmentTree.query(treeNode.minTimeStamp, treeNode.maxTimeStamp));
      }
    }
    int[] result = new int[resultList.size()];
    for (int i = 0; i < resultList.size(); i++) {
      result[i] = resultList.get(i);
    }
    return result;
  }

  private void dfs(TreeNode treeNode) {
    if (null == treeNode) {
      return;
    }
    index2TimeStamp.put(treeNode.index, timeStamp);
    treeNode.minTimeStamp = timeStamp++;
    for (TreeNode child : treeNode.children) {
      dfs(child);
    }
    treeNode.maxTimeStamp = timeStamp - 1;
  }

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
      return querySegmentTree(0, 0, n - 1, i, j);
    }

    private int querySegmentTree(int treeIndex, int left, int right, int i, int j) {
      if (i > right || j < left) {
        return 0;
      }
      if (lazy[treeIndex] != 0) {
        tree[treeIndex] = (int) (((right - left + 1L) * lazy[treeIndex] + tree[treeIndex]) % MOD);
        if (left != right) {
          lazy[leftChild(treeIndex)] += lazy[treeIndex];
          lazy[leftChild(treeIndex)] %= MOD;
          lazy[rightChild(treeIndex)] += lazy[treeIndex];
          lazy[rightChild(treeIndex)] %= MOD;
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
      return (leftResult + rightResult) % MOD;
    }

    public void update(int i, int j, int val) {
      update(0, 0, n - 1, i, j, val);
    }

    private void update(int treeIndex, int left, int right, int i, int j, int val) {
      if (lazy[treeIndex] != 0) {
        tree[treeIndex] = (int) (((right - left + 1L) * lazy[treeIndex] + tree[treeIndex]) % MOD);
        if (left != right) {
          lazy[leftChild(treeIndex)] += lazy[treeIndex];
          lazy[leftChild(treeIndex)] %= MOD;
          lazy[rightChild(treeIndex)] += lazy[treeIndex];
          lazy[rightChild(treeIndex)] %= MOD;
        }
        lazy[treeIndex] = 0;
      }
      if (left > right || i > right || j < left) {
        return;
      }
      if (i <= left && j >= right) {
        tree[treeIndex] = (int) (((right - left + 1L) * val + tree[treeIndex]) % MOD);
        if (left != right) {
          lazy[leftChild(treeIndex)] += val;
          lazy[leftChild(treeIndex)] %= MOD;
          lazy[rightChild(treeIndex)] += val;
          lazy[rightChild(treeIndex)] %= MOD;
        }
        return;
      }
      int mid = left + ((right - left) >> 1);
      update(leftChild(treeIndex), left, mid, i, j, val);
      update(rightChild(treeIndex), mid + 1, right, i, j, val);
      tree[treeIndex] = tree[leftChild(treeIndex)] + tree[rightChild(treeIndex)];
      tree[treeIndex] %= MOD;
    }

    private static int leftChild(int index) {
      return 2 * index + 1;
    }

    private static int rightChild(int index) {
      return 2 * index + 2;
    }

  }
}