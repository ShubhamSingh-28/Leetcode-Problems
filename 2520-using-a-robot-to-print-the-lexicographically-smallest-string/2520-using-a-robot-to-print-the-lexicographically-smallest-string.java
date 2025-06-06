class Solution {
    public String robotWithString(String s) {
        StringBuilder t= new StringBuilder();
        StringBuilder paper= new StringBuilder();
        int n=s.length();
        char arr[]=new char[n];
        arr[n-1]=s.charAt(n-1);
        for(int i=n-2;i>=0;i--){
            arr[i]=(char)Math.min(s.charAt(i),arr[i+1]);
        }
        for(int i=0;i<n;i++){
            t.append(s.charAt(i));
            while(!t.isEmpty() && (i == n - 1 || t.charAt(t.length() - 1) <= arr[i + 1])){
                paper.append(t.charAt(t.length()-1));
                t.setLength(t.length() - 1);
            }
        }
        return paper.toString();
    }
}