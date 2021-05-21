package question1774_closest_dessert_cost;

public class Solution {

  private int result = Integer.MAX_VALUE;

  public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
    for (int baseCost : baseCosts) {
      dfs(toppingCosts, 0, baseCost, target);
    }
    return result;
  }

  private void dfs(int[] toppingCosts, int index, int cost, int target) {
    if (index == toppingCosts.length) {
      if (Math.abs(cost - target) < Math.abs(result - target)
          || (Math.abs(cost - target) == Math.abs(result - target) && cost < result)) {
        result = cost;
      }
      return;
    }
    dfs(toppingCosts, index + 1, cost, target);
    dfs(toppingCosts, index + 1, cost + toppingCosts[index], target);
    dfs(toppingCosts, index + 1, cost + toppingCosts[index] * 2, target);
  }

}