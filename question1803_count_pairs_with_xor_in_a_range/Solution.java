package question1803_count_pairs_with_xor_in_a_range;

public class Solution {

  private static class Trie {

    private Trie[] children = new Trie[2];

    private int cnt;

  }

  public int countPairs(int[] nums, int low, int high) {
    return calc(nums, high) - calc(nums, low - 1);
  }

  // 统计异或值小于等于 border 的数字对数
  public int calc(int[] nums, int border) {
    Trie root = new Trie();
    int result = 0;
    for (int num : nums) {
      Trie u = root;
      int now = 0, j;
      // j 从 16 开始是因为最大的 num 值是 20000, 转换为二进制是
      for (j = 16; j >= 0; j--) {
        int cur = (num >> j) & 1;
        if (now + (1 << j) > border) {
          // 此时，如果第 j 位是 1，已经超出了 border，说明另一个数第 j 位也必须是 1，因此寻找 u.children[cur]
          if (u.children[cur] != null) {
            u = u.children[cur];
          } else {
            break;
          }
        } else {
          // 此时，如果第 j 位是 1，还没有超出 border，说明另一个数是 1 的计数需要全部算在内
          if (u.children[cur] != null) {
            result += u.children[cur].cnt;
          }
          // 但是，如果另一个数是 0 (cur ^ 1)，那么还需要继续判断第 j - 1 位的值
          if (u.children[cur ^ 1] != null) {
            u = u.children[cur ^ 1];
            now += (1 << j);
          } else {
            break;
          }
        }
      }
      if (j == -1) {
        result += u.cnt;
      }
      // 插入当前数字 num
      u = root;
      for (j = 16; j >= 0; --j) {
        int cur = (num >> j) & 1;
        if (u.children[cur] == null) {
          u.children[cur] = new Trie();
        }
        u = u.children[cur];
        u.cnt++;
      }
    }
    return result;
  }

}