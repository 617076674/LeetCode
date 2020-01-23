package question0365_water_and_jug_problem;

/**
 * 裴蜀定理：若a，b是整数，且gcd(a,b) = d，那么对于任意的整数x，y，ax+by都一定是d的倍数，特别地，一定存在整数x，y，使ax + by = d成立。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：33.2MB，击败15.48%。
 */
public class Solution3 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return x == z || y == z;
        }
        return z % gcd(x, y) == 0;
    }

    /**
     * 欧几里得最大公约数算法
     */
    private int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
