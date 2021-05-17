package question1529_bulb_switcher_iv;

public class Solution {

    public int minFlips(String target) {
        int i = 0;
        while (i < target.length() && target.charAt(i) == '0') {
            i++;
        }
        if (i == target.length()) {
            return 0;
        }
        int result = 0;
        while (i < target.length()) {
            if (i + 1 < target.length() && target.charAt(i) != target.charAt(i + 1)) {
                result++;
            }
            i++;
        }
        return result + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFlips("10111"));
        System.out.println(solution.minFlips("101"));
        System.out.println(solution.minFlips("00000"));
        System.out.println(solution.minFlips("001011101"));
        System.out.println(solution.minFlips("00111"));
    }

}