package question201;

public class Solution1 {
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = 1;
            for (int j = m; j <= n; j++) {
                temp &= j >> i;
                if (0 == temp || j == Integer.MAX_VALUE) {
                    break;
                }
            }
            result += temp << i;
        }
        return result;
    }
}
