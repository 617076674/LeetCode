package question1791_find_center_of_star_graph;

public class Solution {
    
    public int findCenter(int[][] edges) {
        int[] degree = new int[100001];
        int result = 1;
        for (int[] edge : edges) {
            degree[edge[0]]++;
            if (degree[edge[0]] > degree[result]) {
                result = edge[0];
            }
            degree[edge[1]]++;
            if (degree[edge[1]] > degree[result]) {
                result = edge[1];
            }
        }
        return result;
    }
    
}