package codechef;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class COVID {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            solver.solve(in, out, sc);
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

       /* public String next() {
            return String.valueOf(sc.nextInt());
        }
*/
       /* public int nextInt() {
            return Integer.parseInt(next());
        }*/

    }

    static class TaskA {
        public static void solve(InputReader in, PrintWriter out, Scanner sc) {


            int n = sc.nextInt();
            int prev = -1, currCount = 1, minCount = Integer.MAX_VALUE, maxCount = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                if(i == 0)  prev = sc.nextInt();
                else {
                    int curr = sc.nextInt();
                    int distance = curr - prev;
                    prev = curr;
                    if(distance <= 2)
                        currCount++;
                    else {
                        minCount = Math.min(minCount, currCount);
                        maxCount = Math.max(maxCount, currCount);
                        currCount = 1;
                    }
                }
            }

            minCount = currCount != 0 ? Math.min(minCount, currCount) : minCount;
            maxCount = Math.max(maxCount, currCount);
            out.println(minCount + " " + maxCount);

        }


    }
}