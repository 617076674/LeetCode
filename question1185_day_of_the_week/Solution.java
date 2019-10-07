package question1185_day_of_the_week;

/**
 * 1971年1月1日是星期五，计算离该日子的距离，再对7取余。
 *
 * 时间复杂度是O(year)。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：33.7MB，击败100.00%。
 */
public class Solution {
    private int[] dayOfMonthInLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int[] dayOfMonthInNotLeapYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private String[] weeks = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

    public String dayOfTheWeek(int day, int month, int year) {
        return weeks[calculateDaysFrom19700101(day, month, year) % 7];
    }

    private int calculateDaysFrom19700101(int day, int month, int year) {
        int result = 0;
        for (int i = 1971; i < year; i++) {
            result += 365;
            if (isLeapYear(i)) {
                result++;
            }
        }
        if (isLeapYear(year)) {
            for (int i = 1; i < month; i++) {
                result += dayOfMonthInLeapYear[i - 1];
            }
        } else {
            for (int i = 1; i < month; i++) {
                result += dayOfMonthInNotLeapYear[i - 1];
            }
        }
        result += day - 1;
        return result;
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
