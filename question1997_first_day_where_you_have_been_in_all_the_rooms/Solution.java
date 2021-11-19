package question1997_first_day_where_you_have_been_in_all_the_rooms;

/**
 * 动态规划。
 */
public class Solution {

  private static final int MOD = 1000000007;

  public int firstDayBeenInAllRooms(int[] nextVisit) {
    //dp[i][0]表示奇数次到达i时需要的天数
    //dp[i][1]表示偶数次到达i时需要的天数
    long[][] dp = new long[nextVisit.length][2];
    dp[0][1] = 1;//第二次到达0时需要一天
    for (int i = 1; i < nextVisit.length; i++) {
      //第一次到达i时,得到达两次i-1,才能达到i
      dp[i][0] = (dp[i - 1][1] + 1) % MOD;
      //第二次到达i是在第一次的基础上
      // +1 到达奇数次dp[nextVisit[i]][0],此时想要再次到达i,需要先偶数次的到达i-1
      // + (dp[i - 1][1] - dp[nextVisit[i]][0]),再次到达i-1需要的天数
      //再 +1 第二次到达i
      //                              注意:这里相减可能会出现负数,所以加上mod
      dp[i][1] = (dp[i][0] + 1 + (MOD + dp[i - 1][1] - dp[nextVisit[i]][0]) + 1) % MOD;
    }
    return (int) dp[dp.length - 1][0];
  }

}