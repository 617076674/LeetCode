package contest.kmp;

public class KMP {
    private int[][] dp;

    public KMP(String pattern) {
        dp = new int[pattern.length()][256];
        dp[0][pattern.charAt(0)] = 1;
        int X = 0;
        for (int i = 1; i < pattern.length(); i++) {
            for (int c = 0; c < 256; c++) {
                dp[i][c] = dp[X][c];
            }
            dp[i][pattern.charAt(i)] = i + 1;
            X = dp[X][pattern.charAt(i)];
        }
    }

    public int search(String text) {
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            j = dp[j][text.charAt(i)];
            if (j == dp.length) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP("ABABC");
        System.out.println(kmp.search("AABABC"));
    }
}