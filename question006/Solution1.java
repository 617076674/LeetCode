package question006;

/*
 * ½âÎöÇë¼û£ºhttps://blog.csdn.net/qq_41231926/article/details/81901208
 */
public class Solution1 {

	public String convert(String s, int numRows) {
		int n = s.length();
		if(n <= numRows || numRows == 1 || numRows == 0) {
			return s;
		}
		int quotient =  (n - numRows) / (2 * (numRows - 2) + 2);
		int mod = (n - numRows) % (2 * (numRows - 2) + 2);
		int cols = 1;
		if(mod <= numRows - 2) {
			cols += quotient * (numRows - 1) + mod; 
		}else {
			cols += (quotient + 1) * (numRows - 1);
		}
		char[][] array = new char[cols][numRows];
		int k = 0;
		for (int i = 0; i < cols; i++) {
			if(k < n) {
				if(i % (numRows - 1) == 0) {
					for (int j = 0; j < numRows; j++) {
						array[i][j] = s.charAt(k++);
						if(k >= n) {
							break;
						}
					}
				}else {
					array[i][numRows - i % (numRows - 1) - 1] = s.charAt(k++);
				}
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < cols; j++) {
				if(array[j][i] != 0) {
					stringBuilder.append(array[j][i]);
				}
			}
		}
		return stringBuilder.toString();
	}
}
