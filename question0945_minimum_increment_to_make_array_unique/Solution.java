package question0945_minimum_increment_to_make_array_unique;

import java.util.Arrays;

public class Solution {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int result = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int tmp = A[i - 1] - A[i] + 1;
                A[i] += tmp;
                result += tmp;
            }
        }
        return result;
    }
}