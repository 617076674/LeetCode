package question0299_bulls_and_cows;

/**
 * 哈希表。
 *
 * 时间复杂度是O(n)，其中n为secret的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：37.5MB，击败41.52%。
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, n = secret.length();
        int[] countSecret = new int[10], countGuess = new int[10];
        for (int i = 0; i < n; i++) {
            char c1 = secret.charAt(i), c2 = guess.charAt(i);
            if (c1 == c2) {
                bulls++;
            }
            countSecret[c1 - '0']++;
            countGuess[c2 - '0']++;
        }
        int bullsAndCows = 0;
        for (int i = 0; i < 10; i++) {
            bullsAndCows += Math.min(countSecret[i], countGuess[i]);
        }
        int cows = bullsAndCows - bulls;
        return bulls + "A" + cows + "B";
    }
}
