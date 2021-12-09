package question2086;

public class Solution {

    public int minimumBuckets(String street) {
        for (int i = 0; i < street.length(); i++) {
            if (street.charAt(i) == 'H') {
                if (i == 0) {
                    if (i + 1 >= street.length() || street.charAt(i + 1) == 'H') {
                        return -1;
                    }
                } else if (i == street.length() - 1) {
                    if (street.charAt(i - 1) == 'H') {
                        return -1;
                    }
                } else if (street.charAt(i - 1) == 'H' && street.charAt(i + 1) == 'H') {
                    return -1;
                }
            }
        }
        char[] chars = street.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'H') {
                if (i - 1 >= 0 && chars[i - 1] == 'B') {
                    continue;
                }
                if (i + 1 < chars.length && chars[i + 1] == '.') {
                    chars[i + 1] = 'B';
                } else {
                    chars[i - 1] = 'B';
                }
                result++;
            }
        }
        return result;
    }

}