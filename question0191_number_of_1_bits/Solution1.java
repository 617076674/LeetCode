package question0191_number_of_1_bits;

public class Solution1 {

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (1 == ((n >> i) & 1)) {
                count++;
            }
        }
        return count;
    }

}
