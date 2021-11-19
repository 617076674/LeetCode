package question1505;

import java.util.ArrayList;
import java.util.List;

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

  public String minInteger(String num, int k) {
    List<Integer>[] num2IndexList = new ArrayList[10];
    for (int i = 0; i < num.length(); i++) {
      int digit = num.charAt(i) - '0';
      if (num2IndexList[digit] == null) {
        num2IndexList[digit] = new ArrayList<>();
      }
      num2IndexList[digit].add(i);
    }
    int[] data = new int[num.length()];
    boolean[] moved = new boolean[num.length()];
    SegmentTree segmentTree = new SegmentTree(data);
    StringBuilder result = new StringBuilder();
    while (k > 0 && result.length() < num.length()) {
      for (int i = 0; i < num2IndexList.length; i++) {
        if (num2IndexList[i] == null || num2IndexList[i].isEmpty()) {
          continue;
        }
        int cost = num2IndexList[i].get(0) - segmentTree.query(0, num2IndexList[i].get(0) - 1);
        if (k < cost) {
          continue;
        }
        k -= cost;
        segmentTree.update(num2IndexList[i].get(0), 1);
        result.append(i);
        moved[num2IndexList[i].remove(0)] = true;
        break;
      }
    }
    for (int i = 0; i < moved.length; i++) {
      if (!moved[i]) {
        result.append(num.charAt(i));
      }
    }
    return result.toString();
  }

}