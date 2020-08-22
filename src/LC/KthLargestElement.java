import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Sharoon Babu on 23/06/22
 */

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int num : nums)
            pq.add(num);

        while(k-- > 1) {
            pq.poll();
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        System.out.println(kthLargestElement.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

}
