package question0858_mirror_reflection;

public class Solution {
    public int mirrorReflection(int p, int q) {
        int gcd = gcd(p, q);
        int lcm = p * q / gcd;
        if (((lcm / p) & 1) == 1) {
            if (((lcm / q) & 1) == 1) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}