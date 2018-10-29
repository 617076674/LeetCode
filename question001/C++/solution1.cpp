/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81501389
 */
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    	vector<int> result;
        for(int i = 0; i < nums.size(); i++){
        	for(int j = i + 1; j < nums.size(); j++){
        		if(nums[i] + nums[j] == target){
        			result.push_back(i);
        			result.push_back(j);
        			return result;
				}
			}
		}
    }
};
