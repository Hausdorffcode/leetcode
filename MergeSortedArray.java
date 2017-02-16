/**Merge Sorted Array
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

/**这是通常的merge方法，这里要merge到nums1中，
由于直接在nums1总merge会破坏num1中的元素，我使用了一个临时数组*/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int i = 0;
        int j = 0;
        for (int k = 0; k < m+n; k++) {
            if (i >= m) temp[k] = nums2[j++];
            else if (j >= n) temp[k] = nums1[i++];
            else if (nums1[i] > nums2[j]) temp[k] = nums2[j++];
            else temp[k] = nums1[i++];
        }
        for (int k = 0; k < m+n; k++) {
            nums1[k] = temp[k];
        }
    }
}

/**可以考虑从数组num1尾开始merge*/
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int i = m - 1, j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			A[k--] = A[i] >= B[j] ? A[i--] : B[j--];
		}
		while (j >= 0) {   //只处理num2中的剩余项，因为本身就是merge到num1中
			A[k--] = B[j--];
		}
	}
}