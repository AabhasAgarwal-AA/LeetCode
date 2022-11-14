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
        
        LinkedList<Employee> que = new LinkedList<>();
        int sum = 0;
        que.addLast(map.get(id));
        while(que.isEmpty() == false){
            Employee rem = que.removeFirst();
            sum += rem.importance;
            
            for(int subID: rem.subordinates){
                que.addLast(map.get(subID));
            }
        }
        
        return sum;
    }
}