package question1496_path_crossing;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {

    private static class Point {

        int x;

        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x &&
                y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    public boolean isPathCrossing(String path) {
        Set<Point> set = new HashSet<>();
        Point cur = new Point(0, 0);
        set.add(cur);
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == 'N') {
                cur = new Point(cur.x - 1, cur.y);
            } else if (c == 'S') {
                cur = new Point(cur.x + 1, cur.y);
            } else if (c == 'E') {
                cur = new Point(cur.x, cur.y + 1);
            } else {
                cur = new Point(cur.x, cur.y - 1);
            }
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
        }
        return false;
    }

}