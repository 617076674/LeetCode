package question0927_three_equal_parts;

public class Solution {

  public int[] threeEqualParts(int[] arr) {
    StringBuilder sb = new StringBuilder();
    int index = 0;
    while (index < arr.length && arr[index] == 0) {
      index++;
    }
    if (index == arr.length) {
      return new int[] {0, 2};
    }
    for (int i = index; i < arr.length; i++) {
      sb.append(arr[i]);
    }
    // 在 [index, arr.length - 1] 范围内寻找 [index, i], [i + 1, j - 1], [j, arr.length - 1]
    // 使得其二进制表示均相等。
    String s = sb.toString();
    for (int i = 0; i < s.length(); i++) {
      String s1 = s.substring(0, i + 1);
      if (!s.endsWith(s1)) {
        continue;
      }
      if (i + 1 >= s.length() - s1.length()) {
        continue;
      }
      int temp = s.substring(0, s.length() - s1.length()).indexOf(s1, i + 1);
      if (temp == -1) {
        continue;
      }
      // [index, i], [temp, temp + s1.length() - 1], [s.length() - s1.length(), s.length() - 1]
      boolean flag = true;
      for (int t = i + 1; t < temp; t++) {
        if (s.charAt(t) == '1') {
          flag = false;
          break;
        }
      }
      if (!flag) {
        continue;
      }
      for (int t = temp + s1.length(); t < s.length() - s1.length(); t++) {
        if (s.charAt(t) == '1') {
          flag = false;
          break;
        }
      }
      if (flag) {
        return new int[] {i + index, temp + s1.length() + index};
      }
    }
    return new int[] {-1, -1};
  }

}