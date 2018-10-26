package question096;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83276409
 */
public class Solution3 {

    public int numTrees(int n) {
        int[] counts = new int[n + 1];
        counts[1] = 1;
        for (int i = 2; i <= n; i++) {
            counts[i] = counts[i - 1] * 2;
            for (int j = 1; j < i - 1; j++) {
                counts[i] += counts[j] * counts[i - j - 1];
            }
        }
        return counts[n];
    }
}
