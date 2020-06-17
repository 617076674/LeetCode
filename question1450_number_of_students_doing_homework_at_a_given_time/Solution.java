package question1450_number_of_students_doing_homework_at_a_given_time;

/**
 * 时间复杂度是 O(startTime.length)。空间复杂度是 O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：37.6MB，击败100.00%。
 */
public class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                result++;
            }
        }
        return result;
    }
}