package lcof10_i_fei_bo_na_qi_shu_lie;

public class Solution {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int num1 = 0, num2 = 1, num = 1;
        for (int i = 1; i < n; i++) {
            num = (num1 + num2) % 1000000007;
            num1 = num2;
            num2 = num;
        }
        return num;
    }

}