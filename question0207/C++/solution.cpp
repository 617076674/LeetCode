class Solution {
	public:
		bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
			int inDegree[numCourses] = {0};	//记录每个节点的入度
			vector<int> graph[numCourses];
			for(int i = 0; i < prerequisites.size(); i++) {
				graph[prerequisites[i].second].push_back(prerequisites[i].first);
				inDegree[prerequisites[i].first]++;
			}
			int num = 0;	//记录加入拓扑序列的顶点数
			queue<int> q;
			for(int i = 0; i < numCourses; i++) {
				if(inDegree[i] == 0) {
					q.push(i);	//将所有入度为0的顶点入队
				}
			}
			while(!q.empty()) {
				int u = q.front();	//取队首顶点u
				q.pop();
				for(int i = 0; i < graph[u].size(); i++) {
					int v = graph[u][i];	//u的后继节点v
					inDegree[v]--;	//顶点v的入度减1
					if(inDegree[v] == 0) {
						q.push(v);	//顶点v的入度减为0则入队
					}
				}
//				graph[u].clear(); 
				num++;
			}
			if(num == numCourses){
				return true;	//加入拓扑序列的顶点数为numCourses，说明拓扑排序成功 
			}
			return false;	//加入拓扑序列的顶点数小于numCourses，说明拓扑排序失败 
		}
};
