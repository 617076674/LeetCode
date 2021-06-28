package question1904_the_number_of_full_rounds_you_have_played;

public class Solution {

  public int numberOfRounds(String startTime, String finishTime) {
    int startHour = getHour(startTime), startMinute = getMinute(startTime),
        finishHour = getHour(finishTime), finishMinute = getMinute(finishTime);
    if (totalMinutes(startHour, startMinute) > totalMinutes(finishHour, finishMinute)) {
      finishHour += 24;
    }
    if (startMinute != 0) {
        startMinute = getActualStartMinute(startMinute);
        if (startMinute == 0) {
            startHour++;
        }
    }
    int startTotalMinute = totalMinutes(startHour, startMinute),
        finishTotalMinute = totalMinutes(finishHour, finishMinute), result = 0;
    while (startTotalMinute + 15 <= finishTotalMinute) {
        result++;
        startTotalMinute += 15;
    }
    return result;
  }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfRounds("23:46", "00:01"));
    }

  private static int totalMinutes(int hour, int minute) {
    return hour * 60 + minute;
  }

  private static int getActualStartMinute(int startMinute) {
    if (startMinute == 0) {
      return 0;
    }
    if (startMinute <= 15) {
      return 15;
    }
    if (startMinute <= 30) {
      return 30;
    }
    if (startMinute <= 45) {
      return 45;
    }
    return 0;
  }

  private static int getHour(String time) {
    return Integer.parseInt(time.substring(0, 2));
  }

  private static int getMinute(String time) {
    return Integer.parseInt(time.substring(3));
  }

}