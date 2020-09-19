import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0215_KthLargestElementInAnArray_Test {

	@Test
	public void test1() {
		int[] array = new int[]{3, 2, 1, 5, 6, 4};
		_0215_KthLargestElementInAnArray myClass = new _0215_KthLargestElementInAnArray();
		assertEquals(5, myClass.findKthLargest(array, 2));
	}

	@Test
	public void test2() {
		int[] array = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
		_0215_KthLargestElementInAnArray myClass = new _0215_KthLargestElementInAnArray();
		assertEquals(4, myClass.findKthLargest(array, 4));
	}
}
