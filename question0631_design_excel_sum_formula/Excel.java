package question0631_design_excel_sum_formula;

import java.util.HashMap;
import java.util.Map;

/**
 * 执行用时：8ms，击败100.00%。消耗内存：35.7MB，
 */
public class Excel {
    private int[][] nums;

    private Map<String, String[]> map;

    public Excel(int H, char W) {
        nums = new int[H][characterToNum(W)];
        map = new HashMap<>();
    }

    public void set(int r, char c, int v) {
        nums[r - 1][characterToNum(c) - 1] = v;
        map.remove(r + "#" + c);
    }

    public int get(int r, char c) {
        String key = r + "#" + c;
        if (map.containsKey(key)) {
            return sum(r, c, map.get(key));
        }
        return nums[r - 1][characterToNum(c) - 1];
    }

    public int sum(int r, char c, String[] strs) {
        int sum = 0;
        for (String s : strs) {
            sum += calculate(s);
        }
        nums[r - 1][characterToNum(c) - 1] = sum;
        map.put(r + "#" + c, strs);
        return sum;
    }

    private int calculate(String str) {
        int index = str.indexOf(":"), sum = 0;
        if (index == -1) {
            sum += get(Integer.parseInt(str.substring(1)), str.charAt(0));
        } else {
            String a = str.substring(0, index), b = str.substring(index + 1);
            int x1 = Integer.parseInt(a.substring(1)), y1 = a.charAt(0) - 'A';
            int x2 = Integer.parseInt(b.substring(1)), y2 = b.charAt(0) - 'A';
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    sum += get(i, (char) (j + 'A'));
                }
            }
        }
        return sum;
    }

    private int characterToNum(char c) {
        return c - 'A' + 1;
    }
}