/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Roberto Wang
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (n == k) {
			return 1;
		} else if (k == 1) {
			return n;
		} else {
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
		}
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		if (n <= 999) {
			return String.valueOf(n);
		} else {
			return intWithCommas(n / 1000) + "," + String.valueOf(n / 100 % 10) + String.valueOf(n / 10 % 10)
					+ String.valueOf(n % 10);
		}
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length - 1);
	}

	private void reverseArray(int[] x, int index, int len) {
		if (index < len) {
			int temp = x[index];
			x[index] = x[len];
			x[len] = temp;
			reverseArray(x, ++index, --len);
		}
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int largest = a[0];
		int smallest = a[0];
		return arrayRange(largest, smallest, 0, a, a.length);
	}

	public int arrayRange(int max, int min, int i, int[] a, int len) {
		if (i == len) {
			return max - min;
		} else {
			if (a[i] > max) {
				max = a[i];
			} else if (a[i] < min) {
				min = a[i];
			}
			return arrayRange(max, min, ++i, a, len);
		}
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		if (nums.length == 1 || nums.length == 0) {
			return true;
		} else if (nums[nums.length - 2] > nums[nums.length - 1]) {
			return false;
		} else {
			int[] temp = new int[nums.length - 1];
			System.arraycopy(nums, 0, temp, 1, temp.length - 1);
			return isSorted(temp);
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		if (search.equals(strs[0])) {
			return true;
		} else if (strs.length == 1) {
			return false;
		} else {
			String[] temp = new String[strs.length - 1];
			System.arraycopy(strs, 1, temp, 0, temp.length);
			return found(search, temp);
		}
	}
}
