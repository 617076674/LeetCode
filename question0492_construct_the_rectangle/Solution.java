package question0492_construct_the_rectangle;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(area ^ 0.5)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.73%。消耗内存：33.6MB，击败77.91%。
 */
public class Solution {

    public int[] constructRectangle(int area) {
        int mid = (int) Math.sqrt(area);
        if (mid * mid == area) {
            return new int[] {mid, mid};
        }
        int index = mid;
        while (index >= 1) {
            if (area % index == 0) {
                return new int[] {area / index, index};
            }
            index--;
        }
        return null;
    }

}