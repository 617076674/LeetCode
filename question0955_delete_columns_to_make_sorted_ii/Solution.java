package question0955_delete_columns_to_make_sorted_ii;

public class Solution {
    public int minDeletionSize(String[] A) {
        int result = 0;
        for (int i = 0; i < A[0].length(); i++) {
            int j = 0;
            for (; j < A.length - 1; j++) {
                if (A[j + 1].charAt(i) < A[j].charAt(i)) {
                    result++;
                    break;
                }
            }
            if (j == A.length - 1) {
                return result;
            }
        }
        return result;
    }
}