class Solution {
public:
    int repeatedNTimes(vector<int>& nums) {
        unordered_set<int> count;
        for(int val: nums){
            if(count.count(val))
                return val;
            count.insert(val);
        }
        return -1;
    }
};