package lcci1603_intersection;

/**
 * https://leetcode-cn.com/problems/intersection-lcci/
 *
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：38.5MB，击败100.00%。
 */
public class Solution {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        if (start1[0] == end1[0]) { // 第一条线段与y轴平行
            if (start2[0] == end2[0]) { // 第二条线段也与y轴平行
                if (start1[0] == start2[0]) {   // 第一条线段与第二条线段的x轴坐标相等
                    int y1min = Math.min(start1[1], end1[1]), y1max = Math.max(start1[1], end1[1]); // 第1条线段的y轴范围为[y1min, y1max]
                    int y2min = Math.min(start2[1], end2[1]), y2max = Math.max(start2[1], end2[1]); // 第2条线段的y轴范围为[y2min, y2max]
                    if (y2min > y1max || y1min > y2max) {
                        return new double[]{}; //没有交点
                    }
                    return new double[] {start1[0], Math.max(y1min, y2min)};
                }
                return new double[]{}; //没有交点
            }
            // 第二条线段不与y轴平行
            int x2min = Math.min(start2[0], end2[0]), x2max = Math.max(start2[0], end2[0]);
            if (start1[0] >= x2min && start1[0] <= x2max) {
                int[] line2 = determineALineByTwoPoints(start2, end2);
                return new double[] {start1[0], start1[0] * line2[0] * 1.0 / line2[1] + line2[2] * 1.0 / line2[3]};
            }
            return new double[]{}; //没有交点
        } else if (start2[0] == end2[0]) {
            return intersection(start2, end2, start1, end1);
        }
        int x1min = Math.min(start1[0], end1[0]), x1max = Math.max(start1[0], end1[0]);
        int x2min = Math.min(start2[0], end2[0]), x2max = Math.max(start2[0], end2[0]);
        if (x2min > x1max || x1min > x2max) {
            return new double[]{}; //没有交点
        }
        int y1min = Math.min(start1[1], end1[1]), y1max = Math.max(start1[1], end1[1]);
        int y2min = Math.min(start2[1], end2[1]), y2max = Math.max(start2[1], end2[1]);
        int[] line1 = determineALineByTwoPoints(start1, end1), line2 = determineALineByTwoPoints(start2, end2);
        if (line1[0] == line2[0] && line1[1] == line2[1]) { // 线段平行
            if (line1[2] == line2[2] && line1[3] == line2[3]) { // 线段重合
                return new double[]{Math.max(x1min, x2min), Math.max(y1min, y2min)};
            }
            return new double[]{}; //没有交点
        }
        // 线段不平行，必然有交点
        double x = (line2[2] * 1.0 / line2[3] - line1[2] * 1.0 / line1[3]) / (line1[0] * 1.0 / line1[1] - line2[0] * 1.0 / line2[1]);
        double y = (line1[0] * 1.0 * line2[2] / (line2[3] * line1[1]) - line2[0] * 1.0 * line1[2] / (line2[1] * line1[3])) / (line1[0] * 1.0 / line1[1] - line2[0] * 1.0 / line2[1]);
        if (x >= x1min && x <= x1max && x >= x2min && x <= x2max) { //交点在线段一和线段二上
            return new double[] {x, y};
        }
        return new double[]{}; //没有交点
    }

    private int[] determineALineByTwoPoints(int[] start, int[] end) {
        int numeratorOfK = start[1] - end[1], denominatorOfK = start[0] - end[0],
                gcdOfK = gcd(numeratorOfK, denominatorOfK), numeratorOfB = start[0] * end[1] - end[0] * start[1],
                denominatorOfB = start[0] - end[0], gcdOfB = gcd(numeratorOfB, denominatorOfB);
        return new int[] {numeratorOfK / gcdOfK, denominatorOfK / gcdOfK, numeratorOfB / gcdOfB, denominatorOfB / gcdOfB};
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}