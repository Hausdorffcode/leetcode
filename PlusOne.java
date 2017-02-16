/**Plus One
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.*/

/**原始想法：将数组表示成数，在加1，然后转化回数组,判断新数长度很麻烦
注意使用的Stack的size是动态变化的，所以要先用一个变量记住它
注意数据溢出,使用double的话由于浮点数的精度问题，算出的值总是有误差
pass*/
public int[] plusOne(int[] digits) {
        int num = 0;
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            num = digits[i] + num*10;
        }
        num++;
        Stack<Integer> a = new Stack<>();
        while (num != 0) {
            a.add(num%10);
            num /= 10;
        }
        int size = a.size();
        int[] result = new int[size];
        for(int i = 0; i < size; i++) {
            result[i] = (int)a.pop();
        }
        return result;
    }
	
/**应该直接按位加，遇到要进位时，递归处理高位, 再改成非递归形式*/
public class Solution {
	public int[] plusOne(int[] digits) {
		int n = digits.length;
		digits[n-1] += 1;
		int index = n-1;
        while (digits[index] > 9 && index > 0) {
            digits[index--] = 0;
            digits[index] += 1;
        }
        if (digits[0] != 10) {
            return digits;
        }
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 0;
        for (int i = 1; i < n; i++) {
            result[i+1] = digits[i];
        }
        return result;
	}
}

/**改进版*/
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int length = digits.length;
		int add = 1;
		for (int i = length - 1; i >= 0; i--) {
			int sum = digits[i] + add;
			digits[i] = sum % 10;
			add = sum / 10;
			if (add == 0)
				return digits;
		}
		int[] ret = new int[length + 1];
		ret[0] = add;
		for (int i = 0; i < length; i++) {
			ret[i + 1] = digits[i];
		}
		return ret;
	}
}