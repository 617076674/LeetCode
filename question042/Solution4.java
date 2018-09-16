package question042;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82682179
 */
public class Solution4 {
	
	public int trap(int[] height) {
		int n = height.length;
		int result = 0;
		if(n == 0 || n == 1) {
			return result;
		}
		for (int i = 1; i < n - 1; i++) {
			int leftMax = 0;
			for (int j = 0; j < i; j++) {
				leftMax = Math.max(leftMax, height[j]);
			}
			int rightMax = 0;
			for (int j = i + 1; j < n; j++) {
				rightMax = Math.max(rightMax, height[j]);
			}
			int min = Math.min(leftMax, rightMax);
			if(min > height[i]) {
				result += min - height[i];
			}
		}
		return result;
	}
}
