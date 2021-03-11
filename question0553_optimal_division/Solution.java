package question0553_optimal_division;

public class Solution {

    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                sb.append("/");
                if (nums.length > 2) {
                    sb.append("(");
                }
            }
            sb.append(nums[i]);
            if (i != nums.length - 1) {
                sb.append("/");
            } else if (nums.length > 2){
                sb.append(")");
            }
        }
        return sb.toString();
    }

}