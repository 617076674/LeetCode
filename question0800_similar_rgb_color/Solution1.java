package question0800_similar_rgb_color;

public class Solution1 {
    public String similarRGB(String color) {
        int max = Integer.MIN_VALUE;
        String result = "";
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                for (int k = 0; k < 16; k++) {
                    String s = "#" + chars[i] + chars[i] + chars[j] + chars[j] + chars[k] + chars[k];
                    int similarity = calculateSimilarity(s, color);
                    if (similarity >= max) {
                        max = similarity;
                        result = s;
                    }
                }
            }
        }
        return result;
    }

    private int calculateSimilarity(String s1, String s2) {
        int result = 0;
        for (int i = 1; i < 6; i += 2) {
            int num1 = stringToNum(s1.substring(i, i + 2)), num2 = stringToNum(s2.substring(i, i + 2));
            result -= Math.pow(num1 - num2, 2);
        }
        return result;
    }

    private int stringToNum(String s) {
        char c1 = s.charAt(1), c2 = s.charAt(0);
        int result = 0;
        result += charToNum(c2);
        return result * 16 + charToNum(c1);
    }

    private int charToNum(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        return c - 'a' + 10;
    }
}