package question0878;

/**
 * @author qianyihui
 * @date 2019-08-14
 *
 * 数学方法。
 *
 * 时间复杂度是O(A + B)。空间复杂度是O(1)。
 *
 * 执行用时：5ms，击败28.21%。消耗内存：33.6MB，击败95.00%。
 */
public class Solution1 {
    public int nthMagicalNumber(int N, int A, int B) {
        int MOD = 1000000007;
        int L = A / gcd(A, B) * B;  //L是A和B的最小公倍数
        int M = L / A + L / B - 1;  //有M个神奇数字小于等于L，之所以减1，是因为数字L既能被A整除又能被B整除
        //需要寻找第N个能被A或B整除的数字，第q * M个能被A或B整除的数字是q * L
        //我们需要从q * L开始找起，寻找第r个能被A或B整除的数字
        int q = N / M, r = N % M;
        long ans = (long) q * L % MOD;
        if (r == 0)
            return (int) ans;
        //暴力法求从q * L开始的第r个能被A或B整除的数字
        int[] heads = new int[]{A, B};
        for (int i = 0; i < r - 1; ++i) {
            if (heads[0] <= heads[1])
                heads[0] += A;
            else
                heads[1] += B;
        }

        ans += Math.min(heads[0], heads[1]);
        return (int) (ans % MOD);
    }

    //欧几里得最大公约数算法
    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
