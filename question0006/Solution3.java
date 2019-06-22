package question0006;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81901208
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
