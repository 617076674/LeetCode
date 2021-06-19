package question0810_chalkboard_xor_game;

public class Solution {

  public boolean xorGame(int[] nums) {
    if (nums.length % 2 == 0) {
      return true;
    }
    int xor = 0;
    for (int num : nums) {
      xor ^= num;
    }
    return xor == 0;
  }

}