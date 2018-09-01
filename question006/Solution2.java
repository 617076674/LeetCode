package question006;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81901208
 */
public class Solution2 {
	
	public String convert(String s, int numRows) {
		int n = s.length();
		if(n <= numRows || numRows == 1 || numRows == 0) {
			return s;
		}
		StringBuilder[] stringBuilders = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			stringBuilders[i] = new StringBuilder();
		}
		int row = 0;
		int zigZag = 1;
		for (int i = 0; i < n; i++) {
			stringBuilders[row].append(s.charAt(i));
			row += zigZag;
			if(row == numRows - 1) {
				zigZag = -1;
			}
			if(row == 0) {
				zigZag = 1;
			}
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < stringBuilders.length; i++) {
			result.append(stringBuilders[i]);
		}
		return result.toString();
	}
}
