package contest_3_20.question4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */
public class MKAverage {

    private int m, k;

    private List<Integer> list = new ArrayList<>();

    private long sum;

    private PriorityQueue<Integer> pq1 = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer index1, Integer index2) {
            return list.get(index2) - list.get(index1);
        }
    });

    private long sum1;

    private PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer index1, Integer index2) {
            return list.get(index1) - list.get(index2);
        }
    });

    private long sum2;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }
    
    public void addElement(int num) {
        list.add(num);
        sum += num;
        if (list.size() > m) {
            sum -= list.get(list.size() - m - 1);
        }
        sum1 = 0L;
        pq1.add(list.size() - 1);
        if (pq1.size() >= k) {
            List<Integer> temp = new ArrayList<>();
            while (temp.size() < k) {
                if (list.size() - 1 - pq1.peek() < m) {
                    sum1 += list.get(pq1.peek());
                    temp.add(pq1.poll());
                } else {
                    pq1.poll();
                }
            }
            for (int index : temp) {
                pq1.add(index);
            }
        }
        sum2 = 0L;
        pq2.add(list.size() - 1);
        if (pq2.size() >= k) {
            List<Integer> temp = new ArrayList<>();
            while (temp.size() < k) {
                if (list.size() - 1 - pq2.peek() < m) {
                    sum2 += list.get(pq2.peek());
                    temp.add(pq2.poll());
                } else {
                    pq2.poll();
                }
            }
            for (int index : temp) {
                pq2.add(index);
            }
        }
    }
    
    public int calculateMKAverage() {
        if (list.size() < m) {
            return -1;
        }
        return (int) ((sum - sum1 - sum2) / (m - 2 * k));
    }

    public static void main(String[] args) {
        MKAverage obj = new MKAverage(3, 1);
        obj.addElement(3);        // 当前元素为 [3]
        obj.addElement(1);        // 当前元素为 [3,1]
        System.out.println(obj.calculateMKAverage()); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
        obj.addElement(10);       // 当前元素为 [3,1,10]
        System.out.println(obj.calculateMKAverage()); // 最后 3 个元素为 [3,1,10]
        // 删除最小以及最大的 1 个元素后，容器为 [3]
        // [3] 的平均值等于 3/1 = 3 ，故返回 3
        obj.addElement(5);        // 当前元素为 [3,1,10,5]
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
        System.out.println(obj.calculateMKAverage()); // 最后 3 个元素为 [5,5,5]
        // 删除最小以及最大的 1 个元素后，容器为 [5]
        // [5] 的平均值等于 5/1 = 5 ，故返回 5

    }
}