package contest_single_week.question3;

public class Solution {

  public String repeatLimitedString(String s, int repeatLimit) {
    StringBuilder sb = new StringBuilder();
    int[] map = new int[26];
    for (int i = 0; i < s.length(); i++) {
      map[s.charAt(i) - 'a']++;
    }
    int pre = -1, cnt = 1;
    while (true) {
      boolean flag = false;
      if (cnt == repeatLimit) {
        for (int i = map.length - 1; i >= 0; i--) {
          if (map[i] > 0 && pre != i) {
            map[i]--;
            sb.append((char) ('a' + i));
            pre = i;
            cnt = 1;
            flag = true;
            break;
          }
        }
      } else {
        for (int i = map.length - 1; i >= 0; i--) {
          if (map[i] > 0) {
            map[i]--;
            sb.append((char) ('a' + i));
            if (pre == i) {
              cnt++;
            } else {
              pre = i;
              cnt = 1;
            }
            flag = true;
            break;
          }
        }
      }
      if (!flag) {
        break;
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
//    System.out.println(new Solution().repeatLimitedString("cczazcc", 3));
    System.out.println(new Solution().repeatLimitedString("aababab", 2));
  }

}