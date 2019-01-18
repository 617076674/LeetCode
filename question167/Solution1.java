package question167;

public class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        int[] indexes = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while(i < j) {
            if(numbers[i] + numbers[j] == target) {
                indexes[0] = i + 1;
                indexes[1] = j + 1;
                break;
            }else if(numbers[i] + numbers[j] < target) {
                i++;
            }else {
                j--;
            }
        }
        return indexes;
    }
}
