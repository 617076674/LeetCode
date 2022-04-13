package question0258;

public class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            String numStr = String.valueOf(num);
            num = 0;
            for (int i = 0; i < numStr.length(); i++) {
                num += numStr.charAt(i) - '0';
            }
        }
        return num;
    }
}