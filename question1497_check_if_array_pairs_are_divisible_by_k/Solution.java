package question1497_check_if_array_pairs_are_divisible_by_k;

public class Solution {

    public boolean canArrange(int[] arr, int k) {
        int[] count = new int[k];
        for (int num : arr) {
            int index = num % k;
            if (index < 0) {
                index += k;
            }
            count[index]++;
        }
        if ((count[0] & 1) == 1) {
            return false;
        }
        for (int i = 1; i < k; i++) {
            if (count[i] != count[k - i]) {
                return false;
            }
        }
        return true;
    }

}