function findDuplicates(nums: number[]): number[] {
     const ans = [];
    for(let i = 0; i<nums.length; i++){
        const element =Math.abs(nums[i]);
        const actualpos= element-1;
        if(nums[actualpos]<0){
            ans.push(element);
        }
        nums[actualpos]= -1*nums[actualpos]
    }
    return ans;
};