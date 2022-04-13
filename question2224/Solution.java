package question2224;

public class Solution {

  private static int str2Int(String time) {
    int hour = Integer.parseInt(time.substring(0, 2));
    int minute = Integer.parseInt(time.substring(3));
    return hour * 60 + minute;
  }

  public int convertTime(String current, String correct) {
    int curMinutes = str2Int(current), correctMinutes = str2Int(correct);
    int res = 0;
    int gap = correctMinutes - curMinutes;
    int[] steps = {60, 15, 5, 1};
    for (int i = 0; i < steps.length; i++) {
      while (gap >= steps[i]) {
        gap -= steps[i];
        res++;
      }
    }
    return res;
  }

}