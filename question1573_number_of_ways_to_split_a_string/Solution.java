package question1573_number_of_ways_to_split_a_string;

public class Solution {

    private static final int MOD = 1000000007;

    public int numWays(String s) {
        int countOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOne++;
            }
        }
        if (countOne == 0) {
            long len = s.length();
            return (int) ((len - 1) * (len - 2) / 2 % MOD);
        }
        if (countOne % 3 != 0) {
            return 0;
        }
        int gap1 = countOne / 3, gap2 = gap1 * 2, tempCountOne = 0;
        long temp1 = 0, temp2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                tempCountOne++;
            }
            if (tempCountOne == gap1) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == '1') {
                        temp1 = j - i;
                        i = j - 1;
                        break;
                    }
                }
            } else if (tempCountOne == gap2) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == '1') {
                        temp2 = j - i;
                        i = j - 1;
                        break;
                    }
                }
            }
        }
        return (int) (temp1 * temp2 % MOD);
    }

}