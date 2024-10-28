class Solution {
    public String convert(String s, int numRows) {

        if(numRows==1 || numRows>=s.length()){
            return s;
        }
        int idx=0;
        int d=0;

        List<List<Character>> list= new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(new ArrayList<>());
        }

        for(char c:s.toCharArray()){
            list.get(idx).add(c);
            if(idx==0){
                d=1;
            } else if(idx==numRows-1){
                d=-1;
            }
            idx+=d;
        }
        StringBuilder res= new StringBuilder();
        for(List<Character> l: list){
            for(char c:l){
                res.append(c);
            }
        }
        return res.toString();
    }
}