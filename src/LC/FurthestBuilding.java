import java.util.PriorityQueue;

/**
 * Created by Sharoon Babu on 22/06/22
 */

public class FurthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> bricksUsedAtEachLevel = new PriorityQueue<>();
        int bricksUsed = 0;
        int i = 0;
        for(; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1])
                continue;

            int diff = heights[i + 1] - heights[i];
            if (bricksUsed + diff <= bricks) {
                bricksUsed += diff;
                bricksUsedAtEachLevel.add(diff);
            } else if (ladders > 0) {
                if (!bricksUsedAtEachLevel.isEmpty() && bricksUsedAtEachLevel.peek() > diff) {
                    int bricksToBeReplacedWithLadder = bricksUsedAtEachLevel.poll();
                    bricksUsed = bricksUsed - bricksToBeReplacedWithLadder + diff;
                    bricksUsedAtEachLevel.add(diff);
                }
                ladders--;
            } else {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        FurthestBuilding furthestBuilding = new FurthestBuilding();
        System.out.println(furthestBuilding.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2));
    }
}
