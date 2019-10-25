package question0013_roman_to_integer;

/**
 * 繁琐而简单。
 *
 * 时间复杂度是O(n)，其中n为输入字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：8ms，击败96.38%。消耗内存：38.7MB，击败87.05%。
 */
public class Solution {
    public int romanToInt(String s) {
        int n = s.length(), result = 0;
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            if (c1 == 'I') {
                if (i + 1 < n && s.charAt(i + 1) == 'V') {
                    result += 4;
                    i++;
                } else if (i + 1 < n && s.charAt(i + 1) == 'X') {
                    result += 9;
                    i++;
                } else {
                    result += 1;
                }
            } else if (c1 == 'V') {
                result += 5;
            } else if (c1 == 'X') {
                if (i + 1 < n && s.charAt(i + 1) == 'L') {
                    result += 40;
                    i++;
                } else if (i + 1 < n && s.charAt(i + 1) == 'C') {
                    result += 90;
                    i++;
                } else {
                    result += 10;
                }
            } else if (c1 == 'L') {
                result += 50;
            } else if (c1 == 'C') {
                if (i + 1 < n && s.charAt(i + 1) == 'D') {
                    result += 400;
                    i++;
                } else if (i + 1 < n && s.charAt(i + 1) == 'M') {
                    result += 900;
                    i++;
                } else {
                    result += 100;
                }
            } else if (c1 == 'D') {
                result += 500;
            } else if (c1 == 'M') {
                result += 1000;
            }
        }
        return result;
    }
}
