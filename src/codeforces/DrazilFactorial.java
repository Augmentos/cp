//package codeforces;

import java.io.*;
import java.util.*;


public class DrazilFactorial {

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

            int n = in.nextInt();
            String x = in.next();

            int start = 0;
            while(x.charAt(start) == '0')
                start++;

            x = x.substring(start);

            Map<Integer, String> map = new HashMap<Integer, String>(){{
                put(2,"2");
                put(3, "3");
                put(4, "322");
                put(5, "5");
                put(6, "53");
                put(7, "7");
                put(8, "7222");
                put(9, "7332");
            }};

            StringBuilder result = new StringBuilder();
            for(int i=0; i<x.length(); i++) {
                int xi = x.charAt(i) - '0';
                if(xi ==  1 || xi == 0)
                    continue;
               result.append(map.get(xi));
            }
            char[] chars = result.toString().toCharArray();
            Arrays.sort(chars);

            out.println(new StringBuilder(new String(chars)).reverse().toString());
        }


    }
}