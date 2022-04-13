package question0555;

public class Solution {

  public String splitLoopedString(String[] strs) {
    String[] reverseStrs = new String[strs.length];
    for (int i = 0; i < strs.length; i++) {
      reverseStrs[i] = reverse(strs[i]);
    }
    boolean[] cmp = new boolean[strs.length];
    for (int i = 0; i < strs.length; i++) {
      cmp[i] = strs[i].compareTo(reverseStrs[i]) > 0;
    }
    String result = null;
    for (int start = 0; start < strs.length; start++) {
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i < strs.length; i++) {
        int index = (i + start) % strs.length;
        if (cmp[index]) {
          sb.append(strs[index]);
        } else {
          sb.append(reverseStrs[index]);
        }
      }
      for (int i = 0; i < strs[start].length(); i++) {
        String temp = strs[start].substring(i) + sb + strs[start].substring(0, i);
        if (null == result || temp.compareTo(result) > 0) {
          result = temp;
        }
      }
      for (int i = 0; i < reverseStrs[start].length(); i++) {
        String temp = reverseStrs[start].substring(i) + sb + reverseStrs[start].substring(0, i);
        if (null == result || temp.compareTo(result) > 0) {
          result = temp;
        }
      }
    }
    return result;
  }

  private static String reverse(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      sb.append(s.charAt(i));
    }
    return sb.toString();
  }

}