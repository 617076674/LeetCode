package question1822_sign_of_the_product_of_an_array;

public class Solution {
    
    public int arraySign(int[] nums) {
        int negative = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                negative++;
            }
        }
        return (negative & 1) == 0 ? 1 : -1;
    }
    
}