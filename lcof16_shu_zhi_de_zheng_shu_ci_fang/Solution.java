package lcof16_shu_zhi_de_zheng_shu_ci_fang;

public class Solution {

    public double myPow(double x, int n) {
        return myPowHelper(x, n);
    }

    private double myPowHelper(double x, long n) {
        if (n == 0l) {
            return 1.0;
        }
        if (n > 0l) {
            double half = myPowHelper(x, n >> 1);
            if ((n & 1) == 1) {
                return half * half * x;
            }
            return half * half;
        }
        return 1 / myPowHelper(x, -n);
    }

}