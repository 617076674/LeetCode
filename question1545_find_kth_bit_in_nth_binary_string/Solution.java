package question1545_find_kth_bit_in_nth_binary_string;

public class Solution {

    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int mid = (int) Math.pow(2, n - 1);
        if (k == mid) {
            return '1';
        }
        if (k < mid) {
            return findKthBit(n - 1, k);
        }
        if (findKthBit(n - 1, mid * 2 - k) == '0') {
            return '1';
        }
        return '0';
    }

}