package dp;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class AlternatingSubSequence {

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
            ArrayList<Integer> list = new ArrayList();
            int n = in.nextInt();
            while(n-- > 0) {
                list.add(in.nextInt());
            }

            long sum =  0;
            for(int i=0; i<list.size(); ) {
                int s = list.get(i);
                int j = i;
                int max = list.get(i);
                while(j < list.size() && isSameSign(s, list.get(j))) {
                    max = Math.max(list.get(j), max);
                    j++;
                }
                i = j;
                sum += max;
            }

            System.out.println(sum);
        }

        private static boolean isSameSign(int a, int b) {
            if(a < 0 && b < 0)
                    return true;
            if(a > 0 && b > 0)
                    return true;
            return false;
        }


    }


}