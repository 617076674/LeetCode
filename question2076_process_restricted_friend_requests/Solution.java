package question2076_process_restricted_friend_requests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  private Map<Integer, Set<Integer>> id2Enemies = new HashMap<>();

  private static class UnionFind {

    int[] parent;

    int n;

    int setCount;

    Map<Integer, Set<Integer>> parent2Children = new HashMap<>();

    Map<Integer, Set<Integer>> map;

    public UnionFind(int n, Map<Integer, Set<Integer>> id2Enemies) {
      this.n = n;
      this.setCount = n;
      this.parent = new int[n];
      for (int i = 0; i < n; ++i) {
        parent[i] = i;
        Set<Integer> set = new HashSet<>();
        set.add(i);
        parent2Children.put(i, set);
      }
      this.map = id2Enemies;
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
        Set<Integer> set1 = map.get(aParent), set2 = map.get(bParent);
        Set<Integer> children1 = parent2Children.get(aParent),
            children2 = parent2Children.get(bParent);
        if (null != set2) {
          for (int child : children1) {
            if (set2.contains(child)) {
              return false;
            }
          }
        }
        if (null != set1) {
          for (int child : children2) {
            if (set1.contains(child)) {
              return false;
            }
          }
        }
        parent[aParent] = bParent;
        setCount--;
        parent2Children.get(bParent).addAll(parent2Children.get(aParent));
        if (set1 == null) {
          if (null != set2) {
            map.put(aParent, new HashSet<>(set2));
          }
        } else {
          if (null != set2) {
            set1.addAll(set2);
          }
        }
        if (set2 == null) {
          if (null != set1) {
            map.put(bParent, new HashSet<>(set1));
          }
        } else {
          if (null != set1) {
            set2.addAll(set1);
          }
        }
        return true;
      }
      return true;
    }

  }

  public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
    for (int[] restriction : restrictions) {
      int a = restriction[0], b = restriction[1];
      Set<Integer> set = id2Enemies.get(a);
      if (null == set) {
        set = new HashSet<>();
        set.add(b);
        id2Enemies.put(a, set);
      } else {
        set.add(b);
      }
      set = id2Enemies.get(b);
      if (null == set) {
        set = new HashSet<>();
        set.add(a);
        id2Enemies.put(b, set);
      } else {
        set.add(a);
      }
    }
    UnionFind unionFind = new UnionFind(n, id2Enemies);
    boolean[] result = new boolean[requests.length];
    for (int i = 0; i < requests.length; i++) {
      int a = requests[i][0], b = requests[i][1];
      result[i] = unionFind.union(a, b);
    }
    return result;
  }

}