package question0191_number_of_1_bits;

public class Solution2 {

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n &= n - 1; // n & (n - 1) 的运算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果
            result++;
        }
        return result;
    }

}