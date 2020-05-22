package question0790_domino_and_tromino_tiling;

/**
 * 找规律。
 *
 * 时间复杂度是 O(N)。空间复杂度是 O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.2MB，击败100.00%。
 */
public class Solution {
    public int numTilings(int N) {
        if (N <= 2) {
            return N;
        } else if (N == 3) {
            return 5;
        }
        int MOD = 1000000007, num1 = 1, num2 = 2, num3 = 5, index = 3;
        while (index < N) {
            index++;
            int tmp = ((2 * num3) % MOD + num1) % MOD;
            num1 = num2;
            num2 = num3;
            num3 = tmp;
        }
        return num3;
    }
}