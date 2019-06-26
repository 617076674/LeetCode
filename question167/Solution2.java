package question167;

public class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] indexes = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            int index = find(numbers, i + 1, numbers.length - 1, temp);
            if (index != -1) {
                indexes[0] = i + 1;
                indexes[1] = index + 1;
            }
        }
        return indexes;
    }

    private int find(int[] arr, int left, int right, int temp) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == temp) {
            return mid;
        } else if (arr[mid] > temp) {
            return find(arr, left, mid - 1, temp);
        } else {
            return find(arr, mid + 1, right, temp);
        }
    }
}
