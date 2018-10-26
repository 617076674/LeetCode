class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    	map<int, int> record;
    	map<int, int>::iterator it;
    	
    	vector<int> result;
    	for(int i = 0; i < nums.size(); i++){
    		it = record.find(target - nums[i]);
    		if(it != record.end()){
    			result.push_back(i);
    			result.push_back(it->second);
    			return result;
			}else{
				record[nums[i]] = i;
			}
		}
    }
};

