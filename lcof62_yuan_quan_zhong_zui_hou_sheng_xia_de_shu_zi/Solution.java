package lcof62_yuan_quan_zhong_zui_hou_sheng_xia_de_shu_zi;

public class Solution {

    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (lastRemaining(n - 1, m) + m) % n;
    }

}