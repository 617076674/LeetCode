package question0878;

/**
 * @author qianyihui
 * @date 2019-08-14
 *
 * 小于等于x的神奇数字的个数是一个单调递增函数，可以用二分搜索来做这道题。
 *
 * 时间复杂度是O(log(N * max(A, B))。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：34.1MB，击败90.00%。
 */
public class Solution2 {
    public int nthMagicalNumber(int N, int A, int B) {
        int MOD = 1000000007;
        int L = A / gcd(A, B) * B;  //L是A和B的最小公倍数
        long left = 0, right = (long) 1e15;
        while (left < right) {
            long mid = left + ((right - left) >> 1);
            if (mid / A + mid / B - mid / L < N) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) (left % MOD);
    }

    //欧几里得最大公约数算法
    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
