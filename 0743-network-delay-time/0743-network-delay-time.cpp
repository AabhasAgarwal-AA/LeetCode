class Solution {
public:
    int djikstra(vector<vector<pair<int, int>>> & graph, int v, int src){
        vector<bool> vis(v + 1, false);
        vector<int> dis(v + 1, 1e8);
        
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        
        pq.push({0, src});
        while(pq.size() != 0){
            pair<int, int> p = pq.top();
            pq.pop();
            if(vis[p.second])
                continue;
            vis[p.second] = true;
            dis[p.second] = p.first;
            
            for(pair<int, int> e: graph[p.second]){
                if(!vis[e.first])
                    pq.push({p.first + e.second, e.first});
            }
        }
        int maxTime = 0;
        for(int i = 1; i <= v; i++){
            if(dis[i] == 1e8)
                return -1;
            
            maxTime = max(maxTime, dis[i]);
        }
        
        return maxTime;
    }
    
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<vector<pair<int,int>>> graph(n + 1, vector<pair<int, int>>());
        
        for(vector<int>& time: times){
            graph[time[0]].push_back({time[1], time[2]});
        }
        
        return djikstra(graph, n, k);
    }
};