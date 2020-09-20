import java.util.PriorityQueue;

public class _0215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {

	    PriorityQueue<Integer> minHeap =
			    new PriorityQueue<Integer>(k + 1);

	    for (int n : nums) {
	    	minHeap.offer(n);
	    	if (minHeap.size() > k) {
			    minHeap.poll();
		    }
	    }

    	return minHeap.peek();
    }
}
