package lcof65_bu_yong_jia_jian_cheng_chu_zuo_jia_fa;

public class Solution {

    public int add(int a, int b) {
        while (true) {
            int tmp1 = a ^ b;
            int tmp2 = (a & b) << 1;
            if (tmp2 == 0) {
                return tmp1;
            }
            a = tmp1;
            b = tmp2;
        }
    }

}