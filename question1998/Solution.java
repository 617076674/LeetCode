package question1998;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  private static class UnionFind {
    int[] parent;

    public UnionFind(int n) {
      this.parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    public void union(int a, int b) {
      int aParent = findParent(a), bParent = findParent(b);
      if (aParent != bParent) {
        parent[aParent] = bParent;
      }
    }

    public int findParent(int a) {
      int x = a;
      while (a != parent[a]) {
        a = parent[a];
      }
      while (parent[x] != a) {
        int z = parent[x];
        parent[x] = a;
        x = z;
      }
      return a;
    }
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  private boolean canSwap(int num1, int num2) {
    return gcd(num1, num2) > 1;
  }

  public static void main(String[] args) {
//    int[] nums = {7,21,3};
    int[] nums = {8,7,7,9,12,4,7,21,5,10};
    System.out.println(new Solution().gcdSort(nums));
  }

  private static List<Integer> getAllPrimeFactors(int num) {
    List<Integer> result = new ArrayList<>();
    for (int i = 2; i < num; i++) {
      while (num != i) {
        if (num % i != 0) {
          break;
        }
        result.add(i);
        num /= i;
      }
    }
    result.add(num);
    return result;
  }

  public boolean gcdSort(int[] nums) {
    UnionFind unionFind = new UnionFind(100001);
    for (int num : nums) {
      List<Integer> primeFactors = getAllPrimeFactors(num);
      for (int primeFactor : primeFactors) {
        unionFind.union(num, primeFactor);
      }
    }
    Map<Integer, List<Integer>> parent2Children = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int parent = unionFind.findParent(nums[i]);
      List<Integer> children = parent2Children.get(parent);
      if (null == children) {
        children = new ArrayList<>();
        children.add(i);
        parent2Children.put(parent, children);
      } else {
        children.add(i);
      }
    }
    int[] afterSort = new int[nums.length];
    for (Map.Entry<Integer, List<Integer>> entry : parent2Children.entrySet()) {
      List<Integer> copy = new ArrayList<>(entry.getValue());
      Collections.sort(copy);
      Collections.sort(entry.getValue(), Comparator.comparingInt(index -> nums[index]));
      for (int i = 0; i < copy.size(); i++) {
        afterSort[copy.get(i)] = nums[entry.getValue().get(i)];
      }
    }
    for (int i = 1; i < afterSort.length; i++) {
      if (afterSort[i] < afterSort[i - 1]) {
        return false;
      }
    }
    return true;
  }
}