package dp;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;


public class BrokenKeyboard {

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


            int x = in.nextInt();
            int k = in.nextInt();
            String s = in.next();

            HashSet<Character> set = new HashSet<>();
            while(k-- > 0)
                set.add(in.next().charAt(0));

            long result = 0;
            int left = 0, right = 0;
            while(left <= right && right < s.length()) {
                char ch = s.charAt(right);
                if(set.contains(ch))
                    right++;
                else {
                    if(left != right) {
                        long n = right - left;
                        result += (n*(n+1))/2;
                    }
                    right++;
                    left = right;
                }
            }
            long lastSet = right - left;
            result += (lastSet * (lastSet + 1))/2;
            out.println(result);
        }
    }
}