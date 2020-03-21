package question0488_zuma_game;

/**
 * 深度优先搜索。
 *
 * 执行用时：8ms，击败35.87%。消耗内存：37.8MB，击败29.17%。
 */
public class Solution {
    private int result = Integer.MAX_VALUE;

    private int[] map = new int[26];

    private char[] colors = {'R', 'Y', 'B', 'G', 'W'};

    public int findMinStep(String board, String hand) {
        for (int i = 0; i < hand.length(); i++) {
            map[hand.charAt(i) - 'A']++;
        }
        dfs(new StringBuilder(board), 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void dfs(StringBuilder board, int step) {
        if (step >= result) {
            return;
        }
        if (board.length() == 0) {
            result = Math.min(step, result);
            return;
        }
        for (int i = 0; i < board.length(); i++) {
            char c = board.charAt(i);
            int j = i;
            while (j + 1 < board.length() && board.charAt(j + 1) == c) {
                j++;
            }
            if (j == i && map[c - 'A'] >= 2) {  //只有单个球
                StringBuilder tmp = new StringBuilder(board);
                tmp.insert(i, c + "" + c);
                map[c - 'A'] -= 2;
                dfs(eliminate(tmp), step + 2);
                map[c - 'A'] += 2;
            } else if (j == i + 1) {    //存在两个颜色相同且相邻的球
                if (map[c - 'A'] >= 1) {
                    StringBuilder tmp = new StringBuilder(board);
                    tmp.insert(i, c);
                    map[c - 'A']--;
                    dfs(eliminate(tmp), step + 1);
                    map[c - 'A']++;
                }
                for (char color : colors) {
                    if (color == c) {
                        continue;
                    }
                    if (map[color - 'A'] >= 1) {
                        StringBuilder tmp = new StringBuilder(board);
                        tmp.insert(i + 1, color);   //尝试往这两个颜色相同且相邻的球中间插入一个颜色不同的球
                        map[color - 'A']--;
                        dfs(eliminate(tmp), step + 1);
                        map[color - 'A']++;
                    }
                }
            }
        }
    }

    private StringBuilder eliminate(StringBuilder sb) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < sb.length(); i++) {
                int j = i + 1;
                while (j < sb.length() && sb.charAt(j) == sb.charAt(i)) {
                    j++;
                }
                if (j - i >= 3) {
                    sb.delete(i, j);
                    flag = true;
                }
            }
        }
        return sb;
    }
}