class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans= new HashSet<>();
        Set<Integer> set= new HashSet<>();
        for(int i:arr){
            Set<Integer> set2= new HashSet<>();
            for(int j:set)
                set2.add(i | j);
            set2.add(i);
            set=set2;
            ans.addAll(set);
        }
        return ans.size();
    }
}