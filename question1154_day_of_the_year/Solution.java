package question1154_day_of_the_year;

public class Solution {

  private static final int[][] DAY_OF_MONTH = {{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
      {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};

  public int dayOfYear(String date) {
    String[] inputs = date.split("-");
    int year = Integer.parseInt(inputs[0]), month = Integer.parseInt(inputs[1]), day =
        Integer.parseInt(inputs[2]);
    int index = 0, result = 0;
    if (isLeapYear(year)) {
      index++;
    }
    for (int i = 1; i < month; i++) {
      result += DAY_OF_MONTH[index][i - 1];
    }
    return result + day;
  }

  private static boolean isLeapYear(int year) {
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  }

}
