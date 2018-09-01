package question011;

/*
 * ½âÎöÇë¼û£ºhttps://blog.csdn.net/qq_41231926/article/details/81407474
 */
public class Solution2 {
	
	public int maxArea(int[] height) {
		int n = height.length;
		int i = 0;
		int j = n - 1;
		int area = (n - 1) * Math.min(height[i], height[j]);
		while(i < j) {
			area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
			if(height[i] < height[j]) {
				i++;
			}else {
				j--;
			}
		}
		return area;
    }
}
