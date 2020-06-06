package question0629_k_inverse_pairs_array;

public class Solution {
    public int kInversePairs(int n, int k) {
        return kInversePairsHelper(n, k);
    }

    private int kInversePairsHelper(int n, int k) {
        int maxK = n * (n - 1) / 2;
        if (k == 0 || k == maxK) {
            return 1;
        }
        if (k == 1 || k == maxK - 1) {
            return n - 1;
        }
        if (k > maxK) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            // [0, n - 1] + i

        }
        return result;
    }

    public static void main(String[] args) {
        for (int n = 3; n <= 5; n++) {
            for (int k = 0; k <= 10; k++) {
                System.out.print(new Solution().kInversePairs(n, k) + " ");
            }
            System.out.println();
        }
        System.out.print(new Solution().kInversePairs(4, 3) + " ");
    }
}