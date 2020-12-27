package lcof11_xuan_zhuan_shu_zu_de_zui_xiao_shu_zi;

public class Solution {

    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[right] > numbers[left]) {
                return numbers[left];
            }
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] == numbers[left]) {
                left++;
            } else if (numbers[mid] > numbers[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return numbers[left];
    }

}