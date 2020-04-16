package lcci0506_convert_integer;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：36.4MB，击败100.00%。
 */
public class Solution {
    public int convertInteger(int A, int B) {
        int num = A ^ B, result = 0;
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) == 1) {
                result++;
            }
        }
        return result;
    }
}