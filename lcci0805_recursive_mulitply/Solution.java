package lcci0805_recursive_mulitply;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：36.6MB，击败100.00%。
 */
public class Solution {
    public int multiply(int A, int B) {
        if (B > A) {
            return multiply(B, A);
        }
        if (B == 1) {
            return A;
        }
        int half = multiply(A, B >> 1);
        if ((B & 1) == 0) {
            return half << 1;
        }
        return (half << 1) + A;
    }
}