//package codechef;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

class TriplePair {
    int first;
    int second;
    int third;
    TriplePair(int first, int second, int third) {
        this.first = first;
        this.second =  second;
        this.third = third;
    }
}

class TripleSort {

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
            int k = in.nextInt();

            int[] A = new int[n];
            for(int i=0; i<n; i++)
                A[i] = in.nextInt();

            int m = 0;
            ArrayList<TriplePair> list = new ArrayList<>();
            for (int i = 0; i<n; ) {
                if (A[i] - 1 != i) {
                    m++;

                    int firstIndex = i;
                    int secondIndex = A[i] - 1;
                    int thirdIndex = A[secondIndex] - 1;

                    if(m > k) {
                        out.println(-1);
                        return;
                    }

                    if(((thirdIndex == firstIndex))) {
                        thirdIndex = firstIndex + 1;
                        while(thirdIndex < A.length && (thirdIndex == firstIndex || thirdIndex == secondIndex))
                            thirdIndex++;
                        if(thirdIndex == A.length) {
                            out.println(-1);
                            return;
                        }
                    }

                    list.add(new TriplePair(firstIndex, secondIndex, thirdIndex));

                    A[i] = A[thirdIndex];
                    A[thirdIndex] = A[secondIndex];
                    A[secondIndex] = secondIndex + 1;



                } else i++;

                if(i == n) {
                    out.println(m);
                    for (TriplePair pair : list)
                            out.println(pair.first + " " + pair.second + " " + pair.third);
                }

            }
        }


    }
}