class Solution {
    public long continuousSubarrays(int[] nums) {
        // time complexity O{N} but cannot handle very large input
        // int n= nums.length;
        // int min=Integer.MAX_VALUE;
        // int max= Integer.MIN_VALUE;
        // int start=0;
        // long count=0;
        // int size=0;
        // int end;
        // for(end=0;end<n;++end){
        //     min=Math.min(min,nums[end]);
        //     max=Math.max(max,nums[end]);
        //     if(max-min >2){
        //         size=end-start;
        //         count += (size*(size+1))/2;
        //         start=end;
        //         min=nums[end];
        //         max=nums[end];
        //         while(Math.abs(nums[end]-nums[start-1])<=2){
        //             start--;
        //             min=Math.min(min,nums[start]);
        //             max=Math.max(max,nums[start]);
        //         }

        //         if(start < end){
        //             size= end-start;
        //             count -= (size*(size+1))/2;
        //         }
        //     }
        // }
        // size= end-start;
        // count += (size*(size+1))/2;
        // return count;

        // time complexity O(nlogn) and space O(n)
        long ans =0;
       int i =0;
       int j=0;
       TreeMap<Integer,Integer>map = new TreeMap<>();
       while(j<nums.length){
        map.put(nums[j], map.getOrDefault(nums[j],0)+1);
          while(i<nums.length && map.lastKey()-map.firstKey()>2){
            map.put(nums[i],map.getOrDefault(nums[i],0)-1);
            if(map.get(nums[i])==0){
                map.remove(nums[i]);
            }
            i++;
          }
          ans+=j-i+1;
          j++;
       }
       return ans;
    }
}