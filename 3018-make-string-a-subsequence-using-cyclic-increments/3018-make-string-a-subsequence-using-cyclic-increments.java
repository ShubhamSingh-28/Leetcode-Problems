class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        // HashMap<Integer,Integer> map= new HashMap<>();
        // for(char c:str2.toCharArray()){
        //     int ind= c-'a';
        //     map.put(ind,map.getOrDefault(ind,0)+1);
        // }
        // for(char c:str1.toCharArray()){
        //     int ind= c-'a';
        //     if(map.containsKey(ind) || map.containsKey(ind+1)){
        //         int count=map.get(ind);
        //         map.put(ind,count-1);
        //         if(map.get(ind)==0){
        //             map.remove(ind);
        //         }
        //     }
        // }
        // return map.isEmpty();

        int s=0;
        int end=str2.length();
        for(char c: str1.toCharArray()){
            if(s<end && (str2.charAt(s)-c+26)%26 <=1){
                s++;
            }
        }
        return s==end;
    }
}