package question394;

public class Solution2 {
    private int i = 0;
    public String decodeString(String s) {
        return decode(s).toString();
    }
    private StringBuilder decode(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            if (c >= '0' && c <= '9') {
                count *= 10;
                count += c - '0';
            } else if (c == '[') {
                StringBuilder stringBuilder = decode(s);
                for (int j = 0; j < count; j++) {
                    result.append(stringBuilder);
                }
                count = 0;
            } else if (c == ']') {
                return result;
            } else {
                result.append(c);
            }
        }
        return result;
    }
}
