package question0926_flip_string_to_monotone_increasing;

public class Solution {

    public int minFlipsMonoIncr(String S) {
        int[] count0 = new int[S.length() + 1]; // count0[i] 表示 [0, i - 1] 范围内 0 的个数
        for (int i = 1; i < count0.length; i++) {
            count0[i] = count0[i - 1] + (S.charAt(i - 1) == '0' ? 1 : 0);
        }
        // [0, i] 为 0，[i + 1, S.length - 1] 为 1
        int result = S.length();
        for (int i = -1; i < S.length(); i++) {
            // [0, i] 范围内 0 的数量
            int num1 = count0[i + 1];
            // [i + 1, S.length - 1] 范围内 0 的数量
            int num2 = count0[S.length()] - count0[i + 1];
            result = Math.min(result, i + 1 - num1 + num2);
        }
        return result;
    }

}