package question1118_number_of_days_in_a_month;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：32.8MB，击败100.00%。
 */
public class Solution {
    public int numberOfDays(int Y, int M) {
        int[][] days = {{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
        int index = 1;
        if (Y % 400 == 0 || (Y % 4 == 0 && Y % 100 != 0)) {
            index--;
        }
        return days[index][M - 1];
    }
}