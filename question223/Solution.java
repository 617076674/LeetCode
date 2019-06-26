package question223;

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A > E) {
            return computeArea(E, F, G, H, A, B, C, D);
        }
        int area1 = (D - B) * (C - A), area2 = (H - F) * (G - E);
        if (E >= C) {
            return area1 + area2;
        }
        if (G <= C) {
            if (F >= D) {
                return area1 + area2;
            } else if (F >= B && F < D) {
                if (H >= D) {
                    return area1 - (D - F) * (G - E) + area2;
                } else {
                    return area1;
                }
            } else {
                if (H >= D) {
                    return area1 - (D - B) * (G - E) + area2;
                } else if (H >= B && H < D) {
                    return area1 - (H - B) * (G - E) + area2;
                } else {
                    return area1 + area2;
                }
            }
        } else {
            if (F >= D) {
                return area1 + area2;
            } else if (F >= B && F < D) {
                if (H >= D) {
                    return area1 - (D - F) * (C - E) + area2;
                } else {
                    return area1 - (H - F) * (C - E) + area2;
                }
            } else {
                if (H >= D) {
                    return area1 - (D - B) * (C - E) + area2;
                } else if (H >= B && H < D) {
                    return area1 - (H - B) * (C - E) + area2;
                } else {
                    return area1 + area2;
                }
            }
        }
    }
}
