package question210.Java;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[][] graph = new int[numCourses][numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]][prerequisites[i][0]] = 1;
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        int num = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            result[index++] = u;
            for(int v = 0; v < numCourses; v++){
                if(graph[u][v] != 0){
                    inDegree[v]--;
                    if(inDegree[v] == 0){
                        queue.add(v);
                    }
                }
            }
            num++;
        }
        if(num != numCourses){
            result = new int[0];
        }
        return result;
    }
}
