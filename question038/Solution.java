package question038;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82620708
 */
public class Solution {

	public String countAndSay(int n) {
		if(n == 1) {
			return "1";
		}
		String pre = countAndSay(n - 1);
		StringBuilder stringBuilder = new StringBuilder();
		for(int k = 0; k < pre.length();) {
			int index = 1;
			for (int i = k; i < pre.length() - 1; i++) {
				if(pre.charAt(i) == pre.charAt(i + 1)) {
					index++;
				}else {
					break;
				}
			}
			stringBuilder.append(String.valueOf(index));
			stringBuilder.append(pre.charAt(k));
			k += index;
		}

		return stringBuilder.toString();
	}
}
