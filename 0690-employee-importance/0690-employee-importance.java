/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        
        return dfs(map, id);
    }
    private int dfs(HashMap<Integer, Employee> map, int id){
        int sum = map.get(id).importance;
        
        for(int subID: map.get(id).subordinates){
            sum += dfs(map, subID);
        }
        return sum;
    }
}