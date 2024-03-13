class Solution {
    // square then sort. O(nlogn)
    // 负数的平方，和正数的平方，都往中间递减. 2 pointers towards center P(n)
    
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1;
        int[]res = new int[nums.length]; // get a new res array
        int index = r;
        while(l <= r) {
            int leftRes = nums[l] * nums[l], rightRes = nums[r] * nums[r];
            if (l <= r && leftRes <= rightRes) { // check boundary
                res[index] = rightRes;
                r--;
            } else {
                res[index] = leftRes;
                l++;
            }
            index--; // move index
        }
        return res;
    }

    public int[] sortedSquares_sort(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
    /* Given an integer array nums sorted in non-decreasing order, 
    return an array of the squares of each number sorted in non-decreasing order.
    Input: nums = [-4,-1,0,3,10], Output: [0,1,9,16,100]
        Explanation: After squaring, the array becomes [16,1,0,9,100].After sorting, it becomes [0,1,9,16,100].
    Example 2: Input: nums = [-7,-3,2,3,11], Output: [4,9,9,49,121]
    */
}