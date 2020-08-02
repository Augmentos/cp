package codechef;

import javax.print.DocFlavor;
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


public class IsolationCentres {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        try {
            int t = in.nextInt();
            while (t-- > 0) {
                solver.solve(in, out);
            }
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
            int q = in.nextInt();
            String s = in.next();

            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=0; i<s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            while(q-- > 0) {
                int c = in.nextInt();
                int sum = 0;
                for (int a : map.values()) {
                    sum += Math.max(0, a - c);
                }
                System.out.println(sum);
            }




        }


    }
}