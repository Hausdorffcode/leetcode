/**Maximum Subarray
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.*/

/**分治策略：一次分半，递归考虑左半与右半，还有cross中间的和，三者取最大。
关键在于边界条件的考虑。O(nlgn)*/
public class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length-1);
    }
    
    private int crossSum(int[] nums, int i, int j) {

        int left = (i+j)/2;
        int right = left + 1;
        int leftSum = nums[left];
        int rightSum = nums[right];
        int tempSum = nums[left];
        for (int k = left-1; k >= i; k--) {
            tempSum += nums[k];
            if (tempSum > leftSum) {
                leftSum = tempSum;
            }
        }
        tempSum = nums[right];
        for (int k = right+1; k <= j; k++) {
            tempSum += nums[k];
            if (tempSum > rightSum) {
                rightSum = tempSum;
            }
        }
        return leftSum + rightSum;
    }
    
    private int maxSubArray(int[] nums, int i, int j) {
        int sum = 0;

        if (i < j) {
            int mid = (i+j)/2;
            int left = maxSubArray(nums, i, mid);
            int right = maxSubArray(nums, mid+1, j);
            int middle = crossSum(nums, i, j);
            sum = Math.max(left, right);
            sum = Math.max(sum, middle);
        } else if (i == j) {
            sum = nums[i];
        } 
        return sum;
    }
}

/**O(n)算法，动态规划*/
public class Solution {
	public int maxSubArray(int[] A) {
		int n = A.length;
		int target = Integer.MIN_VALUE;
        int sum = 0;
		for (int i = 0; i < n; i++) {
		    sum = Math.max(sum + A[i], A[i]);
		    if (sum > target) {
		        target = sum;
		    }
		}
		return target;
	}
}

/**另一版本*/
public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			if (sum > max) {
				max = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}
}