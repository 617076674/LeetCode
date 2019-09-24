package question0551_student_attendance_record_i;

/**
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败98.99%。消耗内存：34.3MB，击败93.97%。
 */
public class Solution {
    public boolean checkRecord(String s) {
        int n = s.length(), countA = 0, maxSequenceOfL = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                countA++;
            } else if (c == 'L') {
                int countL = 1;
                while (i + 1 < n && s.charAt(i + 1) == 'L') {
                    i++;
                    countL++;
                }
                maxSequenceOfL = Math.max(maxSequenceOfL, countL);
            }
        }
        return countA <= 1 && maxSequenceOfL <= 2;
    }
}
