package question0469_convex_polygon;

import java.util.List;

/**
 * 凸多边形的判断方法：顶点凹凸性法
 *
 * 假设当前连续的三个顶点分别是p1、p2、p3，计算向量p1p2和p2p3的叉乘，得到的结果如果大于0，则表示p3点在向量p1p2的左侧，
 * 多边形的顶点是逆时针序列。然后再依次计算下一个顶点前后所组成向量的叉乘，如果在计算时，出现负值，则此多边形时凹多边形，
 * 如果所有顶点计算完毕，其结果都是大于0，则多边形时凸多边形。
 *
 * 时间复杂度是O(n)，其中n为points的长度。空间复杂度是O(1)。
 *
 * 执行用时：28ms，击败64.10%。消耗内存：44.4MB，击败66.67%。
 */
public class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        long cur, pre = 0;
        for (int i = 0; i < n; i++) {
            cur = crossProduct(points.get((i + 1) % n).get(0) - points.get(i).get(0),
                    points.get((i + 1) % n).get(1) - points.get(i).get(1),
                    points.get((i + 2) % n).get(0) - points.get(i).get(0),
                    points.get((i + 2) % n).get(1) - points.get(i).get(1));
            if (cur != 0) {
                if (cur * pre < 0) {
                    return false;
                }
                pre = cur;
            }
        }
        return true;
    }

    private long crossProduct(long x1, long y1, long x2, long y2) {
        return x1 * y2 - x2 * y1;
    }
}