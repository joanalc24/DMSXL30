// [704 Binary Search](https://leetcode.com/problems/binary-search/)
class 704_biary-search {
    /* 思路
    [Left, right] 左闭右闭作为查找区间。***移动left, right指针***
        left=0, right=len-1; 左右可相等。
        中间值注意overflow,用left+(right-left)/2.
        先查nums[mid]
        如果target > nums[mid],要查右区间. 
            从[left, mid,right]，mid在查找区间内已查，把left移到mid右边, left = mid + 1
        如果target < nums[mid],要查左区间
            mid在区间内已查,把right移到mid左边,right = mid - 1;

    如果是[left, right)思路，则right初始为nums.length
    右边没查过，所以right = mid;
     */
    
    // sorted in ascending, require O(logn) --> binary search, all numbers unque
    
    public int search(int[] nums, int target) {
        // [left, right]: intervals to check
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // avoid integer overflow
            if ( nums[mid] == target) return mid;
            else if (nums[mid] > target) { // search left interval
                right = mid - 1; // mid is [], inclusive and already checked mid
            } else { // search right interval
                left = mid + 1;
            }
        }
        return -1;
    }

    public int searchII(int[] nums, int target) {
        // [left, right): intervals to check
        int left = 0, right = nums.length; // not including right, so nums.length
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) { // search left interval, nums[right] wasn't checked, could be the target
                right = mid;
            } else { //search right interval, nums[left] already checked inclusively, skip
                left = mid + 1;
            }
        }
        return -1;
    }
    /* Given an array of integers nums which is sorted in ascending order, and an integer target, 
    write a function to search target in nums. 
    If target exists, then return its index. Otherwise, return -1.

    You must write an algorithm with O(log n) runtime complexity.
    */
    
    /*
    Example 1:
        Input: nums = [-1,0,3,5,9,12], target = 9, Output: 4
        Explanation: 9 exists in nums and its index is 4

    Example 2:
        Input: nums = [-1,0,3,5,9,12], target = 2 Output: -1
        Explanation: 2 does not exist in nums so return -1 */
}