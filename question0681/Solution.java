package question0681;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    private List<Integer> numList = new ArrayList<>();

    private String result;

    private int minGap = Integer.MAX_VALUE;

    private String time;

    private int day = str2Num("24:00");

    public String nextClosestTime(String time) {
      this.time = time;
      Set<Integer> numSet = new HashSet<>();
      for (int i = 0; i < time.length(); i++) {
        char c = time.charAt(i);
        if (c >= '0' && c <= '9') {
          int num = c - '0';
          if (numSet.add(num)) {
            numList.add(num);
          }
        }
      }
      dfs(new StringBuilder(), 0);
      return result;
    }

    private void dfs(StringBuilder sb, int index) {
      if (index == 5) {
        String tempResult = sb.toString();
        if (!isValid(tempResult)) {
          return;
        }
        int tempGap = gap(time, tempResult);
        if (null == result || tempGap < minGap) {
          minGap = tempGap;
          result = tempResult;
        }
        return;
      }
      if (index == 2) {
        sb.append(":");
        dfs(sb, index + 1);
        sb.deleteCharAt(sb.length() - 1);
      } else {
        for (int num : numList) {
          sb.append(num);
          dfs(sb, index + 1);
          sb.deleteCharAt(sb.length() - 1);
        }
      }
    }

    private boolean isValid(String s) {
      int num1 = s.charAt(0) - '0';
      int num2 = s.charAt(1) - '0';
      int num3 = s.charAt(3) - '0';
      int num4 = s.charAt(4) - '0';
      if (num1 * 10 + num2 >= 24) {
        return false;
      }
      if (num3 * 10 + num4 >= 60) {
        return false;
      }
      return true;
    }

    private int gap(String time1, String time2) {
      int num1 = str2Num(time1);
      int num2 = str2Num(time2);
      if (num2 > num1) {
        return num2 - num1;
      }
      return day + num2 - num1;
    }

    private int str2Num(String s) {
      int num1 = s.charAt(0) - '0';
      int num2 = s.charAt(1) - '0';
      int num3 = s.charAt(3) - '0';
      int num4 = s.charAt(4) - '0';
      return (num1 * 10 + num2) * 60 + num3 * 10 + num4;
    }

}