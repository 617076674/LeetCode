package question1360_number_of_days_between_two_dates;

/**
 * 计算各个时间距离1971年1月1日的天数，再相减即可。
 *
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：3ms，击败100.00%。消耗内存：38.2MB，击败100.00%。
 */
public class Solution {
    private int[][] days = {{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFrom197111(date1) - daysFrom197111(date2));
    }

    private int daysFrom197111(String date) {
        int result = 0;
        for (int i = 1971; i < Integer.parseInt(date.substring(0, 4)); i++) {
            result += 365;
            if (isLeapYear(i)) {
                result++;
            }
        }
        for (int i = 1; i < Integer.parseInt(date.substring(5, 7)); i++) {
            if (isLeapYear(Integer.parseInt(date.substring(0, 4)))) {
                result += days[1][i - 1];
            } else {
                result += days[0][i - 1];
            }
        }
        return result + Integer.parseInt(date.substring(8)) - 1;
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}