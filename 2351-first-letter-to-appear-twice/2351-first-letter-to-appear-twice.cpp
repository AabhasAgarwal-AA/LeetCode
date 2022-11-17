class Solution {
public:
    char repeatedCharacter(string s) {
        vector<bool> mark(26);
        for(char ch: s){
            if(mark[ch - 'a'])
                return ch;
            mark[ch - 'a'] = true;
        }
        return 'z';
    }
};