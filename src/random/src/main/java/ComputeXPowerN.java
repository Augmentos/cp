/**
 * Created by Sharoon Babu on 08/05/21
 */

public class ComputeXPowerN {
    public static void main(String[] args) {
        int x = 5, n = 3;
        System.out.println("Result " + computeXPowerN(x, n));
    }

    private static int computeXPowerN(int x, int n) {
        if (n == 0)
            return 1;

        if (n % 2 == 0) {
            final int temp = computeXPowerN(x, n / 2);
            return temp * temp;
        }

        return x * computeXPowerN(x, n - 1);
    }
}
