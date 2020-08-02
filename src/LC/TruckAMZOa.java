package LC;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Sharoon Babu
 * Package: codeforces
 * Date: 3/7/20
 */

class PairInt {
    int first;
    int second;
    PairInt(int x, int y) {
        this.first = x;
        this.second = y;
    }
}

public class TruckAMZOa {

    public static void main(String[] args) {
        int truckCapacity = 1;
        List<PairInt> list = new ArrayList();
        list.add(new PairInt(1,2));
        list.add(new PairInt(2,5));


        PriorityQueue<PairInt> pq = new PriorityQueue<PairInt>() {
            public int compare(PairInt a, PairInt b) {
                double distanceA = Math.pow(a.first, 2) + Math.pow(a.second, 2);
                double distanceB = Math.pow(b.first, 2) + Math.pow(b.second, 2);
                return (int)(distanceA - distanceB);
            }
        };


        for(PairInt pair  : list) {
            pq.add(pair);
        }

        List<PairInt> result = new ArrayList();
        while(truckCapacity-- > 0) {
            result.add(pq.poll());
        }


        System.out.printf(result.toString());
    }

}
