bool compare(pair<int, int> pair1, pair<int, int> pair2){
	if(pair1.second >= pair2.second){
		return true;
	}else{
		return false;
	}
}

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    	vector<pair<int, int> > pairs;
    	pair<int, int> tempPair;
    	for(int i = 0; i < nums.size(); i++){
    		tempPair.first = i;
    		tempPair.second = nums[i];
    		pairs.push_back(tempPair);
		}
		sort(pairs.begin(), pairs.end(), compare);
		for(int i = 0; i < pairs.size(); i++){
			cout << pairs[i].second << " ";
		}
		int left = 0;
		int right = pairs.size() - 1;
		vector<int> result;
		while(left < right){
			if(pairs[left].second + pairs[right].second == target){
				result.push_back(pairs[left].first);
				result.push_back(pairs[right].first);
				return result;
			}else if(pairs[left].second + pairs[right].second < target){
				right--;
			}else{
				left++;
			}
		}
    }
};


