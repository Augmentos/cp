//package codeforces;//package template;

import java.io.*;
import java.util.StringTokenizer;


public class TanyaPostcard {

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


            String temp = in.next();
            String text = in.next();

            StringBuilder letter = new StringBuilder(temp);

            int[] ascii = new int[256];

            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                ascii[ch]++;
            }


            int yays = 0;

            for (int i = 0; i < letter.length(); i++) {
                char ch = letter.charAt(i);
                if(ascii[ch] > 0) {
                    ascii[ch]--;
                    yays++;
                    letter.setCharAt(i, '#');
                }
            }

            int whoops = 0;
            for (int i = 0; i < letter.length(); i++) {
                char ch = letter.charAt(i);
                if(ch != '#') {
                    if(ascii[Character.toUpperCase(ch)] > 0) {
                        ascii[Character.toUpperCase(ch)]--;
                        whoops++;
                    } else if(ascii[Character.toLowerCase(ch)] > 0) {
                        ascii[Character.toLowerCase(ch)]--;
                        whoops++;
                    }
                }
            }
            out.print(yays + " " + whoops);

        }


    }
}