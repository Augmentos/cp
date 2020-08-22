/**
 * Created by Sharoon Babu on 08/05/21
 */

public class CountZeroesInFact {
    public static void main(String[] args) {
        int x = 100;
        countZeroes(x);
    }

    private static void countZeroes(int x) {
        int totalFives = 0;
        for (int i = 1; i * 5 <= x; i++) {
            int temp = i * 5;
            while(temp % 5 == 0) {
                totalFives++;
                temp /= 5;
            }
        }
        System.out.println("Total Zeroes " + totalFives);
    }
}
