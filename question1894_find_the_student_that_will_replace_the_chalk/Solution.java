package question1894_find_the_student_that_will_replace_the_chalk;

public class Solution {

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int num : chalk) {
            sum += num;
        }
        k %= sum;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        return -1;
    }

}