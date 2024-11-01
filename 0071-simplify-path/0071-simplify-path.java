class Solution {
    public String simplifyPath(String path) {
        Stack<String> s= new Stack<>();
         String[] a = path.split("/");
        for(String str :a){
            if(str.equals(".") || str.isEmpty()){
                continue;
            } else if(str.equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            } else{
                s.push(str);
            }
        }
        return "/" + String.join("/",s);
    }
}