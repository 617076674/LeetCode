package question057;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82819933
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<>();
        int start = -1;
        int end = -1;
        for (int i = 0; i < intervals.size(); i++) {
            if (newInterval.start >= intervals.get(i).start && newInterval.start <= intervals.get(i).end) {
                start = i;
            }
            if (newInterval.start > intervals.get(i).end) {
                if (i + 1 == intervals.size()) {
                    start = intervals.size();
                } else if (newInterval.start < intervals.get(i + 1).start) {
                    start = i + 1;
                }
            }
            if (newInterval.end >= intervals.get(i).start && newInterval.end <= intervals.get(i).end) {
                end = i;
            }
            if (newInterval.end > intervals.get(i).end) {
                if (i + 1 == intervals.size()) {
                    end = intervals.size();
                } else if (newInterval.end < intervals.get(i + 1).start) {
                    end = i;
                }
            }
        }
        Interval insertInterval = new Interval();
        if (start == intervals.size() || end == -1) {
            insertInterval.start = newInterval.start;
            insertInterval.end = newInterval.end;
        } else {
            if (start == -1) {
                insertInterval.start = newInterval.start;
            } else {
                insertInterval.start = Math.min(newInterval.start, intervals.get(start).start);
            }
            if (end == intervals.size()) {
                insertInterval.end = newInterval.end;
            } else {
                insertInterval.end = Math.max(newInterval.end, intervals.get(end).end);
            }
        }
        for (int i = 0; i < start; i++) {
            list.add(intervals.get(i));
        }
        list.add(insertInterval);
        for (int i = end + 1; i < intervals.size(); i++) {
            list.add(intervals.get(i));
        }
        return list;
    }
}
