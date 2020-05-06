package question1012_numbers_with_repeated_digits;

public class Solution {
    public int numDupDigitsAtMostN(int N) {
        if (N <= 10) {
            return 0;
        } else if (N < 100) {
            return 1 + (N - 11) / 10;
        }
        return -1;
    }
}