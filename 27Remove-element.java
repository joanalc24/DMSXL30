// https://leetcode.com/problems/remove-element/
class 27Remove-element {
    // continuous same type address.
    // erase() takes O(n) to override previous elements. 

    // BruceForce: O(n^2) 每次遇见，就后面所有的都前移
    // 2 pointers: assign nums[slow] iff nums[fast] not val.不改变相对位置
    // 2 pointers: left right swap. 左边保留都是合法的，往右边走,一直找到不是val的准备交换；右边往左走，直到找到是val的，交换
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left <= right) { // l=r is valid, just swap
            // 左边保留不是val的，找到左边第一个等于val的停下来准备交换，所以不是val的一直往前继续找
            while(left <= right && nums[left] != val ) {
                left++;
            }
            // 找打右边第一个不是val的，如果是val的倒退skip
            while(left <= right && nums[right] == val ) {
                right--;
            }
            if (left < right) { //注意查边界。相等没意义
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left; // leftIndex一定指向了最终数组末尾的下一个元素
    }
    
    public int removeElementFastSlowPointers(int[] nums, int val) {
        // fast: check each one; slow: the index that does NOT contain val
        // assign nums[slow] iff nums[fast] != val
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast]; 
                slow++;
            }
        }
        return slow;
    }
    public int removeElementBF(int[] nums, int val) {
        int size = nums.length;
        for(int i = 0; i < size; i++) {
            if(nums[i] == val) {
                for(int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j]; // use index j-1, and j; j前面的等于j
                }
                size--;
                i--; // i restart from current pos
            }
        }
        return size;
    }

    /*
    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
    The relative order of the elements may be changed.

    Since it is impossible to change the length of the array in some languages, 
    you must instead have the result be placed in the first part of the array nums.
     More formally, if there are k elements after removing the duplicates, 
     then the first k elements of nums should hold the final result. 
     It does not matter what you leave beyond the first k elements.

    Return k after placing the final result in the first k slots of nums.

    Do not allocate extra space for another array. 
    You must do this by modifying the input array in-place with O(1) extra memory.*/

    /*
     * Input: nums = [3,2,2,3], val = 3, Output: 2, nums = [2,2,_,_], return 2
        It does not matter what you leave beyond the returned k (hence they are underscores).

        Input: nums = [0,1,2,2,3,0,4,2], val = 2  Output: 5, nums = [0,1,4,0,3,_,_,_] return k = 5, 
     */
}
// https://programmercarl.com/