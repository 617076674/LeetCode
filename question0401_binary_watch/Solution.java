package question0401_binary_watch;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private List<String> result = new ArrayList<>();

  private boolean[] light = new boolean[10];    //light[0]-light[3]表示小时，light[4]-light[9]表示分钟

  public List<String> readBinaryWatch(int num) {
    generateTime(0, num, 0);
    return result;
  }

  private void generateTime(int count, int num, int index) {
    if (count == num) {
      int hour = 0;
      for (int i = 0; i < 4; i++) {
        if (light[i]) {
          hour += (int) Math.pow(2, 3 - i);
        }
      }
      int miniute = 0;
      for (int i = 4; i < 10; i++) {
        if (light[i]) {
          miniute += (int) Math.pow(2, 9 - i);
        }
      }
      if (hour > 11 || miniute > 59) {
        return;
      }
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(hour));
      stringBuilder.append(":");
      if (miniute < 10) {
        stringBuilder.append("0");
      }
      stringBuilder.append(miniute);
      result.add(stringBuilder.toString());
      return;
    }
    for (int i = index; i < light.length; i++) {
      if (!light[i]) {
        light[i] = true;
        generateTime(count + 1, num, i + 1);
        light[i] = false;
      }
    }
  }

}
