package question093;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81603416
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<String> list;

    public List<String> restoreIpAddresses(String s) {
        list = new ArrayList<>();
        restoreIpAddresses("", s, 0, 0);
        return list;
    }

    private void restoreIpAddresses(String ipAddress, String s, int index, int numPoint) {
        if (index >= s.length()) {
            if (index == s.length() && ipAddress.length() == s.length() + 3 && ipAddress.charAt(ipAddress.length() - 1) != '.') {
                list.add(ipAddress);
            }
            return;
        }
        if (numPoint == 3) {
            if (index + 3 < s.length()) {
                return;
            }
            if (index != s.length() - 1 && s.charAt(index) == '0') {
                return;
            }
            int lastNum = Integer.parseInt(s.substring(index));
            if (lastNum >= 0 && lastNum <= 255) {
                restoreIpAddresses(ipAddress + s.substring(index), s, s.length(), 3);
            }
        } else {
            if (s.charAt(index) == '0') {
                restoreIpAddresses(ipAddress + s.charAt(index) + ".", s, index + 1, numPoint + 1);
            } else {
                int nextThree = Integer.parseInt(s.substring(index, Math.min(index + 3, s.length())));
                if (nextThree <= 255) {
                    for (int i = 1; i <= Math.min(3, s.length() - index); i++) {
                        restoreIpAddresses(ipAddress + s.substring(index, index + i) + ".", s, index + i, numPoint + 1);
                    }
                } else {
                    for (int i = 1; i <= 2; i++) {
                        restoreIpAddresses(ipAddress + s.substring(index, index + i) + ".", s, index + i, numPoint + 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("010010"));
    }

}
