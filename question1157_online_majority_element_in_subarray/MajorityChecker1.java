package question1157_online_majority_element_in_subarray;

public class MajorityChecker1 {

    private int[] arr;

    public MajorityChecker1(int[] arr) {
        this.arr = arr;
    }
    
    public int query(int left, int right, int threshold) {
        int result = arr[left], count = 1;
        for (int i = left + 1; i <= right; i++) {
            if (result == arr[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    result = arr[i];
                    count = 1;
                }
            }
        }
        int times = 0;
        for (int i = left; i <= right; i++) {
            if (arr[i] == result) {
                times++;
            }
        }
        return times >= threshold ? result : -1;
    }

}