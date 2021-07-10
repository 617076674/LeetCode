package question0710_random_pick_with_blacklist;

import java.util.Arrays;

public class Solution2 {

  private int[] blacklist;

  private int n;

  public Solution2(int n, int[] blacklist) {
    this.n = n;
    this.blacklist = blacklist;
    Arrays.sort(blacklist);
  }

  public int pick() {
    int index = (int) (Math.random() * (n - blacklist.length));
    if (blacklist.length == 0) {
      return index;
    }
    if (index < blacklist[0]) {
      return index;
    }
    if (index >= blacklist[blacklist.length - 1] - blacklist.length + 1) {
      return index + blacklist.length;
    }
    // 在 [0, n - 1] 范围内寻找第 index 个数，这个数不在 blacklist 里
    int left = 0, right = blacklist.length - 1;
    while (left + 1 < right) {
      int mid = left + ((right - left) >> 1);
      // 比 blacklist[mid] 要小，且在白名单中的元素个数
      if (blacklist[mid] - mid == index) {
        left = mid;
      } else if (blacklist[mid] - mid > index) {
        right = mid;
      } else if (blacklist[mid] - mid < index) {
        left = mid;
      }
    }
    // 这个数一定在 blacklist[left], blacklist[right] 之间
    return index + left + 1;
  }

}