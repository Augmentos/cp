//package dp;

import java.io.*;
import java.util.StringTokenizer;


public class BlockAdventure {

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
            int bag = in.nextInt();
            int k = in.nextInt();

            int[] heights = new int[n];
            for(int i=0; i<n; i++) {
                heights[i] = in.nextInt();
            }


            for(int i=0; i < n-1; i++) {
                if(heights[i] >= heights[i+1] - k) {
                    int extraBlocks = heights[i] - (heights[i+1] - k < 0 ? 0 : heights[i+1] - k );
//                    heights[i] -= extraBlocks;

                    bag += extraBlocks;
                } else {
                    int minBlocksRequired = heights[i+1] - k - heights[i];
                    if(bag < minBlocksRequired) {
                        out.println("NO");
                        return;
                    }
                    bag -= minBlocksRequired;
                }
            }

            out.println("YES");
        }


    }
}