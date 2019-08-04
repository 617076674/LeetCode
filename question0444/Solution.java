package question0444;

import java.util.*;

/**
 * @author qianyihui
 * @date 2019-08-02
 */
public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int[] inDegree = new int[10001];   //记录入度
        Map<Integer, List<Integer>> graph = new HashMap<>();    //用邻接表表示图
        //构建图
        int max = Integer.MIN_VALUE;
        for (List<Integer> list : seqs) {
            for (int i = 0; i < list.size(); i++) {
                max = Math.max(max, list.get(i));
                for (int j = i + 1; j < list.size(); j++) {
                    if (graph.containsKey(list.get(i))) {
                        graph.get(list.get(i)).add(list.get(j));
                    } else {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(list.get(j));
                        graph.put(list.get(i), tmp);
                    }
                    inDegree[list.get(j)]++;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        //入度为0的节点入队
        for (int i = 0; i < max + 1; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        if (queue.size() != 1) {
            return false;
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            result.add(tmp);
            for (Integer num : graph.keySet()) {
                if (num == tmp) {
                    List<Integer> list = graph.get(num);
                    for (Integer listNum : list) {
                        if (inDegree[listNum] == 1) {
                            queue.add(listNum);
                        }
                        inDegree[listNum]--;
                    }
                }
            }
            if (queue.size() != 0 && queue.size() != 1) {
                return false;
            }
        }
        if (result.size() != org.length) {
            return false;
        }
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) != org[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] org = {1, 2, 3};
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        System.out.println(new Solution().sequenceReconstruction(org, list));
    }
}
