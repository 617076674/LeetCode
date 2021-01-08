package lcci1615_master_mind;

public class Solution {

    public int[] masterMind(String solution, String guess) {
        int[] count1 = getCount(solution), count2 = getCount(guess);
        int[] result = new int[2];
        for (int i = 0; i < 26; i++) {
            result[1] += Math.min(count1[i], count2[i]);
        }
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                result[0]++;
            }
        }
        result[1] -= result[0];
        return result;
    }

    private static int[] getCount(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
        }
        return count;
    }

}