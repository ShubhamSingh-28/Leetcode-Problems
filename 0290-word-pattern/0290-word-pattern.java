class Solution {
    public boolean wordPattern(String pattern, String s) {
        String arr[]=s.split(" ");
        if(pattern.length()!= arr.length){
            return false;
        }
        HashMap<Character,String> map= new HashMap<>();
        int i=0;
        for(char c : pattern.toCharArray()){
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i])){
                    return false;
                }
            } else{
                if(map.containsValue(arr[i])){
                    return false;
                }
                map.put(c,arr[i]);
            }
            i++;
        }
        return true;

    }
}