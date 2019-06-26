package question0012;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82012326
 */
public class Solution2 {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                stringBuilder.append(strings[i]);
                num -= values[i];
            }
        }
        return stringBuilder.toString();
    }
}
