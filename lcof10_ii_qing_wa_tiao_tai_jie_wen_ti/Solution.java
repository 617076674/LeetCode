package lcof10_ii_qing_wa_tiao_tai_jie_wen_ti;

public class Solution {
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int num1 = 1, num2 = 1, num = 1;
        for (int i = 1; i < n; i++) {
            num = (num1 + num2) % 1000000007;
            num1 = num2;
            num2 = num;
        }
        return num;
    }
}