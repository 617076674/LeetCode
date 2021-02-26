package question1539_kth_missing_positive_number;

public class Solution {

    public int findKthPositive(int[] arr, int k) {
        int expected = 1;
        for (int i = 0; i < arr.length; ) {
            if (arr[i] == expected) {
                expected++;
                i++;
            } else {
                k--;
                if (k == 0) {
                    return expected;
                }
                expected++;
            }
        }
        return arr[arr.length - 1] + k;
    }

}