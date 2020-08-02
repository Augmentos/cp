//package codeforces;

import java.io.*;
import java.util.*;


public class Watchmen {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(in, out);
        out.close();
    }

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
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
            List<Pair> list = new ArrayList<>();
            HashSet<Pair> set = new HashSet<>();


            while(n-- > 0)  {
                int x = in.nextInt();
                int y = in.nextInt();
                Pair p = new Pair(x,y);
                list.add(p);
            }

            Collections.sort(list, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if(o1.x == o2.x)
                        return o1.y - o2.y;
                    return o1.x - o2.x;
                }
            });

            long pairsFound = 0;

            long dups = 1;

            long count = 1;
            for (int i=1; i<list.size(); i++) {

                if(list.get(i).y == list.get(i-1).y && list.get(i).x == list.get(i-1).x)
                    dups++;
                else if(dups > 1) {
                    pairsFound -= (dups*(dups - 1))/2;
                    dups = 1;
                }

                if(list.get(i).x == list.get(i-1).x) {
                    count++;
                }
                else {
                    pairsFound += (count*(count-1))/2;
                    count = 1;
                }
            }
            pairsFound += (count*(count-1))/2;
            if(dups > 1) pairsFound -=  (dups*(dups - 1))/2;

            Collections.sort(list, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.y - o2.y;
                }
            });

            count = 1;
            for (int i=1; i<list.size(); i++) {
                if(list.get(i).y == list.get(i-1).y)
                    count++;
                else {
                    pairsFound += (count*(count - 1))/2;
                    count = 1;
                }
            }
            pairsFound += (count*(count-1))/2;

            out.println(pairsFound );

        }


    }
}