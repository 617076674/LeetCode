package lcof60_nge_tou_zi_de_dian_shu;

import java.util.Arrays;

public class Solution {

    public double[] dicesProbability(int n) {
        if (n == 1) {
            double[] result = new double[6];
            Arrays.fill(result, 1.0 / 6);
            return result;
        }
        double[] tmp = dicesProbability(n - 1);
        double[] result = new double[5 * n + 1];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < tmp.length; j++) {
                result[i + j] += tmp[j] / 6;
            }
        }
        return result;
    }

}