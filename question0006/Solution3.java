package question0006;

/**
 * 找规律填充数字。
 *
 * 时间复杂度是O(n * numRows)，其中n为字符串s的长度。空间复杂度是O(numRows * n)。
 *
 * 执行用时：224ms，击败5.02%。消耗内存：48.4MB，击败64.23%。
 */
public class Solution3 {
	public String convert(String s, int numRows) {
		int n = s.length();
		if(n <= numRows || numRows == 1 || numRows == 0) {
			return s;
		}
		StringBuilder[] stringBuilders = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			stringBuilders[i] = new StringBuilder();
		}
		int interval = 2 * numRows - 2;
		int row = 0;
		for (int i = 0; i < n; i += interval) {
			stringBuilders[row].append(s.charAt(i));
		}
		for (row = 1; row < numRows; row++) {
			for (int i = row; i < n; i++) {
				if(row != numRows - 1) {
					if((i - row + 2 * row) % interval == 0) {
						stringBuilders[row].append(s.charAt(i));
					}
					if((i - row) % interval == 0) {
						stringBuilders[row].append(s.charAt(i));
					}
				}else {
					if((i - row) % interval == 0) {
						stringBuilders[row].append(s.charAt(i));
					}
				}
			}
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < stringBuilders.length; i++) {
			result.append(stringBuilders[i]);
		}
		return result.toString();
	}
}
