package question0808_soup_servings;

import java.util.HashMap;
import java.util.Map;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(N ^ 2)。
 *
 * 执行用时：12ms，击败17.54%。消耗内存：39.3MB，击败50.00%。
 */
public class Solution1 {
    private Map<String, double[]> memo;

    public double soupServings(int N) {
        if (N >= 3276) {
            return 1.0;
        }
        memo = new HashMap<>();
        soupServings(N, N);
        double[] result = memo.get(N + "#" + N);
        return result[0] + 0.5 * result[1];
    }

    private double[] soupServings(int A, int B) {
        String key = A + "#" + B;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        double[] result;
        if (A <= 0 && B <= 0) {
            result = new double[] {0, 1, 0};
        } else if (A <= 0) {
            result = new double[] {1, 0, 0};
        } else if (B <= 0) {
            result = new double[] {0, 0, 1};
        } else {
            result = new double[3];
            double[] result1 = soupServings(A - 100, B), result2 = soupServings(A - 75, B - 25),
                    result3 = soupServings(A - 50, B - 50), result4 = soupServings(A - 25, B - 75);
            result[0] = 0.25 * (result1[0] + result2[0] + result3[0] + result4[0]);
            result[1] = 0.25 * (result1[1] + result2[1] + result3[1] + result4[1]);
            result[2] = 0.25 * (result1[2] + result2[2] + result3[2] + result4[2]);
        }
        memo.put(key, result);
        return result;
    }
}