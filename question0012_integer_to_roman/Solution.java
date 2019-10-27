package question0012_integer_to_roman;

/**
 * 将特殊的数字与罗马字符一一对应起来。
 *
 * 时间复杂度是O(num)。空间复杂度是O(1)。
 *
 * 执行用时：11ms，击败81.11%。消耗内存：38.8MB，击败95.56%。
 */
public class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(strings[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}