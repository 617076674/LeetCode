package question0605_can_place_flowers;

/**
 * 贪心算法。
 *
 * 时间复杂度是O(m)，其中m为flowered数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败91.63%。消耗内存：47.8MB，击败68.53%。
 */
public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            if (count >= n) {
                return true;
            }
            i++;
        }
        return false;
    }

}