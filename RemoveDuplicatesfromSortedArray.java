/**Remove Duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/

/**题目中只要求数组中前几位按序出现不相同数，故可以改变原来数组，使之元素与元素不完全相同
思路：由于数组有序，用index记录下当前要比较元素，然后遍历找到与index对应元素不同的下标，
将此下标对应元素直接赋值给index的下一个元素，即将index加1后赋值，这样当遍历完成后，数组
前几位就是元素组各不相同元素的排序了。由于返回的是不同元素的个数，而index是下标故加1*/

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }
}