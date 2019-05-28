package question319;

public class Solution2 {
    public int bulbSwitch(int n) {
        int[] changes = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= n; j++) {
                if (0 == (i + 1) % j) {
                    changes[i]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (0 == changes[i] % 2) {
                result++;
            }
        }
        return result;
    }
}
