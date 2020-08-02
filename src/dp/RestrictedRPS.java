//package dp;

import java.io.*;
import java.util.StringTokenizer;


public class RestrictedRPS {

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


            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            String sequence = in.next();
            int[] count = new int[26];
            for(int i=0; i<sequence.length(); i++) {
                count[sequence.charAt(i) - 'A']++;
            }

            int wins = Math.min(a, count['S' - 'A']) + Math.min(b, count['R' - 'A']) + Math.min(c, count['P' - 'A']);

            if(2 * wins < sequence.length()) {
                out.println("NO");
                return;
            }

            StringBuilder res = new StringBuilder(sequence.length());

            for (int i = 0; i < sequence.length(); ++i) {
                if (sequence.charAt(i) == 'S' && a > 0) {
                    res.append('R');
                    a--;
                }
                else if (sequence.charAt(i) == 'R' && b > 0) {
                    res.append('P');
                    b--;
                }
                else if (sequence.charAt(i) == 'P' && c > 0) {
                    res.append('S');
                    c--;
                }
                else res.append('_');
            }

            for(int i=0; i< res.length(); i++) {
                if(res.charAt(i) != '_')
                        continue;

                if(a > 0) {
                    a--;
                    res.setCharAt(i, 'R');
                }
                else if( b > 0) {
                    b--;
                    res.setCharAt(i, 'P');
                }
                else  {
                    c--;
                    res.setCharAt(i, 'S');
                }
            }

            out.println("YES");
            out.println(res.toString());
        }

    }

}
