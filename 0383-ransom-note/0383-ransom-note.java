class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        HashMap<Character,Integer> map= new HashMap<>();
        for(char c:magazine.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<ransomNote.length();i++){
            char c= ransomNote.charAt(i);
            if(!map.containsKey(c) ){
                return false;
            } else if(map.containsKey(c) && map.get(c)<=0){
                return false;
            } else{
                map.put(c,map.getOrDefault(c,0)-1);
            }

        }
        return true;
    }
}