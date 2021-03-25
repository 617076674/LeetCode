package question0779_k_th_symbol_in_grammark_th_symbol_in_grammar;

public class Solution {

    public int kthGrammar(int N, int K) {
        if (N == 1 && K == 1) {
            return 0;
        }
        int half = (int) Math.pow(2, N - 2);
        if (K <= half) {
            return kthGrammar(N - 1, K);
        }
        return 1 - kthGrammar(N - 1, K - half);
    }

}