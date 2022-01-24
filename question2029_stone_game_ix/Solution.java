package question2029_stone_game_ix;

/**
 * Alice 一开始只可能选 1 或 2。
 *
 * 如果 Alice 选 1，那么序列应该是 1、1、2、1、2、1、2、...
 *
 * 即 剔除 0 之后的序列是固定的，0 可以充当缓冲剂，比如下一个需要寻找的数字是 2，但是现在找不到 2 了，那么可以用 0 填
 * 上，把找 2 这件事踢皮球给对面，因此如果 0 的个数是偶数，皮球踢来踢去最终还是会回到自己这边，没有意义，只有 0 是奇数
 * 的时候才可能用 0 来逆转困境，因此对于 0 的数量只需考虑奇偶。
 *
 * 如果 Alice 选 2，那么序列应该是 2、2、1、2、1、2、1、...
 *
 * 其余分析同理。
 */
public class Solution {

  public boolean stoneGameIX(int[] stones) {
    int[] data = new int[3];
    for (int stone : stones) {
      data[stone % 3]++;
    }
    data[0] %= 2;
    return stoneGameIXHelper(0, data, 0);
  }

  // turn == 0: Alice, turn == 1: Bob
  private boolean stoneGameIXHelper(int sum, int[] data, int turn) {
    if (data[0] == 0 && data[1] == 0 && data[2] == 0) {
      return turn == 1;
    }
    // 避免输掉游戏
    for (int i = 0; i < data.length; i++) {
      if (data[i] == 0) {
        continue;
      }
      if ((sum + i) % 3 == 0) {
        continue;
      }
      data[i]--;
      boolean temp = stoneGameIXHelper((sum + i) % 3, data, 1 - turn);
      data[i]++;
      if (!temp) {
        return true;
      }
    }
    return false;
  }

}