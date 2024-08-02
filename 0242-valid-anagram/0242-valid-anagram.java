class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length() ){
            return false;
        }
        char arr1[] = s.toCharArray();
        char arr2[] = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int index1=0;
        int index2=0;
        int len=arr1.length;
        while(index1<len && index2<len){
            if(arr1[index1]!= arr2[index2]){
                return false;
            }
            index1++;
            index2++;
        }
        return true;
    }
}