package question0488_zuma_game;

public class Solution {
    private int result = Integer.MAX_VALUE;

    private int[] map = new int[26];

    public int findMinStep(String board, String hand) {
        for (int i = 0; i < hand.length(); i++) {
            map[hand.charAt(i) - 'A']++;
        }
        dfs(board, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void dfs(String board, int step) {
        if (board.length() == 0) {
            result = Math.min(result, step);
            return;
        }
        for (int i = 0; i < board.length(); i++) {
            char c = board.charAt(i);
            int j = i + 1;
            while (j < board.length() && board.charAt(j) == c) {
                j++;
            }
            int need = Math.max(0, 3 - j + i);
            if (map[c - 'A'] >= need) {
                map[c - 'A'] -= need;
                dfs(board.substring(0, i) + board.substring(j), step + need);
                map[c - 'A'] += need;
            }
        }
    }
}