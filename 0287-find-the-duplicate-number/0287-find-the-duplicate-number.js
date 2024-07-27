/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
    for (let index = 0; index < nums.length; index++) {
        const element =Math.abs(nums[index]);
        const actualpos = element-1;
        if (nums[actualpos] < 0) {
            return element;
        }
        nums[actualpos] = -1*nums[actualpos];
    }
    return -1;
};