package question1337_the_k_weakest_rows_in_a_matrix;

import java.util.PriorityQueue;

public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int m;
        if (null == mat || (m = mat.length) == 0) {
            return null;
        }
        int n;
        if (null == mat[0] || (n = mat[0].length) == 0) {
            return null;
        }
        return null;
    }
}