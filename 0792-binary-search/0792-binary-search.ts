function search(nums: number[], target: number): number {
    var start = 0;
    var end = nums.length-1;
    var ans = -1;
    while(start<=end){
        let mid = start+ Math.floor((end-start)/2);
        const val = nums[mid];
        if(val===target){
            ans = mid;
            break;
        } else if(val<target){
            start = mid+1;
        } else {
            end=mid-1;
        }
    }
    return ans;
};