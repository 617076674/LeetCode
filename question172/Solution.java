package question172;

public class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        long divider = 5;
        while (n / divider > 0) {
            result += n / divider;
            divider *= 5;
        }
        return result;
    }
}
