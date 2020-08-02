//package codeforces;//package template;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class ChildAndSet {

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


            int target = in.nextInt();
            int limit = in.nextInt();

            int sum = 0, size =  0;
            List<Integer> set = new ArrayList();
            for(int i = limit; i > 0; i--) {

                int bit = Integer.lowestOneBit(i);
                if(sum + bit <= target) {
                    sum += bit;
                    set.add(i);
                    size += 1;
                }

            }

            if(sum != target) {
                out.println(-1);
                return;
            }

            out.println(size);
            for (int num : set)
                out.print(num + " ");

        }


    }
}