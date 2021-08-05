package question0753_cracking_the_safe;

import java.util.HashSet;
import java.util.Set;

/**
 * 欧拉路径。
 */
public class Solution {

  private Set<Integer> seen = new HashSet<>();

  private StringBuilder result = new StringBuilder();

  private int highest, k;

  public String crackSafe(int n, int k) {
    highest = (int) Math.pow(10, n - 1);
    this.k = k;
    dfs(0);
    for (int i = 1; i < n; i++) {
      result.append('0');
    }
    return result.toString();
  }

  public void dfs(int node) {
    for (int x = 0; x < k; x++) {
      int next = node * 10 + x;
      if (!seen.contains(next)) {
        seen.add(next);
        dfs(next % highest);
        result.append(x);
      }
    }
  }

}