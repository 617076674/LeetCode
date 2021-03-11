package question1784_check_if_binary_string_has_at_most_one_segment_of_ones;

public class Solution {

    public boolean checkOnesSegment(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                if (c == '1') {
                    count++;
                }
            } else {
                if (c == '1' && s.charAt(i - 1) == '0') {
                    count++;
                }
            }
        }
        return count == 1;
    }

}