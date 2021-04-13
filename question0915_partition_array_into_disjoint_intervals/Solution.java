package question0915_partition_array_into_disjoint_intervals;

public class Solution {

    public int partitionDisjoint(int[] A) {
        int[] max = new int[A.length], min = new int[A.length];
        max[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            max[i] = Math.max(max[i - 1], A[i]);
        }
        min[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], A[i]);
        }
        for (int i = 0; i < A.length - 1; i++) {
            if (max[i] <= min[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

}