package question1224_maximum_equal_frequency;

public class Solution {

  public int maxEqualFreq(int[] nums) {
    int[] num2Freq = new int[100001], freq2Freq = new int[100001];
    int result = 1, species = 0, maxFreq = 0;
    for (int i = 0; i < nums.length; i++) {
      if (num2Freq[nums[i]] == 0) {
        species++;
      }
      num2Freq[nums[i]]++;
      maxFreq = Math.max(maxFreq, num2Freq[nums[i]]);
      freq2Freq[num2Freq[nums[i]]]++;
      freq2Freq[num2Freq[nums[i]] - 1]--;
      if (species == (i + 1) // 1, 2, 3, 4, 5, 6
          || species == 1 // 1, 1, 1, 1, 1, 1
          || (freq2Freq[maxFreq] == species - 1 && freq2Freq[1] == 1) // 1, 1, 2, 2, 3, 3, 4, 4, 5
          || freq2Freq[maxFreq] == 1 && freq2Freq[maxFreq - 1] == species - 1) { // 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5
        result = i + 1;
      }
    }
    return result;
  }

}