class Solution {

    public double dfs (String src, String target, double prod, HashSet<String> visited, HashMap<String,HashMap<String,Double>> map){
        double ret =-1;
        visited.add(src);
        if(map.get(src).containsKey(target)){
            ret=map.get(src).get(target)*prod;
        } else{
            for(String n : map.get(src).keySet()){
                if(!visited.contains(n)){
                    ret= dfs(n,target,prod*map.get(src).get(n),visited, map);
                    if(ret!=-1){
                        break;
                    }
                }
            }
        }
        visited.remove(src);
        return ret;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> map= new HashMap<>();
        for(int i=0; i < equations.size();i++){
            String dividend = equations.get(i).get(0);
            String divisior= equations.get(i).get(1);
            double res= values[i];
            if(!map.containsKey(dividend)){
                map.put(dividend, new HashMap<String,Double>());
            }

            if(!map.containsKey(divisior)){
                map.put(divisior, new HashMap<String,Double>());
            }
            map.get(dividend).put(divisior,res);
            map.get(divisior).put(dividend,1/res);
        }
        double[] newVal= new double[queries.size()];
        for(int i=0; i<queries.size();  i++){
            String dividend = queries.get(i).get(0);
            String divisior= queries.get(i).get(1);

            if(!map.containsKey(dividend) || !map.containsKey(divisior)){
                newVal[i]= -1.0;
            } else if(dividend.equals(divisior)){
                newVal[i]= 1.0;
            } else{
                HashSet<String> visited= new HashSet<>();
                newVal[i]= dfs(dividend,divisior,1,visited,map);
            }
        }

        return newVal;

    }
}