package question056;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82819759
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                return interval1.start - interval2.start;
            }
        });
        for (Interval interval : intervals) {
            int i = 0;
            for (; i < list.size(); i++) {
                if (overlap(interval, list.get(i))) {
                    Interval newInterval = new Interval(Math.min(interval.start, list.get(i).start), Math.max(interval.end, list.get(i).end));
                    list.set(i, newInterval);
                    break;
                }
            }
            if (i >= list.size()) {
                list.add(interval);
            }
        }
        return list;
    }

    private boolean overlap(Interval interval1, Interval interval2) {
        if (interval1.end < interval2.start || interval2.end < interval1.start) {
            return false;
        }
        return true;
    }
}
