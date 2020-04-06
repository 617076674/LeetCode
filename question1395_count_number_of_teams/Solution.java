package contest.question2;

public class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        if (n < 3) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((rating[k] > rating[j] && rating[j] > rating[i]) || (rating[k] < rating[j] && rating[j] < rating[i])) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}