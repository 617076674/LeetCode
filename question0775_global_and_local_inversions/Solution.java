package question0775_global_and_local_inversions;

public class Solution {
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == i) {
                continue;
            }
            if (i + 1 < A.length && !(A[i] == i + 1 && A[i + 1] == i)) {
                return false;
            }
            i++;
        }
        return true;
    }
}