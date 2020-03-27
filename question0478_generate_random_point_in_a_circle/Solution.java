package question0478_generate_random_point_in_a_circle;

/**
 * 数学分析。
 *
 * 确定圆内一点，需要有相对于圆心的距离r，以及相对于圆心的角度angle。
 *
 * 一开始的想法，我们在[0, radius]中等概率取r，在[0, 2π)中等概率取angle即可实现圆内的随机分布。
 *
 * 事实上，这是不对的。
 *
 * 在[0, 2π)中等概率取angle，相对于把一个圆分成了无数个扇形，点落在每个扇形上的概率均相等。
 *
 * 假设某个扇形的圆心角是theta，那么该扇形的面积是0.5 * theta * radius ^ 2，分布在该扇形区域上的概率是theta / 2π，只要每个扇形的圆心角相等，扇形面积就是相等的，点在扇形中也是等概率的。
 *
 * 在[0, radius]中等概率取r，相当于把一个圆分成了无数个环形，点落在每个环形上的概率均相等。
 *
 * 假设某个环形的内径是r1，外径是r2，那么该环形的面积是π * (r2 ^ 2 - r1 ^ 2)。可见每个环形的面积是不一样的，显然每个环形上的点密度是不一样的。这样做会造成靠近圆心的点分布比较密集，远离圆心的点分布比较稀疏。
 *
 * 那么，如何取r使得点落在圆内任意区域的概率均相等呢？这样做显然会使得落在每个环形上的概率均不同，且环形面积较大的概率高，环形面积较小的概率小。
 *
 * 根据环形面积的计算公式：π * (r2 ^ 2 - r1 ^ 2)，落在该环形面积上的概率应为(r2 ^ 2 - r1 ^ 2) / (radius ^ 2)。
 *
 * 在[0, radius]中如何分布概率密度函数f(x)，可以使得f(x)其在[r1, r2]上的积分值为(r2 ^ 2 - r1 ^ 2) / (radius ^ 2)呢？
 *
 * 取f(x) = 2x / (radius ^ 2)可以满足上述条件，即半径r在[0, radius]上的概率密度函数应为f(x) = 2x / (radius ^ 2)，故只需要在[0, radius ^ 2]范围内等概率取r ^ 2，再开根号即得r值。（求一下导数即可，x ^ 2的导数是2x）
 *
 * 时间复杂度是和空间复杂度均是O(1)。
 *
 * 执行用时：152ms，击败94.44%。消耗内存：50.4MB，击败100.00%。
 */
public class Solution {
    private double radius;

    private double x_center;

    private double y_center;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        double r = Math.sqrt(Math.random()) * radius, angle = Math.random() * 2 * Math.PI;
        return new double[]{r * Math.cos(angle) + x_center, r * Math.sin(angle) + y_center};
    }
}