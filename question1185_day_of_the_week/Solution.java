package question1185_day_of_the_week;

public class Solution {

  private static final int[] DAY_OF_MONTH_IN_LEAP_YEAR =
      {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  private static final int[] DAY_OF_MONTH_IN_NOT_LEAP_YEAR =
      {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  private static final String[] WEEKS =
      {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

  public String dayOfTheWeek(int day, int month, int year) {
    return WEEKS[calculateDaysFrom19700101(day, month, year) % 7];
  }

  private static int calculateDaysFrom19700101(int day, int month, int year) {
    int result = 0;
    for (int i = 1971; i < year; i++) {
      result += 365;
      if (isLeapYear(i)) {
        result++;
      }
    }
    if (isLeapYear(year)) {
      for (int i = 1; i < month; i++) {
        result += DAY_OF_MONTH_IN_LEAP_YEAR[i - 1];
      }
    } else {
      for (int i = 1; i < month; i++) {
        result += DAY_OF_MONTH_IN_NOT_LEAP_YEAR[i - 1];
      }
    }
    result += day - 1;
    return result;
  }

  private static boolean isLeapYear(int year) {
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  }

}