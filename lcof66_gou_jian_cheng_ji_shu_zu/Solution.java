package lcof66_gou_jian_cheng_ji_shu_zu;

public class Solution {

    public int[] constructArr(int[] a) {
        if (null == a || a.length == 0) {
            return new int[] {};
        }
        int[] tmp1 = new int[a.length];
        tmp1[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            tmp1[i] = a[i] * tmp1[i - 1];
        }
        int[] tmp2 = new int[a.length];
        tmp2[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            tmp2[i] = a[i] * tmp2[i + 1];
        }
        int[] result = new int[a.length];
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                result[i] = tmp2[i + 1];
            } else if (i == result.length - 1) {
                result[i] = tmp1[i - 1];
            } else {
                result[i] = tmp1[i - 1] * tmp2[i + 1];
            }
        }
        return result;
    }

}