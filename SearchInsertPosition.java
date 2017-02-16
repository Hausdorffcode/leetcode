/**Search Insert Position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

/**直接思路：由于有序，直接遍历即可*/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int i;
        for (i = 0; i < n; i++) {
            if (nums[i] >= target) {
                break;
            }
        }
        return i;
    }
    
}

/**可以考虑二分搜索*/
public int searchInsert(int[] A, int target) {
		int length = A.length;
		if (A.length == 0)
			return 0;
		int i = 0, j = length - 1;
		while (i < j) {
			int mid = (i + j) / 2;
			if (A[mid] == target)
				return mid;
			if (A[mid] < target) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		return A[i] < target ? i + 1 : i;
	}