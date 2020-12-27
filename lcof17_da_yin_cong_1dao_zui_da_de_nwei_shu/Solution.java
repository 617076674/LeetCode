package lcof17_da_yin_cong_1dao_zui_da_de_nwei_shu;

public class Solution {
    public int[] printNumbers(int n) {
        int max = (int) (Math.pow(10, n) - 1);
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}