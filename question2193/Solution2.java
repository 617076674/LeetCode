package question2193;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * 贪心 + 树状数组
 */
public class Solution2 {

  public int minMovesToMakePalindrome(String s) {
    Map<Character, Deque<Integer>> char2Positions = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      Deque<Integer> deque = char2Positions.get(c);
      if (null == deque) {
        deque = new LinkedList<>();
        char2Positions.put(c, deque);
      }
      deque.addLast(i);
    }
    int result = 0, count = 0;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      Deque<Integer> deque = char2Positions.get(c);
      if (deque.isEmpty()) {
        continue;
      }
      if (deque.size() == 1) {
        // 共有 s.length() / 2 个配对，已经配对了 count 个，后续还
        // 有 (s.length() / 2 - count) 个字符会移动到第 i 个字符之前
        result += i + (s.length() / 2 - count) - s.length() / 2;
        deque.pollLast();
      } else {
        list.add(deque.pollLast());
        deque.pollFirst();
        result += i - count;
        count++;
      }
    }
    int[] nums = new int[list.size()];
    for (int i = list.size() - 1; i >= 0; i--) {
      nums[list.size() - i - 1] = list.get(i);
    }
    return result + reversePairs(nums);
  }

  private int reversePairs(int[] nums) {
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
      Long another = treeSet.ceiling(num * 1L);
      if (null != another) {
        int anotherIdx = num2Index.get(another);
        if (another == num) {
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
      if (i <= left && j >= right) {
        return tree[treeIndex];
      }
      int mid = (left + right) / 2;
      if (i > mid) {
        return query(rightChild(treeIndex), mid + 1, right, i, j);
      }
      if (j <= mid) {
        return query(leftChild(treeIndex), left, mid, i, j);
      }
      return query(leftChild(treeIndex), left, mid, i, mid) +
          query(rightChild(treeIndex), mid + 1, right, mid + 1, j);
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
      if (i <= left && j >= right) {
        tree[treeIndex] += (right - left + 1) * delta;
        if (left != right) {
          lazy[leftChild(treeIndex)] += delta;
          lazy[rightChild(treeIndex)] += delta;
        }
        return;
      }
      int mid = (left + right) / 2;
      if (i > mid) {
        update(rightChild(treeIndex), mid + 1, right, i, j, delta);
      } else if (j <= mid) {
        update(leftChild(treeIndex), left, mid, i, j, delta);
      } else {
        update(leftChild(treeIndex), left, mid, i, mid, delta);
        update(rightChild(treeIndex), mid + 1, right, mid + 1, j, delta);
      }
      tree[treeIndex] = tree[leftChild(treeIndex)] + tree[rightChild(treeIndex)];
    }

    private static int leftChild(int i) {
      return 2 * i + 1;
    }

    private static int rightChild(int i) {
      return 2 * i + 2;
    }
  }

}