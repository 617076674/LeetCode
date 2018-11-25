package question126;

import java.util.*;

public class Solution3 {
    private List<List<String>> listList = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private boolean[][] graph;
    private int[] d;
    private final int INF = 1000000000;
    private int[] countInq;
    private boolean[] inq;
    private int size;
    private ArrayList<HashSet<Integer>> pre;
    private List<Integer> tempPath = new ArrayList<>();
    private int start = 0, end = 0;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(wordList);
        hashSet.add(beginWord);
        if(!hashSet.contains(endWord)){
            return listList;
        }
        int index = 0;
        for(String s : hashSet){
            list.add(s);
            if(s.equals(beginWord)){
                start = index;
            }
            if(s.equals(endWord)){
                end = index;
            }
            index++;
        }
        size = list.size();
        graph = new boolean[size][size];
        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                if(hashPath(list.get(i), list.get(j))){
                    graph[i][j] = graph[j][i] = true;
                }
            }
        }
        d = new int[size];
        Arrays.fill(d, INF);
        countInq = new int[size];
        Arrays.fill(countInq, 0);
        inq = new boolean[size];
        pre = new ArrayList<>();
        for(int i = 0; i < size; i++){
            pre.add(new HashSet<>());
        }
        spfa(start);
        dfs(end);
        return listList;
    }

    private boolean hashPath(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
            }
        }
        if(1 == count){
            return true;
        }
        return false;
    }

    private boolean spfa(int s){
        d[s] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        countInq[s]++;
        inq[s] = true;
        while(!queue.isEmpty()){
            int u = queue.poll();
            inq[u] = false;
            for(int v = 0; v < size; v++){
                if(graph[u][v]){
                    if(d[u] + 1 < d[v]) {
                        pre.get(v).clear();
                        pre.get(v).add(u);
                        d[v] = d[u] + 1;
                        if (!inq[v]) {
                            queue.add(v);
                            countInq[v]++;
                            inq[v] = true;
                            if (countInq[v] > size - 1) {
                                return false;
                            }
                        }
                    }else if(d[u] + 1 == d[v]){
                        pre.get(v).add(u);
                        if (!inq[v]) {
                            queue.add(v);
                            countInq[v]++;
                            inq[v] = true;
                            if (countInq[v] > size - 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private void dfs(int nowVisit){
        tempPath.add(nowVisit);
        if(nowVisit == start){
            List<String> path = new ArrayList<>();
            for(int i = tempPath.size() - 1; i >= 0; i--){
                path.add(list.get(tempPath.get(i)));
            }
            listList.add(path);
            tempPath.remove(tempPath.size() - 1);
            return;
        }
        for(Integer integer : pre.get(nowVisit)){
            dfs(integer);
        }
        tempPath.remove(tempPath.size() - 1);
    }
}
