package question0042;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82682179
 *
 * 双指针夹逼寻找雨水数。
 *
 * 时间复杂度是O(n)，其中n为height数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败88.60%。消耗内存：38.2MB，击败78.16%。
 */
public class Solution2 {
    public int trap(int[] height) {
        int n = height.length, result = 0;
        if (n == 0 || n == 1) {
            return result;
        }
        int left = 0, right = n - 1;;
        //对于左边界索引left是从数组头到数组尾方向看，第一次出现下降趋势的那个索引的位置
        while (left < n - 1 && height[left + 1] >= height[left]) {
            left++;
        }
        //对于右边界索引right是从数组尾到数组头方向看，第一次出现下降趋势的那个索引的位置
        while (right >= 1 && height[right - 1] >= height[right]) {
            right--;
        }
        while (left < right) {
            int leftHeight = height[left], rightHeight = height[right];
            if (leftHeight <= rightHeight) {
                while (left < right) {  //如果left < right，说明左右边界还没有重合
                    left++;
                    if (height[left] < leftHeight) {    //如果left位置能够存储雨水，则更新结果的值
                        result += leftHeight - height[left];
                    } else {
                        //如果left位置不能存储雨水，说明left位置的高度大于等于leftHeight
                        //这时我们应该进入下一轮循环，更新leftHeight的值
                        break;
                    }
                }
            } else {
                while (left < right) {  //如果left < right，说明左右边界还没有重合
                    right--;
                    if (height[right] < rightHeight) {  //如果right位置能够存储雨水，则更新结果的值
                        result += rightHeight - height[right];
                    } else {
                        //如果right位置不能存储雨水，说明right位置的高度大于等于rightHeight
                        //这时我们应该进入下一轮循环，更新rightHeight的值
                        break;
                    }
                }
            }
        }
        return result;
    }
}
