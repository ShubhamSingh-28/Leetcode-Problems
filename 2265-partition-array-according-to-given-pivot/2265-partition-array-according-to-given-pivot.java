class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int []res= new int[nums.length];
        int i=0;
        for(int num:nums){
            if(num<pivot){
                res[i]=num;
                i++;
            }
        }
        for(int num:nums){
            if(num==pivot){
                res[i]=num;
                i++;
            }
        }
        for(int num:nums){
            if(num>pivot){
                res[i]=num;
                i++;
            }
        }
        return res;
    }
}