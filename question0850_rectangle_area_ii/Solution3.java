package question0850_rectangle_area_ii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {

  private static int MOD = 1000000007;

  private static Integer[] xVals;

  private static class SegmentNode {

    private int start, end; // 起始点

    private SegmentNode left, right; // 左右子树

    private int count; // 被查找寻区间覆盖次数

    private long len; // 区间长度

    public SegmentNode(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int getMid() {
      return start + ((end - start) >> 1);
    }

  }

  private static class SegmentTree {

    private void updateLen(SegmentNode node) {
      if (node.count > 0) { // 是一条完整的线段
        node.len = xVals[node.end] - xVals[node.start];
        return;
      }
      node.len = node.left.len + node.right.len;
    }

    public SegmentNode build(int start, int end) {
      SegmentNode node = new SegmentNode(start, end);
      if (start + 1 == end) {
        node.left = new SegmentNode(start, start);
        node.right = new SegmentNode(end, end);
      } else {
        int mid = node.getMid();
        node.left = build(start, mid);
        node.right = build(mid, end);
      }
      return node;
    }

    public void update(SegmentNode node, int x1, int x2, int lineType) {
      if (x2 <= node.start || x1 >= node.end) { // 要更新的线段与当前区间无交集
        return;
      }
      if (x1 <= node.start && x2 >= node.end) { // 要更新的线段完全覆盖当前区间
        node.count += lineType;
        updateLen(node);
        return;
      }
      int mid = node.getMid();
      if (x2 <= mid) { // 只更新左孩子
        update(node.left, x1, x2, lineType); // 更新左孩子
      } else if (x1 > mid) { // 只更新右孩子
        update(node.right, x1, x2, lineType); // 更新右孩子
      } else {
        update(node.left, x1, x2, lineType); // 更新左孩子
        update(node.right, x1, x2, lineType); // 更新右孩子
      }
      updateLen(node); // 更新父节点的值
    }
  }

  public int rectangleArea(int[][] rectangles) {
    // 扫描线按照纵坐标递增排序
    int open = 1, close = -1;
    int[][] lines = new int[rectangles.length * 2][];
    Set<Integer> xValSet = new HashSet<>();
    int index = 0;
    for (int[] rec : rectangles) {
      lines[index++] = new int[] {rec[1], open, rec[0], rec[2]};
      lines[index++] = new int[] {rec[3], close, rec[0], rec[2]};
      xValSet.add(rec[0]);
      xValSet.add(rec[2]);
    }
    Arrays.sort(lines, Comparator.comparingInt(o -> o[0]));
    // 离散化x坐标
    xVals = xValSet.toArray(new Integer[0]);
    Arrays.sort(xVals);
    Map<Integer, Integer> xVal2Index = new HashMap<>();
    for (int i = 0; i < xVals.length; i++) {
      xVal2Index.put(xVals[i], i);
    }
    // 构建线段树
    SegmentTree segmentTree = new SegmentTree();
    SegmentNode root = segmentTree.build(0, xVals.length - 1);
    // 计算面积
    long result = 0, curXSum = 0, curY = lines[0][0];
    for (int[] line : lines) {
      int y = line[0], type = line[1], x1 = line[2], x2 = line[3];
      result += curXSum * (y - curY);
      result %= MOD;
      segmentTree.update(root, xVal2Index.get(x1), xVal2Index.get(x2), type);
      curXSum = root.len;
      curY = y;
    }
    return (int) result;
  }

}