package question0006;

/**
 * 找规律。
 * <p>
 * 时间复杂度和空间复杂度均是O(n * numRows)。
 * <p>
 * 执行用时：45ms，击败42.10%。消耗内存：49.5MB，击败59.26%。
 */
public class Solution1 {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (n <= numRows || numRows == 1 || numRows == 0) {
            return s;
        }
        int quotient = (n - numRows) / (2 * (numRows - 2) + 2);
        int mod = (n - numRows) % (2 * (numRows - 2) + 2);
        int cols = 1;
        if (mod <= numRows - 2) {
            cols += quotient * (numRows - 1) + mod;
        } else {
            cols += (quotient + 1) * (numRows - 1);
        }
        char[][] array = new char[cols][numRows];
        for (int i = 0, k = 0; i < cols && k < n; i++) {
            if (i % (numRows - 1) == 0) {
                for (int j = 0; j < numRows; j++) {
                    array[i][j] = s.charAt(k++);
                    if (k >= n) {
                        break;
                    }
                }
            } else {
                array[i][numRows - i % (numRows - 1) - 1] = s.charAt(k++);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[j][i] != 0) {
                    stringBuilder.append(array[j][i]);
                }
            }
        }
        return stringBuilder.toString();
    }
}
