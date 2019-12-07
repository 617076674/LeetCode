package question0251_flatten_2d_vector;

import java.util.ArrayList;
import java.util.List;

/**
 * 将二维数组转换成一维数组保存即可。
 *
 * 执行用时：15ms，击败95.60%。消耗内存：47.4MB，击败100.00%。
 */
public class Vector2D {
    private List<Integer> list;

    private int index;

    public Vector2D(int[][] v) {
        list = new ArrayList<>();
        if (null != v) {
            for (int i = 0; i < v.length; i++) {
                if (null != v[i]) {
                    for (int j = 0; j < v[i].length; j++) {
                        list.add(v[i][j]);
                    }
                }
            }
        }
    }
    
    public int next() {
        return list.get(index++);
    }
    
    public boolean hasNext() {
        return index < list.size();
    }
}