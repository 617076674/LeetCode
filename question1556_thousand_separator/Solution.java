package question1556_thousand_separator;

public class Solution {

    public String thousandSeparator(int n) {
        return thousandSeparator(String.valueOf(n));
    }

    public String thousandSeparator(String s) {
        if (s.length() < 4) {
            return s;
        }
        return thousandSeparator(s.substring(0, s.length() - 3)) + "." + thousandSeparator(s.substring(s.length() - 3));
    }

}