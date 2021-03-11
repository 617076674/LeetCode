package question0338_counting_bits;

public class Solution {

    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        } else if (num == 1) {
            return new int[]{0, 1};
        }
        int[] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i < num + 1; i++) {
            result[i] = i % 2 == 0 ? result[i / 2] : (result[i - 1] + 1);
        }
        return result;
    }

}