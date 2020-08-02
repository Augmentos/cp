//package codeforces;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;


public class LuckyPermutation {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        try {
            solver.solve(in, out);
        } catch (Exception e) {
            return;
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

            int n = in.nextInt();

            HashSet<Integer> set = new HashSet<>();

            int[] A = new int[n];
            int[] B = new int[n];
            int[] C = new int[n];

            for(int i=0; i<n; i++) {
                A[i] = i;
                B[i] = (i+1) % n;
            }

            for(int i=0; i<n; i++) {
                C[i] = (A[i] + B[i]) % n;
                if(!set.add(C[i])) {
                    out.println(-1);
                    return;
                }
            }

            for (int i : A)
                out.print(i + " ");
            out.println();
            for (int i : B)
                out.print(i + " ");
            out.println();
            for (int i : C)
                out.print(i + " ");


        }


    }
}