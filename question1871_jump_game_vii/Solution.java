package question1871_jump_game_vii;

public class Solution {

  public boolean canReach(String s, int minJump, int maxJump) {
    int[] sums = new int[s.length() + 1]; // sums[i] 表示在 [0, i - 1] 范围内可达的位置数量
    sums[1] = 1;
    for (int i = 2; i < sums.length; i++) {
      int cur = 0;
      if (s.charAt(i - 1) == '0') {
        int left = Math.max(0, i - 1 - maxJump), right = i - 1 - minJump;
        // [left, right] 范围内是否有可达的位置
        if (right >= left && sums[right + 1] - sums[left] > 0) {
          cur = 1;
        }
      }
      sums[i] = sums[i - 1] + cur;
    }
    return sums[s.length()] - sums[s.length() - 1] == 1;
  }

}