package question1006_clumsy_factorial;

public class Solution {

    public int clumsy(int N) {
        int result = 0;
        boolean frist = true;
        for (int i = N; i >= 1; i--) {
            int temp = i;
            if (i - 1 >= 1) {
                temp *= i - 1;
                i--;
            } else {
                return frist ? result + temp : result - temp;
            }
            if (i - 1 >= 1) {
                temp /= i - 1;
                i--;
            } else {
                return frist ? result + temp : result - temp;
            }
            if (frist) {
                result += temp;
                frist = false;
            } else {
                result -= temp;
            }
            if (i - 1 >= 1) {
                result += i - 1;
                i--;
            } else {
                return result;
            }
        }
        return result;
    }

}