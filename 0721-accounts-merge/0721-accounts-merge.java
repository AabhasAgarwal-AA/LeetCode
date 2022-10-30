class Solution {
    int[] parent;
    int[] rank;
    void union(int p1, int p2){
        if(rank[p1] < rank[p2]){
            parent[p1] = p2;
        }else if(rank[p1] > rank[p2]){
            parent[p2] = p1;
        }else{
            parent[p1] = p2;
            rank[p2]++;
        }
    }
    int findPar(int u){
        return parent[u] == u ? u : (parent[u] = findPar(parent[u]));
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parent = new int[accounts.size()];
        rank = new int[accounts.size()];
        for(int i = 0; i < accounts.size(); i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        HashMap<String, Integer> mailToId = new HashMap<>();
        
        for(int i = 0; i < accounts.size(); i++){
            List<String> list = accounts.get(i);
            for(int j = 1; j < list.size(); j++){
                String mail = list.get(j);
                
                if(mailToId.containsKey(mail) == false){
                    mailToId.put(mail, i);
                }else{
                    int p1 = findPar(i);
                    int p2 = findPar(mailToId.get(mail));
                    if(p1 != p2)
                        union(p1, p2);
                }
            }
        }
        
        HashMap<Integer, List<String>> idToMail = new HashMap<>();
        for(String key: mailToId.keySet()){
            int par = findPar(mailToId.get(key));
            
            if(idToMail.containsKey(par) == false)
                idToMail.put(par, new ArrayList<>());
            
            idToMail.get(par).add(key);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(int key: idToMail.keySet()){
            List<String> list = idToMail.get(key);
            Collections.sort(list);
            String name = accounts.get(key).get(0);
            list.add(0, name);
            
            res.add(list);
        }
        
        return res;
    }
}