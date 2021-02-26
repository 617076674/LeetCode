package question1736_latest_time_by_replacing_hidden_digits;

public class Solution {

  public String maximumTime(String time) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < time.length(); i++) {
      char c = time.charAt(i);
      if (c == '?') {
        if (i == 0) {
          if (time.charAt(i + 1) == '?') {
            sb.append("23");
            i++;
          } else if (time.charAt(i + 1) >= '4') {
            sb.append("1");
          } else {
            sb.append("2");
          }
        } else if (i == 1) {
          if (sb.charAt(0) == '2') {
            sb.append("3");
          } else {
            sb.append("9");
          }
        } else if (i == 3) {
          if (time.charAt(i + 1) == '?') {
            sb.append("59");
            i++;
          } else {
            sb.append("5");
          }
        } else if (i == 4) {
          sb.append("9");
        }
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

}
