class Solution {
    public void sortColors(int[] nums) {
        List<Integer> a= new ArrayList<>();
        List<Integer> b= new ArrayList<>();
        List<Integer> c= new ArrayList<>();
        for(int i:nums){
            if(i==0){
                a.add(i);
            } else if(i==1){
                b.add(i);
            }else{
                c.add(i);
            }
        }
        int j=0;
        for(int i=0;i<a.size();i++){
            nums[j]=a.get(i);
            j++;
        }
         for(int i=0;i<b.size();i++){
            nums[j]=b.get(i);
            j++;
        }
         for(int i=0;i<c.size();i++){
            nums[j]=c.get(i);
            j++;
        }
    }
}