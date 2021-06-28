package question1903_largest_odd_number_in_string;

public class Solution {

    public String largestOddNumber(String num) {
        int index = num.length() - 1;
        while (index >= 0 && ((num.charAt(index) - '0') & 1) == 0) {
            index--;
        }
        if (index < 0) {
            return "";
        }
        return num.substring(0, index + 1);
    }

}