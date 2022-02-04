package question2157;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  private static class UnionFind {

    int[] parent;

    int n;

    int setCount;

    int maxGroup = 1;

    int[] groupSize;

    public UnionFind(int n) {
      this.n = n;
      this.setCount = n;
      this.parent = new int[n];
      for (int i = 0; i < n; ++i) {
        parent[i] = i;
      }
      groupSize = new int[n];
      Arrays.fill(groupSize, 1);
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

    public boolean union(int a, int b) {
      int aParent = findParent(a), bParent = findParent(b);
      if (aParent != bParent) {
        parent[aParent] = bParent;
        setCount--;
        groupSize[bParent] += groupSize[aParent];
        maxGroup = Math.max(maxGroup, groupSize[bParent]);
        return true;
      }
      return false;
    }

  }

  public int[] groupStrings(String[] words) {
    UnionFind unionFind = new UnionFind(words.length);
    Map<Integer, List<Integer>> num2Indexes = new HashMap<>();
    int[] nums = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      nums[i] = string2Int(words[i]);
      List<Integer> indexes = num2Indexes.get(nums[i]);
      if (null == indexes) {
        indexes = new ArrayList<>();
        indexes.add(i);
        num2Indexes.put(nums[i], indexes);
      } else {
        indexes.add(i);
      }
    }
    for (Map.Entry<Integer, List<Integer>> entry : num2Indexes.entrySet()) {
      List<Integer> indexes = entry.getValue();
      for (int i = 1; i < indexes.size(); i++) {
        unionFind.union(indexes.get(i - 1), indexes.get(i));
      }
    }
    for (Map.Entry<Integer, List<Integer>> entry : num2Indexes.entrySet()) {
      int num = entry.getKey();
      for (int j = 0; j < 26; j++) {
        int temp = (num ^ (1 << j));
        List<Integer> tempIndexes = num2Indexes.get(temp);
        if (null == tempIndexes) {
          continue;
        }
        for (int index : tempIndexes) {
          unionFind.union(index, entry.getValue().get(0));
        }
      }
      int copyNum = num;
      while (copyNum > 0) {
        int del = lowbit(copyNum);
        // 把一个 1 变成 0
        int temp = num - del;
        for (int k = 0; k < 26; k++) {
          int copyTemp = temp;
          if ((copyTemp & (1 << k)) == 0) {
            // 把一个 0 变成 1
            copyTemp ^= (1 << k);
            List<Integer> tempIndexes = num2Indexes.get(copyTemp);
            if (null == tempIndexes) {
              continue;
            }
            for (int index : tempIndexes) {
              unionFind.union(index, entry.getValue().get(0));
            }
          }
        }
        copyNum -= del;
      }
    }
    return new int[] {unionFind.setCount, unionFind.maxGroup};
  }

  private static int lowbit(int x) {
    return x & (-x);
  }

  private static int string2Int(String word) {
    int result = 0;
    for (int i = 0; i < word.length(); i++) {
      result |= (1 << (word.charAt(i) - 'a'));
    }
    return result;
  }

}