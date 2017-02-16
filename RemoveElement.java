/**Remove Element
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.*/

/**根据题意，可以改变原数组，于是用index指示下一个不同于val的元素的位置，遍历数组，找到与val不同的
元素时，将此值直接赋值给index位置，并使index+1，以准备下一次赋值。当碰到与val相同元素，直接跳过（i++，什么也不做）
只关心与val不同的元素。最后返回值是与val不同元素的个数，由于index表示下一个待插入位置，故其值等于个数*/

public class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (val != nums[i]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}