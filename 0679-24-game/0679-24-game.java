class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> res = new ArrayList<>();
        for(int c:cards) res.add((double)c);
        return helper(res);
    }
    private boolean helper(List<Double> res){
        if(res.size()==1){
            return Math.abs(res.get(0)-24.0) < 0.00001;
        }
        int n= res.size();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                double a = res.get(i);
                double b = res.get(j);
                List<Double> temp = new ArrayList<>();
                for(int k=0;k<n;k++){
                    if(k!=i && k!=j) temp.add(res.get(k));
                }
                for(double val : compute(a,b)){
                    temp.add(val);
                    if(helper(temp)) return true;
                    temp.remove(temp.size()-1);
                }
            }
        }
        return false;
    }
    public List<Double> compute(double a,double b){
        List<Double> res = new ArrayList<>();
        res.add(a+b);
        res.add(a-b);
        res.add(b-a);
        res.add(a*b);
        res.add(a/b);
        res.add(b/a);
        return res;
    }
}