//package codeforces;

import java.io.*;
import java.util.StringTokenizer;


public class FoxDividingCheese {

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

            int a = in.nextInt();
            int b = in.nextInt();

            int[] arr = new int[]{2, 3, 5};

            long result = 0;
            for(int i=0; i<arr.length; i++) {
                int divisor = arr[i];

                long power1 = 0;
                while(a % divisor == 0) {
                    a/=divisor;
                    power1++;
                }

                long power2 = 0;
                while(b % divisor == 0) {
                    b/=divisor;
                    power2++;
                }
                result += Math.abs(power1 - power2);

            }

            if(a != b)  out.println(-1);
            else out.println(result);


        }


    }
}