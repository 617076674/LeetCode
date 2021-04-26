package question1318_minimum_flips_to_make_a_or_b_equal_to_c;

public class Solution {

    public int minFlips(int a, int b, int c) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int target = getIth(c, i), num1 = getIth(a, i), num2 = getIth(b, i);
            if (target == 0) {
                if (num1 == 1) {
                    result++;
                }
                if (num2 == 1) {
                    result++;
                }
            } else {
                if (num1 == 0 && num2 == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    private static int getIth(int num, int i) {
        return (num >> i) & 1;
    }

}