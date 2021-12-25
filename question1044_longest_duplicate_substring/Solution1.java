package question1044_longest_duplicate_substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

  private static final long MOD = 1L << 32;

  private static final long BASE = 26;

  private int[] nums;

  public String longestDupSubstring(String S) {
    int n = S.length();
    nums = new int[n];
    for (int i = 0; i < n; ++i) {
      nums[i] = S.charAt(i) - 'a';
    }
    int left = 1, right = n, start;
    String result = "";
    while (left < right) {
      if (left + 1 == right) {
        start = search(right);
        if (start != -1) {
          return S.substring(start, start + right);
        }
        start = search(left);
        if (start != -1) {
          return S.substring(start, start + left);
        }
        return "";
      }
      int mid = left + ((right - left) >> 1);
      start = search(mid);
      if (start != -1) {
        result = S.substring(start, start + mid);
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return result;
  }

  public int search(int len) {
    long h = 0L;
    for (int i = 0; i < len; i++) {
      h = (h * BASE + nums[i]) % MOD;
    }
    Map<Long, List<int[]>> seen = new HashMap<>();
    List<int[]> list = new ArrayList<>();
    list.add(new int[] {0, len - 1});
    seen.put(h, list);
    long aL = 1;
    for (int i = 1; i <= len; ++i) {
      aL = (aL * BASE) % MOD;
    }
    for (int start = 1; start < nums.length - len + 1; ++start) {
      h = (h * BASE - nums[start - 1] * aL % MOD + MOD) % MOD;
      h = (h + nums[start + len - 1]) % MOD;
      List<int[]> origin = seen.get(h);
      if (null == origin) {
        origin = new ArrayList<>();
        origin.add(new int[] {start, start + len - 1});
        seen.put(h, origin);
      } else {
        for (int[] edges : origin) {
          int index = 0;
          boolean flag = true;
          for (int i = edges[0]; i <= edges[1]; i++) {
            if (nums[i] != nums[start + index++]) {
              flag = false;
              break;
            }
          }
          if (flag) {
            return start;
          }
        }
      }
    }
    return -1;
  }

}