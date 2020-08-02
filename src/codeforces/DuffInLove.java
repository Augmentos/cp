package codeforces;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;


public class DuffInLove {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(in, out);
        out.close();
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static class TaskA {
        public static void solve(InputReader in, PrintWriter out) {

            long n = Long.valueOf(in.next());
            HashSet<Long> primes = new HashSet<>();

            while(n%2 == 0) {
                n/=2;
                primes.add(2l);
            }

            for(long i = 3; i<= Math.sqrt(n); i+=2) {
                if(n % i == 0) {
                    primes.add(i);
                    while (n % i == 0) n /= i;
                }
            }

            if(n > 2)   primes.add(n);

            long product = 1;
            for (long i : primes)
                product *= i;

            out.println(product);
        }


    }
}