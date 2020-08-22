/**
 * Created by Sharoon Babu on 23/06/22
 */

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        if(nums.length == 0)
            return -1;

        if(nums.length == 1)
            return 0;

        int n = nums.length;

        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        leftSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i-1] + nums[i];
        }

        rightSum[n-1] = nums[n-1];
        for(int i = n - 2; i>=0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }

        if(rightSum[1] == 0)
            return 0;


        for(int i = 1; i<nums.length; i++) {
            if(i == nums.length - 1) {
                if(leftSum[i - 1] == 0)
                    return i;
                return -1;
            }
            if(leftSum[i-1] == rightSum[i+1])
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new PivotIndex().pivotIndex(new int[]{1, 0}));
    }
}
