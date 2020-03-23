package question1243_array_transformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> transformArray(int[] arr) {
        while (true) {
            int[] tmp = Arrays.copyOf(arr, arr.length);
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    tmp[i]--;
                } else if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    tmp[i]++;
                }
            }
            if (Arrays.equals(tmp, arr)) {
                List<Integer> list = new ArrayList<>();
                for (int num : tmp) {
                    list.add(num);
                }
                return list;
            }
            arr = tmp;
        }
    }
}