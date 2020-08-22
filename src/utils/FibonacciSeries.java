import java.util.stream.IntStream;

public class FibonacciSeries {

    private static Integer fibonacci(Integer n) {
        if (n == 0 || n == 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);


        IntStream.range(1, n)
                .mapToLong(FibonacciSeries::fibonacci)
                .boxed()
                .forEach(System.out::println);
    }

}