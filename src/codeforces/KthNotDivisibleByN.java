//package codeforces;

import java.io.*;
import java.util.StringTokenizer;


public class KthNotDivisibleByN {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        int t = in.nextInt();
        while(t-- > 0) {
            solver.solve(in, out);
        }
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


            long n = in.nextInt();
            long k = in.nextInt();



            if(k < n)
                out.println(k);
            else {
                long multiplier = k/(n-1);
                long noOfNonDivPassed = multiplier * (n-1);
                long value = multiplier * n;

                if (noOfNonDivPassed == k)
                    out.println(value - 1);
                else out.println(value + k - noOfNonDivPassed);
            }

        }


    }
}