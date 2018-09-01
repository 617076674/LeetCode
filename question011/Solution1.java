package question011;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81407474
 */
public class Solution1 {

	public int maxArea(int[] height) {
		int area = 0;
		for (int i = 0; i < height.length - 1; i++) {
			int tempArea = 0;
			for (int j = i + 1; j < height.length; j++) {
				tempArea = Math.max(tempArea, (j - i) * Math.min(height[i], height[j]));
			}
			area = Math.max(area, tempArea);
		}
		return area;
	}
}
