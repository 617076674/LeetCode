package question1154_day_of_the_year;

/**
 * 对闰年和非闰年进行分别处理。
 *
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：3ms，击败81.38%。消耗内存：34.5MB，击败100.00%。
 */
public class Solution {
    int[][] dayOfMonth = {{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                          {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};

    public int dayOfYear(String date) {
        String[] inputs = date.split("-");
        int year = Integer.parseInt(inputs[0]), month = Integer.parseInt(inputs[1]), day = Integer.parseInt(inputs[2]);
        int index = 0, result = 0;
        if (isLeapYear(year)) {
            index++;
        }
        for (int i = 1; i < month; i++) {
            result += dayOfMonth[index][i - 1];
        }
        return result + day;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }
}
