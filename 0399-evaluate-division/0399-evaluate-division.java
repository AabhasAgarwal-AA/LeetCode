class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parent = new HashMap<>();
        mult = new HashMap<>();
        
        for(List<String> equation: equations){
            addToDSU(equation.get(0));
            addToDSU(equation.get(1));
        }
        
        int i = 0;
        for(List<String> equation: equations){
            String lead0 = find(equation.get(0));
            String lead1 = find(equation.get(1));
            
            Double mult0 = mult.get(equation.get(0));
            Double mult1 = mult.get(equation.get(1));
            
            mult.put(lead0, mult1 * values[i] / mult0);
            parent.put(lead0, lead1);
            i++;
        }
        
        double[] res = new double[queries.size()];
        i = 0;
        
        for(List<String> query: queries){
            String query0 = query.get(0);
            String query1 = query.get(1);
            
            if(parent.containsKey(query0) == false || parent.containsKey(query1) == false){
                res[i] = -1;
                i++;
                continue;
            }
            
            String lead0 = find(query0);
            String lead1 = find(query1);
            
            if(lead0.equals(lead1) == false){
                res[i] = -1;
                i++;
                continue;
            }
            
            Double mult0 = mult.get(query0);
            Double mult1 = mult.get(query1);
            
            res[i] = mult0 / mult1;
            i++;
        }
        
        return res;
    }
    
    HashMap<String, String> parent;
    HashMap<String, Double> mult;
    
    void addToDSU(String x){
        if(parent.containsKey(x) == false){
            parent.put(x, x);
            mult.put(x, 1.0);
        }
    }
    
    String find(String x){
        if(parent.get(x).equals(x)){
            return parent.get(x);
        }else{
            String currPar = parent.get(x);
            String findPar = find(currPar);
            
            parent.put(x, findPar);
            mult.put(x, mult.get(currPar) * mult.get(x));
            
            return findPar;
        }
    }   
}
