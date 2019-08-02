class Solution {
public:
    vector<int> findOrder(int numCourses, vector<pair<int, int>>& prerequisites) {
        int inDegree[numCourses] = {0};
		vector<int> graph[numCourses];
		for(int i = 0; i < prerequisites.size(); i++){
			graph[prerequisites[i].second].push_back(prerequisites[i].first);
			inDegree[prerequisites[i].first]++;
		}
		queue<int> q;
		for(int i = 0; i < numCourses; i++){
			if(inDegree[i] == 0){
				q.push(i);
			}
		}
		int num = 0;
		vector<int> result;
		while(!q.empty()){
			int u = q.front();
			result.push_back(u);
			q.pop();
			for(int j = 0; j < graph[u].size(); j++){
				int v = graph[u][j];
				inDegree[v]--;
				if(inDegree[v] == 0){
					q.push(v);
				}
			}
			num++;
		}
		if(num != numCourses){
			result.clear();
		}
		return result;
    }
};
