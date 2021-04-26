package question1837_sum_of_digits_in_base_k;

public class Solution {

    public int sumBase(int n, int k) {
        String s = Integer.toString(n, k);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += s.charAt(i) - '0';
        }
        return result;
    }

}