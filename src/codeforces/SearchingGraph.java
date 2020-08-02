//package codeforces;

import java.io.*;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class SearchingGraph {

    static BiFunction<Integer, Integer, Integer> ADD = (x, y) -> (x + y);

    static Function<Pair<Integer, Integer>, Integer> GET_FIRST = (x) -> (x.first);
    static Function<Pair<Integer, Integer>, Integer> GET_SECOND = (x) -> (x.second);
    static Comparator<Pair<Integer, Integer>> C = Comparator.comparing(GET_FIRST).thenComparing(GET_SECOND);

    public static void main(String[] args) throws Exception {
//        long startTime = System.nanoTime();
        int t = 1;
        while (t-- > 0) {
            solve();
        }
//        long endTime = System.nanoTime();
//        err.println("Execution Time : +" + (endTime - startTime) / 1000000 + " ms");
        exit(0);
    }

    static void solve() {

        int n = in.nextInt();
        int m = in.nextInt();

        long ans = binpow(3l, (long) n, (long)m) - 1;
        if(ans < 0) ans += m;

        System.out.println(ans);
    }

    static long binpow(long a, long b, long p) {
        if (b == 0)
            return 1;
        long res = binpow(a, b / 2, p);
        if (b % 2 == 1)
            return (((res * res) % p ) * a) % p;
        else
            return (res * res) % p;
    }

    static void debug(Object... args) {
        for (Object a : args) {
            out.println(a);
        }
    }

    static void y() {
        out.println("YES");
    }

    static void n() {
        out.println("NO");
    }

    static void fail() {
        out.println("-1");
        exit(0);
    }

    static class Pair<T, R> {
        public T first;
        public R second;

        public Pair(T first, R second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "Pair{" + "a=" + first + ", b=" + second + '}';
        }

        public T getFirst() {
            return first;
        }

        public R getSecond() {
            return second;
        }
    }

    static <T, R> Pair<T, R> make_pair(T a, R b) {
        return new Pair<>(a, b);
    }

    static class ArrayUtils {

        static int[] reverse(int[] data) {
            int[] p = new int[data.length];
            for (int i = 0, j = data.length - 1; i < data.length; i++, j--) {
                p[i] = data[j];
            }
            return p;
        }

        static void prefixSum(long[] data) {
            for (int i = 1; i < data.length; i++) {
                data[i] += data[i - 1];
            }
        }

        static void prefixSum(int[] data) {
            for (int i = 1; i < data.length; i++) {
                data[i] += data[i - 1];
            }
        }

        static long[] reverse(long[] data) {
            long[] p = new long[data.length];
            for (int i = 0, j = data.length - 1; i < data.length; i++, j--) {
                p[i] = data[j];
            }
            return p;
        }

        static char[] reverse(char[] data) {
            char[] p = new char[data.length];
            for (int i = 0, j = data.length - 1; i < data.length; i++, j--) {
                p[i] = data[j];
            }
            return p;
        }

        static int[] MergeSort(int[] A) {
            if (A.length > 1) {
                int q = A.length / 2;
                int[] left = new int[q];
                int[] right = new int[A.length - q];
                System.arraycopy(A, 0, left, 0, q);
                System.arraycopy(A, q, right, 0, A.length - q);
                int[] left_sorted = MergeSort(left);
                int[] right_sorted = MergeSort(right);
                return Merge(left_sorted, right_sorted);
            } else {
                return A;
            }
        }

        static int[] Merge(int[] left, int[] right) {
            int[] A = new int[left.length + right.length];
            int i = 0;
            int j = 0;
            for (int k = 0; k < A.length; k++) {
                // To handle left becoming empty
                if (i == left.length && j < right.length) {
                    A[k] = right[j];
                    j++;
                    continue;
                }
                // To handle right becoming empty
                if (j == right.length && i < left.length) {
                    A[k] = left[i];
                    i++;
                    continue;
                }
                if (left[i] <= right[j]) {
                    A[k] = left[i];
                    i++;
                } else {
                    A[k] = right[j];
                    j++;
                }
            }
            return A;
        }

        static long[] MergeSort(long[] A) {
            if (A.length > 1) {
                int q = A.length / 2;
                long[] left = new long[q];
                long[] right = new long[A.length - q];
                System.arraycopy(A, 0, left, 0, q);
                System.arraycopy(A, q, right, 0, A.length - q);
                long[] left_sorted = MergeSort(left);
                long[] right_sorted = MergeSort(right);
                return Merge(left_sorted, right_sorted);
            } else {
                return A;
            }
        }

        static long[] Merge(long[] left, long[] right) {
            long[] A = new long[left.length + right.length];
            int i = 0;
            int j = 0;
            for (int k = 0; k < A.length; k++) {
                // To handle left becoming empty
                if (i == left.length && j < right.length) {
                    A[k] = right[j];
                    j++;
                    continue;
                }
                // To handle right becoming empty
                if (j == right.length && i < left.length) {
                    A[k] = left[i];
                    i++;
                    continue;
                }
                if (left[i] <= right[j]) {
                    A[k] = left[i];
                    i++;
                } else {
                    A[k] = right[j];
                    j++;
                }
            }
            return A;
        }

        static int nCrModp(int n, int r, int p) {
            if (r > n - r)
                r = n - r;

            // The array C is going to store last
            // row of pascal triangle at the end.
            // And last entry of last row is nCr
            int C[] = new int[r + 1];

            C[0] = 1; // Top row of Pascal Triangle

            // One by constructs remaining rows of Pascal
            // Triangle from top to bottom
            for (int i = 1; i <= n; i++) {

                // Fill entries of current row using previous
                // row values
                for (int j = Math.min(i, r); j > 0; j--)

                    // nCj = (n-1)Cj + (n-1)C(j-1);
                    C[j] = (C[j] + C[j - 1]) % p;
            }
            return C[r];
        }

        static long nCr(int n, int r) {
            if (r > n - r)
                r = n - r;

            // The array C is going to store last
            // row of pascal triangle at the end.
            // And last entry of last row is nCr
            long C[] = new long[r + 1];

            C[0] = 1; // Top row of Pascal Triangle

            // One by constructs remaining rows of Pascal
            // Triangle from top to bottom
            for (int i = 1; i <= n; i++) {

                // Fill entries of current row using previous
                // row values
                for (int j = Math.min(i, r); j > 0; j--)

                    // nCj = (n-1)Cj + (n-1)C(j-1);
                    C[j] = (C[j] + C[j - 1]);
            }
            return C[r];
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] readAllInts(int n) {
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }
            return p;
        }

        public int[] readAllInts(int n, int s) {
            int[] p = new int[n + s];
            for (int i = s; i < n + s; i++) {
                p[i] = in.nextInt();
            }
            return p;
        }

        public long[] readAllLongs(int n) {
            long[] p = new long[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextLong();
            }
            return p;
        }

        public long[] readAllLongs(int n, int s) {
            long[] p = new long[n + s];
            for (int i = s; i < n + s; i++) {
                p[i] = in.nextLong();
            }
            return p;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static void exit(int a) {
        out.close();
        err.close();
        System.exit(a);
    }

    static InputStream inputStream = System.in;
    static OutputStream outputStream = System.out;
    static OutputStream errStream = System.err;
    static InputReader in = new InputReader(inputStream);
    static PrintWriter out = new PrintWriter(outputStream);
    static PrintWriter err = new PrintWriter(errStream);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

}