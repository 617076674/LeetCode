package question1433_check_if_a_string_can_break_another_string;

import java.util.Arrays;

public class Solution {

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return checkIfCanBreakHelper(chars1, chars2) || checkIfCanBreakHelper(chars2, chars1);
    }

    private static boolean checkIfCanBreakHelper(char[] chars1, char[] chars2) {
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] > chars2[i]) {
                return false;
            }
        }
        return true;
    }

}