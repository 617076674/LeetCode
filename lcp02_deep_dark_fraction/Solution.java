package lcp02_deep_dark_fraction;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：37.4MB，击败5.71%。
 */
public class Solution {
    public int[] fraction(int[] cont) {
        int numerator = cont[cont.length - 1], denominator = 1;
        for (int i = cont.length - 2; i >= 0; i--) {
            int newNumerator = cont[i] * numerator + denominator, newDenominator = numerator,
                    gcd = gcd(newNumerator, newDenominator);
            numerator = newNumerator / gcd;
            denominator = newDenominator / gcd;
        }
        return new int[] {numerator, denominator};
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}