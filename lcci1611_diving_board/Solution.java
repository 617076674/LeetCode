package lcci1611_diving_board;

public class Solution {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[] {};
        }
        if (shorter == longer) {
            int[] result = new int[1];
            result[0] = k * shorter;
            return result;
        }
        int[] result = new int[k + 1];
        result[0] = shorter * k;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[0] + i * (longer - shorter);
        }
        return result;
    }

}