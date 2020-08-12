package question0093_restore_ip_addresses;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法。
 *
 * 时间复杂度是 O(n ^ 4)，其中 n 为字符串 s 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：7ms，击败30.19%。消耗内存：39.7MB，击败77.45%。
 */
public class Solution {
  private List<String> list = new ArrayList<>();

  public List<String> restoreIpAddresses(String s) {
    list = new ArrayList<>();
    restoreIpAddresses("", s, 0, 0);
    return list;
  }

  private void restoreIpAddresses(String ipAddress, String s, int index, int point) {
    if (index >= s.length()) {
      if (index == s.length() && ipAddress.length() == s.length() + 3 && ipAddress.charAt(ipAddress.length() - 1) != '.') {
        list.add(ipAddress);
      }
      return;
    }
    if (point >= 3) {
      if (point > 3 || index + 3 < s.length() || (index != s.length() - 1 && s.charAt(index) == '0')) {
        return;
      }
      int lastNum = Integer.parseInt(s.substring(index));
      if (lastNum >= 0 && lastNum <= 255) {
        list.add(ipAddress + s.substring(index));
      }
      return;
    }
    if (s.charAt(index) == '0') {
      restoreIpAddresses(ipAddress + "0.", s, index + 1, point + 1);
    } else {
      int nextThree = Integer.parseInt(s.substring(index, Math.min(index + 3, s.length())));
      if (nextThree <= 255) {
        for (int i = 1; i <= Math.min(3, s.length() - index); i++) {
          restoreIpAddresses(ipAddress + s.substring(index, index + i) + ".", s, index + i, point + 1);
        }
      } else {
        for (int i = 1; i <= 2; i++) {
          restoreIpAddresses(ipAddress + s.substring(index, index + i) + ".", s, index + i, point + 1);
        }
      }
    }
  }
}