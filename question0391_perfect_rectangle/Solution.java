package question0391_perfect_rectangle;

import java.util.HashSet;
import java.util.Set;

/**
 * 如果是完美矩形，那么一定满足2点：
 * （1）最左下、最左上、最右下、最右上的四个点只出现一次，其他点成对出现。
 * （2）四个点围成的矩形面积 = 小矩形的面积之和。
 */
public class Solution {

  public boolean isRectangleCover(int[][] rectangles) {
    int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE, top = Integer.MIN_VALUE, bottom =
        Integer.MAX_VALUE, n = rectangles.length;
    Set<String> set = new HashSet<>();
    int sumArea = 0;
    for (int[] rectangle : rectangles) {
      //获取四个点的坐标
      left = Math.min(left, rectangle[0]);
      bottom = Math.min(bottom, rectangle[1]);
      right = Math.max(right, rectangle[2]);
      top = Math.max(top, rectangle[3]);
      //计算总小矩形的面积
      sumArea += (rectangle[3] - rectangle[1]) * (rectangle[2] - rectangle[0]);
      //分别记录小矩形的坐标
      String lt = rectangle[0] + " " + rectangle[3];
      String lb = rectangle[0] + " " + rectangle[1];
      String rt = rectangle[2] + " " + rectangle[3];
      String rb = rectangle[2] + " " + rectangle[1];
      //如果有就移除 没有就加入
      if (!set.contains(lt)) {
        set.add(lt);
      } else {
        set.remove(lt);
      }
      if (!set.contains(lb)) {
        set.add(lb);
      } else {
        set.remove(lb);
      }
      if (!set.contains(rt)) {
        set.add(rt);
      } else {
        set.remove(rt);
      }
      if (!set.contains(rb)) {
        set.add(rb);
      } else {
        set.remove(rb);
      }
    }
    //最后只剩4个大矩形坐标且面积相等即为完美矩形
    if (set.size() == 4 && set.contains(left + " " + top) && set.contains(left + " " + bottom)
        && set.contains(right + " " + bottom) && set.contains(right + " " + top)) {
      return sumArea == (right - left) * (top - bottom);
    }
    return false;
  }

}