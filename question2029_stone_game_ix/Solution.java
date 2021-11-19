package question2029_stone_game_ix;

public class Solution {

  public boolean stoneGameIX(int[] stones) {
    int[] state = {0, 0, 0};
    for (int stone : stones) {
      state[stone % 3]++;
    }
    return "Alice".equals(dfs("Alice", 0, state[0], state[1], state[2]));
  }

  // player Alice Bob
  public String dfs(String player, int sum, int s0, int s1, int s2) {
    //情况1: (s0 == 0 && s1 == 0 && s2 == 0)->无牌可出,Bob胜。
    if (s0 == 0 && s1 == 0 && s2 == 0) {
      return "Bob";
    }
    //默认当前方输
    String nextPlayer;
    if ("Alice".equals(player)) {
      nextPlayer = "Bob";
    } else {
      nextPlayer = "Alice";
    }
    String winner = nextPlayer;
    //如果sum != 0,分析当前玩家可能面临什么情况,根据情况选择最优决策。
    //情况2: (s0 > 0)-> 此时玩家存在翻盘机会, 把困境抛给另一方。
    //情况3: (sum == 1 && s1 > 0)->此时石子0已经出完了,如果出石子2,sum将可以被3整除,只能出石子1。
    //情况4: (sum == 2 && s2 > 0)->此时石子0已经出完了,如果出石子1,sum将可以被3整除,只能出石子2。
    if (sum != 0) {
      if (s0 > 0) {
        return dfs(nextPlayer, sum, s0 - 1, s1, s2);
      }
      if (sum == 1 && s1 > 0) {
        return dfs(nextPlayer, 2, s0, s1 - 1, s2);
      }
      if (sum == 2 && s2 > 0) {
        return dfs(nextPlayer, 1, s0, s1, s2 - 1);
      }
    } else {
      //如果sum == 0,说明游戏刚刚开始，此时玩家有两个选择(选择余数为1的石子，选择余数为0的石子)
      //如果存在获胜决策,自己将获胜,否则落败。
      if (s1 > 0 && dfs(nextPlayer, 1, s0, s1 - 1, s2).equals(player)) {
        winner = player;
      }
      if (s2 > 0 && dfs(nextPlayer, 2, s0, s1, s2 - 1).equals(player)) {
        winner = player;
      }
    }
    return winner;
  }

}