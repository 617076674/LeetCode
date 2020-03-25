package question0800_similar_rgb_color;

public class Solution2 {
    public String similarRGB(String color) {
        return "#" + findSimilar(color.substring(1, 3)) + findSimilar(color.substring(3, 5)) + findSimilar(color.substring(5, 7));
    }

    private String findSimilar(String s) {
        String result = "";
        int min = Integer.MAX_VALUE;
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (int i = 0; i < 16; i++) {
            String tmp = "" + chars[i] + chars[i];
            int similarity = calculateSimilarity(s, tmp);
            if (similarity < min) {
                min = similarity;
                result = tmp;
            }
        }
        return result;
    }

    private int calculateSimilarity(String s1, String s2) {
        return (int) Math.pow(stringToNum(s1) - stringToNum(s2), 2);
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